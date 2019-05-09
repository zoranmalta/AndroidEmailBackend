package com.example.AndroidEmailBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AndroidEmailBackend.model.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Long> {

}
