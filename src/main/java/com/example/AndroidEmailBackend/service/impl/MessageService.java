package com.example.AndroidEmailBackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.AndroidEmailBackend.model.Message;
import com.example.AndroidEmailBackend.repository.MessageRepository;
import com.example.AndroidEmailBackend.service.IMessageService;

@Service
public class MessageService implements IMessageService{
	
	@Autowired
	MessageRepository messageRepository;

	@Override
	public List<Message> getInboxMessages(String sendto) {
		// TODO Auto-generated method stub
		return messageRepository.findBySendto(sendto);
	}

	@Override
	public List<Message> getOutboxMessages(Long id) {
		// TODO Auto-generated method stub
		return messageRepository.findByAccount_id(id);
	}

	@Override
	public Message getMessageById(Long id) {
		Message message=messageRepository.getOne(id);
		return message;
	}

	@Override
	public Message saveMessage(Message message) {
		return messageRepository.save(message);
	}
	public Page<Message> findAll(Pageable pageable){
		return messageRepository.findAll(pageable);
	}
	
	public Page<Message> findBySendto(String sendto,Pageable pageable){
		return messageRepository.findBySendto(sendto, pageable);
	}

	
}
