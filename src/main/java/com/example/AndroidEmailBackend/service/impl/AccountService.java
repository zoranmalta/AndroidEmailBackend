package com.example.AndroidEmailBackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AndroidEmailBackend.model.Account;
import com.example.AndroidEmailBackend.repository.AccountRepository;
import com.example.AndroidEmailBackend.service.IAccountService;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account getAccountByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	@Override
	public List<Account> findAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public void saveAll(List<Account> list) {
	    accountRepository.saveAll(list);
		
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Optional<Account> getAccountById(Long id) {
		return accountRepository.findById(id);
	}
	
	
	
	
}
