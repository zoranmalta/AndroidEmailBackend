package com.example.AndroidEmailBackend.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AndroidEmailBackend.model.Account;
import com.example.AndroidEmailBackend.model.Message;
import com.example.AndroidEmailBackend.service.impl.AccountService;
import com.example.AndroidEmailBackend.service.impl.MessageService;
import com.example.AndroidEmailBackend.web.dto.MessageDTO;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	MessageService messageService;

	@Autowired
	AccountService accountService;

	@GetMapping(value = "/inboxmessages/{username}")
	public ResponseEntity<List<MessageDTO>> getInboxMessages(@PathVariable("username") String username) {

		List<Message> messages = new ArrayList<>();
		List<MessageDTO> messagesDto=new ArrayList<>();
		try {
			messages = messageService.getInboxMessages(username);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<MessageDTO>>( HttpStatus.BAD_REQUEST);
		}
		for(Message m :messages) {
			MessageDTO mdto=new MessageDTO(m);
			messagesDto.add(mdto);
		}

		return new ResponseEntity<List<MessageDTO>>(messagesDto , HttpStatus.OK);
	}

	@GetMapping(value = "/outboxmessages/{id}")
	public ResponseEntity<List<MessageDTO>> getOutboxMessages(@PathVariable("id") Long account_id) {

		Optional<Account> account = accountService.getAccountById(account_id);
		System.out.println(account);
		if(account.toString().equals("Optional.empty")) {
			return new ResponseEntity<List<MessageDTO>>(HttpStatus.NOT_FOUND);
		}
		
		List<Message> messages = new ArrayList<>();
		List<MessageDTO> messagesDto=new ArrayList<>();
		try {
			messages = messageService.getOutboxMessages(account_id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<MessageDTO>>(HttpStatus.BAD_REQUEST);
		}
		for(Message m:messages) {
			MessageDTO mdto=new MessageDTO(m);
			messagesDto.add(mdto);
		}

		return new ResponseEntity<List<MessageDTO>>(messagesDto, HttpStatus.OK);
	}
	
	@GetMapping(value="/message/{id}")
	public ResponseEntity<MessageDTO> getOneMessageById(@PathVariable("id") Long id){
	
			Message message;
			try {
				message = messageService.getMessageById(id);
				MessageDTO mdto=new MessageDTO(message);
				return new ResponseEntity<MessageDTO>(mdto,HttpStatus.OK);
			} catch (Exception e) {
				
				e.printStackTrace();
				return new ResponseEntity<MessageDTO>(HttpStatus.NOT_FOUND);
			}
	}
	
	@PostMapping(value="/addmessage")
	public ResponseEntity<MessageDTO> addMessage(@RequestBody MessageDTO messageDto){
		//a new message must have Account
		
		if(messageDto.getAccountDto()==null) {
			System.out.println("prva");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Account> account=accountService.getAccountById(messageDto.getAccountDto().getId());
		if(account==null) {
			System.out.println("druga");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Account a=account.get();
		Message message=new Message();
		message.setAccount(a);
		message.setSendto(messageDto.getSendto());
		message.setSendbc(messageDto.getSendbc());
		message.setSendcc(messageDto.getSendcc());
		message.setSubject(messageDto.getSubject());
		message.setContent(messageDto.getContent());
		try {
			message=messageService.saveMessage(message);
			return new ResponseEntity<MessageDTO>(new MessageDTO(message),HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("treca");
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
