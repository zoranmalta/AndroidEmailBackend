package com.example.AndroidEmailBackend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="account")
@EntityListeners(AuditingEntityListener.class)
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id", unique=true,nullable=false)
	private Long id;
	
	@Column(name="smtp")
	private String smtp;
	
	@Column(name="pop3")
	private String pop3;
	
	@Column(name="username" , unique=true,nullable=false)
	private String username;
	
	@Column(name="password" ,nullable=false)
	private String password;
	
	@OneToMany(mappedBy="account" ,fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Message> messages;
	
	public Account() {}

	public Account(Long id, String smtp, String pop3, String username, String password,
			List<Message> messages) {
		super();
		this.id = id;
		this.smtp = smtp;
		this.pop3 = pop3;
		this.username = username;
		this.password = password;
		this.messages = messages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public String getPop3() {
		return pop3;
	}

	public void setPop3(String pop3) {
		this.pop3 = pop3;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	};
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", smtp=" + smtp + ", username=" + username + ", password=" + password
				+ ", messages=" + messages + "]";
	}
	
	
}
