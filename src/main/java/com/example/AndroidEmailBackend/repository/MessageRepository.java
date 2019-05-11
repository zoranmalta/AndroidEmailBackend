package com.example.AndroidEmailBackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AndroidEmailBackend.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

	List<Message>  findBySendtoOrAccount_id(String sendto , Long account_id);
	List<Message> findBySendto(String sendto);
	List<Message> findByAccount_id(Long account_id);
	Optional<Message> findById(Long id);
}
