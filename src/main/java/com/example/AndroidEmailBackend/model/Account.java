package com.example.AndroidEmailBackend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="account")
@EntityListeners(AuditingEntityListener.class)
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@OneToMany(mappedBy="account" ,cascade=CascadeType.ALL)//pri briasanju accounta brisu se i sve njegove poruke
	//@JsonBackReference // ne stavlja u json listu postova koja bi kasnije referencirale ne user i tako u krug
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
