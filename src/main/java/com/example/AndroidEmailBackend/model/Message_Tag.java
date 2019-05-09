package com.example.AndroidEmailBackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="message_tag")
public class Message_Tag {
	
	@Id
	@GeneratedValue
	@Column(name="message_tag_id")
	private Long id;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Message message;
	
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private Tag tag;
	
	public Message_Tag() {}
	
	

	public Message_Tag(Long id, Message message, Tag tag) {
		super();
		this.id = id;
		this.message = message;
		this.tag = tag;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	
	
}
