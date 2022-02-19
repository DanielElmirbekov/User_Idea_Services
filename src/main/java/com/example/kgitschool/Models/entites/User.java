package com.example.kgitschool.Models.entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    Long id;
    String phone;
    String code;
    boolean activated;
}
/*echo "# User_Idea_Services" >> README.md
        git init
        git add README.md
        git commit -m "first commit"
        git branch -M main
        git remote add origin https://github.com/DanielElmirbekov/User_Idea_Services.git
        git push - ты главный*/