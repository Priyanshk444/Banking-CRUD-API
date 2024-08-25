package com.bank.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AccountDto;
import com.bank.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountControllers {

	private AccountService accountService;
	
	public AccountControllers(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<> (accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable("id") Long id){
		AccountDto accDto = accountService.getAccountById(id);
		return new ResponseEntity<> (accDto,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> updateBal(@RequestParam("amount") double amount,@PathVariable("id") Long id){
		AccountDto accountDto = accountService.updateBalance(id, amount);
		return new ResponseEntity<> (accountDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAccount(@PathVariable("id") Long id){
		accountService.deleteAccount(id);
	}
}
