package com.sira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sira.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
