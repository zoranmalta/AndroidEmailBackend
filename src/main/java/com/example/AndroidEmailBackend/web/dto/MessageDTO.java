package com.example.AndroidEmailBackend.web.dto;

import java.util.Date;
import java.util.List;

import com.example.AndroidEmailBackend.model.Message;

public class MessageDTO {
	
	private Long id;
	private String sendto;
	private String sendcc;
	private String sendbc;
	private String subject;
	private String content;
	private Date date;
	private AccountDTO accountDto;
	private List<AttachmentDTO> attachments;
	
	public MessageDTO() {}

	//pomocu konstruktora transformisemo message u messageDto
	public MessageDTO(Message message) {
		id=message.getId();
		sendto=message.getSendto();
		sendcc=message.getSendcc();
		sendbc=message.getSendbc();
		subject=message.getSubject();
		content=message.getContent();
		date=message.getDate();
		accountDto=new AccountDTO(message.getAccount());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSendto() {
		return sendto;
	}

	public void setSendto(String sendto) {
		this.sendto = sendto;
	}

	public String getSendcc() {
		return sendcc;
	}

	public void setSendcc(String sendcc) {
		this.sendcc = sendcc;
	}

	public String getSendbc() {
		return sendbc;
	}

	public void setSendbc(String sendbc) {
		this.sendbc = sendbc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AccountDTO getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AccountDTO accountDto) {
		this.accountDto = accountDto;
	}

	public List<AttachmentDTO> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<AttachmentDTO> attachments) {
		this.attachments = attachments;
	}
	

}
