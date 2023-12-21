package com.example.contactcrud.services;


import com.example.contactcrud.repositories.ContactDAO;
import com.example.contactcrud.dto.RequestContact;
import com.example.contactcrud.dto.ResponseContact;
import com.example.contactcrud.models.contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import jakarta.mail.internet.MimeMessage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements  ContactService {


   private ContactDAO contactDAO;
   private ModelMapper modelMapper;
    private JavaMailSender javaMailSender;

   @Autowired
    public ContactServiceImpl(ContactDAO contactDAO, ModelMapper modelMapper) {
        this.contactDAO = contactDAO;
        this.modelMapper = modelMapper;

   }


    @Override
    public ResponseContact saveContact(RequestContact requestContact) {
       //conversion du DTO au entite
        contact contact1=modelMapper.map(requestContact,contact.class);
        contact saved=contactDAO.save(contact1);
        //conversion du  entite au DTO pour renvoyer la reponse
        return modelMapper.map(saved,ResponseContact.class);
    }

    @Override
    public ResponseContact findByidContact(Integer id) {
        contact contact=contactDAO.findById(id).orElseThrow(()-> new RuntimeException("Client Not Found"));
        return modelMapper.map(contact,ResponseContact.class);
    }

    @Override
    public void deleteContact(Integer id) {
    contactDAO.deleteById(id);

    }

//    @Override
//    public ResponseContact updateContact(RequestContact requestContact, Integer id) {
//      Optional<contact> contact1=contactDAO.findById(id);
//      if( contact1.isPresent()){
//          contact updated=modelMapper.map(requestContact,contact.class);
//          //si je fais pas setId et donner le id existant ,on aura une entre entree dans la BD au lieu de faire un update
//          updated.setId(id);
//          contactDAO.save(updated);
//          return modelMapper.map(updated,ResponseContact.class);
//      }else{
//          throw new RuntimeException("Contact not found");
//      }
//
//    }

    @Override
    public List<ResponseContact> findAll() {
        return contactDAO.findAll()
                .stream().map(el->modelMapper.map(el,ResponseContact.class))
                .collect(Collectors.toList());
    }

    @Value("${spring.mail.username}")
    private String fromEmail;



    @Override
    public String sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setCc(cc);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);

            for (int i = 0; i < file.length; i++) {
                mimeMessageHelper.addAttachment(
                        file[i].getOriginalFilename(),
                        new ByteArrayResource(file[i].getBytes()));
            }

            javaMailSender.send(mimeMessage);

            return "mail send";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public String findEmail(Integer id) {
        Optional<contact> contact1=contactDAO.findById(id);
        if (contact1.isPresent()) {
            contact contact = contact1.get();
            return contact.getEmail();
        } else {
            throw new RuntimeException("Contact not found");
        }
    }


}
