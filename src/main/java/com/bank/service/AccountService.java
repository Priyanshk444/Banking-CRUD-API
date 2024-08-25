package com.bank.service;


import com.bank.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(Long id);
	
	AccountDto updateBalance(Long id,double amt);
	
	void deleteAccount(Long id);

}
