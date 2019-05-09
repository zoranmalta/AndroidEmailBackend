package com.example.AndroidEmailBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AndroidEmailBackend.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {

}
