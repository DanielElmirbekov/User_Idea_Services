package com.example.kgitschool.Models.dto;

import com.example.kgitschool.Models.entites.User;
import lombok.Data;

import javax.persistence.Id;


@Data
public class IdeaDTO {
    @Id
    Long id;
    String title;
    String body;
    boolean contactWithMe;
    String phone;
}
