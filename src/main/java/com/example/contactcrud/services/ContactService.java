package com.example.contactcrud.services;

import com.example.contactcrud.dto.RequestContact;
import com.example.contactcrud.dto.ResponseContact;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ContactService {

  ResponseContact saveContact(RequestContact contact);
  ResponseContact findByidContact(Integer id);
    void deleteContact(Integer id);
//  ResponseContact updateContact(RequestContact contact,Integer id);
  List<ResponseContact> findAll();

  String sendMail(MultipartFile[] file, String to, String[] cc,String subject, String message);

  String findEmail(Integer id);
}
