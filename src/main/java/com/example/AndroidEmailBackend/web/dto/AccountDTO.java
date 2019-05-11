package com.example.AndroidEmailBackend.web.dto;

import com.example.AndroidEmailBackend.model.Account;

public class AccountDTO {

	private Long id;
	private String smtp;
	private String pop3;
	private String username;
	private String password;
	
	public AccountDTO() {}

	public AccountDTO(Long id, String smtp, String pop3, String username, String password) {
		super();
		this.id = id;
		this.smtp = smtp;
		this.pop3 = pop3;
		this.username = username;
		this.password = password;
	}
	
	public AccountDTO(Account account) {
		this(account.getId(),account.getSmtp(),account.getPop3(),
				account.getUsername(),account.getPassword());
	}
	//stavio sam samo getere

	public Long getId() {
		return id;
	}

	public String getSmtp() {
		return smtp;
	}

	public String getPop3() {
		return pop3;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
}
