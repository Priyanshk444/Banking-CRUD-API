package com.bank.mapper;

import com.bank.dto.AccountDto;
import com.bank.entities.Account;

public class AccountMapper {

	public static Account accDtoToAcc(AccountDto accountDto) {
		Account account = new Account(accountDto.getId(), accountDto.getAccount_holder_name(), accountDto.getBalance());
		return account;
	}
	
	public static AccountDto accToAccDto(Account account) {
		AccountDto accountDto = new AccountDto(account.getId(), account.getAccount_holder_name(), account.getBalance());
		return accountDto;
	}
	
}
