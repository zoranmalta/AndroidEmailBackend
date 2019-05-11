package com.example.AndroidEmailBackend.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AndroidEmailBackend.model.Account;
import com.example.AndroidEmailBackend.service.impl.AccountService;
import com.example.AndroidEmailBackend.web.dto.AccountDTO;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping(value = "/account/{username}/{password}")
	public ResponseEntity<AccountDTO> getAccount(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		System.out.println(username);
		Account account = accountService.getAccountByUsername(username);
		if (account != null && account.getPassword().equals(password)) {
			System.out.println(account);
			return new ResponseEntity<AccountDTO>(new AccountDTO(account), HttpStatus.OK);
		} else {
			return new ResponseEntity<AccountDTO>( HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(value = "/account/update")
	public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO account) {
		List<Account> list = accountService.findAllAccounts();
		if (list != null) {
			for (Account a : list) {
				if (a.getId() == account.getId()) {
					a.setPassword(account.getPassword());
					a.setUsername(account.getUsername());
					try {
						a=accountService.save(a);
					} catch (Exception e) {
						
						e.printStackTrace();
						return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
					}
					return new ResponseEntity<AccountDTO>(new AccountDTO(a), HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<AccountDTO>(HttpStatus.BAD_REQUEST);
	}
}
