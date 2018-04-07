package com.kokonatsuDream.userfront.Dao;

import org.springframework.data.repository.CrudRepository;

import com.kokonatsuDream.userfront.domain.SavingsAccount;
import com.kokonatsuDream.userfront.domain.User;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long>{
	SavingsAccount findByAccountNumber(int accountNumber);
}
