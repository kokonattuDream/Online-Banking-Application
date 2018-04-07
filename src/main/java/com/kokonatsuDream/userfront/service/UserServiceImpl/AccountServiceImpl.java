package com.kokonatsuDream.userfront.service.UserServiceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.kokonatsuDream.userfront.Dao.PrimaryAccountDao;
import com.kokonatsuDream.userfront.Dao.SavingsAccountDao;
import com.kokonatsuDream.userfront.domain.PrimaryAccount;
import com.kokonatsuDream.userfront.domain.SavingsAccount;
import com.kokonatsuDream.userfront.service.AccountService;
import com.kokonatsuDream.userfront.service.UserService;

public class AccountServiceImpl implements AccountService {

	private static int nextAccountNumber = 1314142;
	@Autowired
	private PrimaryAccountDao primaryAccountDao;
	@Autowired
	private SavingsAccountDao savingsAccountDao;
	@Autowired
	private UserService userService;
	
	@Override
	public PrimaryAccount createPrimaryAccount() {
		// TODO Auto-generated method stub
		PrimaryAccount primaryAccount = new PrimaryAccount();
		
		primaryAccount.setAccountBalance(new BigDecimal(0.0));
		primaryAccount.setAccountNumber(accountGen());
		
		primaryAccountDao.save(primaryAccount);
		
		return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
	}

	@Override
	public SavingsAccount createSavingsAccount() {
		// TODO Auto-generated method stub
		SavingsAccount savingAccount = new SavingsAccount();
		
		savingAccount.setAccountBalance(new BigDecimal(0.0));
		savingAccount.setAccountNumber(accountGen());
		
		savingsAccountDao.save(savingAccount);
		
		return savingsAccountDao.findByAccountNumber(savingAccount.getAccountNumber());
	}
	
	private int accountGen() {
		return nextAccountNumber++;
	}

}
