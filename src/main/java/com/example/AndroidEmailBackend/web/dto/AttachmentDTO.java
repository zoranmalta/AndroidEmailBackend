package com.example.AndroidEmailBackend.web.dto;

import com.example.AndroidEmailBackend.model.Attachment;
import com.example.AndroidEmailBackend.model.Message;

public class AttachmentDTO {

	private Long id;
	private String type;
	private String name;
	
	
	public AttachmentDTO() {}
	
	public AttachmentDTO(Long id, String type, String name) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		
	}
	public AttachmentDTO(Attachment attachment) {
		id=attachment.getId();
		type=attachment.getType();
		name=attachment.getName();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
