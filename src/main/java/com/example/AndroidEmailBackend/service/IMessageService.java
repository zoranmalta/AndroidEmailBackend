package com.example.AndroidEmailBackend.service;

import java.util.List;
import com.example.AndroidEmailBackend.model.Message;

public interface IMessageService {

	List<Message> getInboxMessages(String sendto);
	List<Message> getOutboxMessages(Long id);
	Message getMessageById(Long id);
	Message saveMessage(Message message);
}
