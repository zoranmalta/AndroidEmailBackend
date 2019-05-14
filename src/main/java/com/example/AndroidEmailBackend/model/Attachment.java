package com.example.AndroidEmailBackend.model;

import java.util.Base64;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "attachment")
@EntityListeners(AuditingEntityListener.class)
public class Attachment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attachment_id")
	private Long id;

	// Transient ne stavlja property u bazu moze da se stavi i na metodu get
	@Transient
	private Base64 data;

	private String type;

	private String name;

	// @JsonIgnore//ne stavlja u json listu postova koja bi kasnije referencirale ne
	// user i tako u krug
	//@JsonBackReference // stavlja povratnu vrednost attachmenta u messages
	//@OnDelete(action = OnDeleteAction.CASCADE) // pri brisanju message brisu se i njegovi attachmentsi
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "message_id", nullable = false) // pravi kolonu message_id od message.getIds ne sme biti null
	private Message message;
	
	public Attachment() {}

	public Attachment(Long id, Base64 data, String type, String name,
			Message message) {
		super();
		this.id = id;
		this.data = data;
		this.type = type;
		this.name = name;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Base64 getData() {
		return data;
	}

	public void setData(Base64 data) {
		this.data = data;
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

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Attachment [id=" + id + ", data=" + data + ", type=" + type + ", name=" + name + ", message=" + message
				+ "]";
	}
	
	
	
}
