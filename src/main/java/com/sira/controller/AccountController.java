package com.sira.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.sira.dto.AccountDto;
import com.sira.service.AccountService;

@RestController
@RequestMapping("/api/accounts/")
public class AccountController {

	@Autowired
	private AccountService accountService;

//	public AccountController(AccountService accountService) {
//	
//		this.accountService = accountService;
//	}

	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}

	// deposit Amount
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id, @RequestBody Map<String, Double> request) {

		Double amount = request.get("amount");
		AccountDto accountDto = accountService.depositAmount(id, amount);
		return ResponseEntity.ok(accountDto);
	}
    
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Long id, @RequestBody Map<String, Double> request){
		     Double amount=request.get("amount");
		AccountDto accountDto=accountService.withdrawAmount(id, amount);
		
		return ResponseEntity.ok(accountDto);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AccountDto>> getAllAccountDetails(){
		
		List<AccountDto> accountDto =accountService.getAllAccounts();
		return ResponseEntity.ok(accountDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("account deleted Successfully");
	}
}










