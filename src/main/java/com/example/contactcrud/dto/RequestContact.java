package com.example.contactcrud.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestContact {
    private String name;
    private String tele;
    private String Email;
    private String message;

}
