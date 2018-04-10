package com.kokonatsuDream.userfront.service;

import java.security.Principal;
import java.util.List;

import com.kokonatsuDream.userfront.domain.PrimaryAccount;
import com.kokonatsuDream.userfront.domain.PrimaryTransaction;
import com.kokonatsuDream.userfront.domain.Recipient;
import com.kokonatsuDream.userfront.domain.SavingsAccount;
import com.kokonatsuDream.userfront.domain.SavingsTransaction;

public interface TransactionService {
	List<PrimaryTransaction> findPrimaryTransactionList(String username);
	
	List<SavingsTransaction> findSavingsTransactionList(String username);
	
	void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction);
	
	void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction);
	
	void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction);
	
	void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction);
	
	void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) throws Exception;

	List<Recipient> findRecipientList(Principal principal);

	void saveRecipient(Recipient recipient);

	Recipient findRecipientByName(String recipientName);

	void deleteRecipientByName(String recipientName);
	
}
