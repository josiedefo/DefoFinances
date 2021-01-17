package com.josianedefo.defofinances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josianedefo.defofinances.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
