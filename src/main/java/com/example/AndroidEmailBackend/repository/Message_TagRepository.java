package com.example.AndroidEmailBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AndroidEmailBackend.model.Message_Tag;

@Repository
public interface Message_TagRepository extends JpaRepository<Message_Tag,Long> {

}
