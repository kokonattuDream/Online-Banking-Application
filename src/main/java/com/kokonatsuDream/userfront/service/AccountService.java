package com.kokonatsuDream.userfront.service;

import java.security.Principal;

import com.kokonatsuDream.userfront.domain.PrimaryAccount;
import com.kokonatsuDream.userfront.domain.SavingsAccount;

public interface AccountService {
	
	PrimaryAccount createPrimaryAccount();
	
	SavingsAccount createSavingsAccount();
	
	void deposit(String accountType, double amount, Principal principal);
	
	void withdraw(String accountType, double amount, Principal principal);
}

