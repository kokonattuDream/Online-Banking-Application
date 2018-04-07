package com.kokonatsuDream.userfront.service;

import com.kokonatsuDream.userfront.domain.PrimaryAccount;
import com.kokonatsuDream.userfront.domain.SavingsAccount;

public interface AccountService {
	
	PrimaryAccount createPrimaryAccount();
	
	SavingsAccount createSavingsAccount();
}

