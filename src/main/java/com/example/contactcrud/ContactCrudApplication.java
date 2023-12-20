package com.example.contactcrud;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactCrudApplication.class, args);
    }

    @Bean
     public ModelMapper modalMapper(){
        return  new ModelMapper();
    }
}
