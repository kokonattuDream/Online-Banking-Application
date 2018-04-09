package com.kokonatsuDream.userfront.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kokonatsuDream.userfront.domain.PrimaryTransaction;

public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {
	List<PrimaryTransaction> findAll();
}

