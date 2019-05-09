package com.example.AndroidEmailBackend.service;

import java.util.List;

import com.example.AndroidEmailBackend.model.Account;

public interface IAccountService {

	Account getAccountByUsername(String username);
	List<Account> findAllAccounts();
	void saveAll(List<Account> list);
	
}
