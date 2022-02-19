package com.example.kgitschool.dao;

import com.example.kgitschool.Models.entites.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepo extends JpaRepository<Idea,Long> {
}
