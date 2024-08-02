package com.sira.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
	private long id;
	private String accountHolder;
	private double balance;

}
