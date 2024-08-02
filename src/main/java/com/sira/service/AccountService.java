package com.sira.service;

import java.util.List;

import com.sira.dto.AccountDto;
import com.sira.entity.Account;

public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(Long id);
	
	AccountDto depositAmount(Long id, double amount);
	
	AccountDto withdrawAmount(Long id, double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccount(Long id);
}
