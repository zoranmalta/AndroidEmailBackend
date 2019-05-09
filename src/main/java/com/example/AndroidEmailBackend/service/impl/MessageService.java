package com.example.AndroidEmailBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		return messageRepository.findBySendto(sendto);
	}

	@Override
	public List<Message> getOutboxMessages(Long account_id) {
		return messageRepository.findByAccount_id(account_id);
	}
	
}
