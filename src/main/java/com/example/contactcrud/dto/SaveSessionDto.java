package com.example.summerschool.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveSessionDto {

    private String title;
    private String insight ;
    private String requirements;
    private Integer organizerID;
}
