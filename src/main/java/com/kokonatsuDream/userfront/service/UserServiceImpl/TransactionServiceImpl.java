package com.kokonatsuDream.userfront.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kokonatsuDream.userfront.Dao.PrimaryTransactionDao;
import com.kokonatsuDream.userfront.Dao.SavingsAccountDao;
import com.kokonatsuDream.userfront.Dao.SavingsTransactionDao;
import com.kokonatsuDream.userfront.domain.PrimaryTransaction;
import com.kokonatsuDream.userfront.domain.SavingsTransaction;
import com.kokonatsuDream.userfront.domain.User;
import com.kokonatsuDream.userfront.service.TransactionService;
import com.kokonatsuDream.userfront.service.UserService;



@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PrimaryTransactionDao primaryTransactionDao;
	@Autowired
	private SavingsTransactionDao savingsTransactionDao;
	
	public List<PrimaryTransaction> findPrimaryTransactionList(String username){
		
		User user = userService.findByUsername(username);
		
		List<PrimaryTransaction> primaryTransactionList = user.getPrimaryAccount().getPrimaryTransactionList();
		
		return primaryTransactionList;
	}
	
	public List<SavingsTransaction> findSavingsTransactionList(String username){
		
		User user = userService.findByUsername(username);
		
		List<SavingsTransaction> savingsTransactionList = user.getSavingsAccount().getSavingsTransactionList();
		
		return savingsTransactionList;
	}
	
	public void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction) {
		primaryTransactionDao.save(primaryTransaction);
	}
	
	public void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction) {
		savingsTransactionDao.save(savingsTransaction);
	}
	
	public void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction) {
		primaryTransactionDao.save(primaryTransaction);
	}
	
	public void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction) {
		savingsTransactionDao.save(savingsTransaction);
	}
}
