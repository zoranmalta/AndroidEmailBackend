package com.example.AndroidEmailBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AndroidEmailBackend.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByUsername(String username);
	//Optional isto vraca Account ali ako ga nema vraca null
	Optional<Account> findById(Long id);
}
