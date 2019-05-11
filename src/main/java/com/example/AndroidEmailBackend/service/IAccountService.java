package com.example.AndroidEmailBackend.service;

import java.util.List;
import java.util.Optional;

import com.example.AndroidEmailBackend.model.Account;

public interface IAccountService {

	Account getAccountByUsername(String username);
	Optional<Account> getAccountById(Long id);
	List<Account> findAllAccounts();
	void saveAll(List<Account> list);
	Account save(Account account);
	
}
