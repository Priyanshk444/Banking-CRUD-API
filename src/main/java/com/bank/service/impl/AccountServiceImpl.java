package com.bank.service.impl;

import org.springframework.stereotype.Service;

import com.bank.dto.AccountDto;
import com.bank.entities.Account;
import com.bank.mapper.AccountMapper;
import com.bank.repository.AccountRepository;
import com.bank.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		return AccountMapper.accToAccDto(accountRepository.save(AccountMapper.accDtoToAcc(accountDto)));
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
		return AccountMapper.accToAccDto(account);
	}

	@Override
	public AccountDto updateBalance(Long id, double amt) {
		Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
		account.setBalance(amt+account.getBalance());
		Account account2 = accountRepository.save(account);
		return AccountMapper.accToAccDto(account2);
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}

}
