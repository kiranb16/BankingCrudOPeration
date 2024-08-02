package com.sira.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sira.dto.AccountDto;
import com.sira.entity.Account;
import com.sira.mapper.AccountMapper;
import com.sira.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);

		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository
				.findById(id).orElseThrow(() -> new RuntimeException("account not Exist"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto depositAmount(Long id, double amount) {
		Account account = accountRepository
				.findById(id).orElseThrow(() -> new RuntimeException("account not Exist"));
		    double total=account.getBalance() + amount;
		   account.setBalance(total);
		   Account savedAccount=accountRepository.save(account);
		   
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdrawAmount(Long id, double amount)  {
		
		Account account = accountRepository
				.findById(id).orElseThrow(() -> new RuntimeException("account not Exist"));
		
		if(account.getBalance()<amount) {
			 throw new RuntimeException("insufficient balance ...");
		}
		    double total=account.getBalance() - amount;
		   account.setBalance(total);
		   Account savedAccount=accountRepository.save(account);
		   
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts= accountRepository.findAll();
	return 	accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		
		 
		
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository
				.findById(id).orElseThrow(() -> new RuntimeException("account not Exist"));
	
		accountRepository.deleteById(id);
		
	}

}




















