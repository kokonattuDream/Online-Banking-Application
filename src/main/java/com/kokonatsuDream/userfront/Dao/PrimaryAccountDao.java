package com.kokonatsuDream.userfront.Dao;

import org.springframework.data.repository.CrudRepository;

import com.kokonatsuDream.userfront.domain.PrimaryAccount;
import com.kokonatsuDream.userfront.domain.User;


public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long>{
	PrimaryAccount findByAccountNumber(int accountNumber);

}
