package com.kokonatsuDream.userfront.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kokonatsuDream.userfront.domain.SavingsTransaction;

public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {
	List<SavingsTransaction> findAll();
}
