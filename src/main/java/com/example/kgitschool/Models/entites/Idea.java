package com.example.kgitschool.Models.entites;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Idea {
    @Id
    Long id;
    String title;
    String text;
    boolean contactWithMe;
    String phone;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
