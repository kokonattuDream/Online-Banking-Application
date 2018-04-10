package com.kokonatsuDream.userfront.service.UserServiceImpl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kokonatsuDream.userfront.Dao.PrimaryAccountDao;
import com.kokonatsuDream.userfront.Dao.PrimaryTransactionDao;
import com.kokonatsuDream.userfront.Dao.RecipientDao;
import com.kokonatsuDream.userfront.Dao.SavingsAccountDao;
import com.kokonatsuDream.userfront.Dao.SavingsTransactionDao;
import com.kokonatsuDream.userfront.domain.PrimaryAccount;
import com.kokonatsuDream.userfront.domain.PrimaryTransaction;
import com.kokonatsuDream.userfront.domain.Recipient;
import com.kokonatsuDream.userfront.domain.SavingsAccount;
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
	
	@Autowired
	private PrimaryAccountDao primaryAccountDao;
	@Autowired
	private SavingsAccountDao savingsAccountDao;
	
	@Autowired
	private RecipientDao recipientDao;
	
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
	
	public void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) throws Exception{
		
		if(transferFrom.equalsIgnoreCase("Primary") && transferTo.equalsIgnoreCase("Savings")) {
			primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
			savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));
			
			primaryAccountDao.save(primaryAccount);
			savingsAccountDao.save(savingsAccount);
			
			Date date = new Date();
			
			PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Between account transfer from " + transferFrom + " to " + transferTo, "Account", "Finished", Double.parseDouble(amount), primaryAccount.getAccountBalance(), primaryAccount);
			
			primaryTransactionDao.save(primaryTransaction);
		} else if(transferFrom.equalsIgnoreCase("Savings") && transferTo.equalsIgnoreCase("Primary")) {
			primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
			savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
			
			primaryAccountDao.save(primaryAccount);
			savingsAccountDao.save(savingsAccount);
			
			Date date = new Date();
			
			SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Between account transfer from " + transferFrom + " to " + transferTo, "Account", "Finished", Double.parseDouble(amount), savingsAccount.getAccountBalance(), savingsAccount);
			
			savingsTransactionDao.save(savingsTransaction);
		} else {
			throw new Exception("Invalid Transfer");
		}
	}

	@Override
	public List<Recipient> findRecipientList(Principal principal) {
		String username = principal.getName();
		List<Recipient> recipientList = recipientDao.findAll().stream()
				.filter(recipient -> username.equals(recipient.getUser().getUsername()))
				.collect(Collectors.toList());
		
		return recipientList;
	}

	@Override
	public void saveRecipient(Recipient recipient) {
		recipientDao.save(recipient);
	}

	@Override
	public Recipient findRecipientByName(String recipientName) {
		return recipientDao.findByname(recipientName);
	}

	@Override
	public void deleteRecipientByName(String recipientName) {
		recipientDao.deleteByName(recipientName);
		
	}
}
