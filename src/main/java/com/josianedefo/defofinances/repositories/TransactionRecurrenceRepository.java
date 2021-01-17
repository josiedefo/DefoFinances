package com.josianedefo.defofinances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josianedefo.defofinances.model.Transaction;
import com.josianedefo.defofinances.model.TransactionRecurrence;
import com.josianedefo.defofinances.util.TransactionRecurrenceType;

public interface TransactionRecurrenceRepository extends JpaRepository<TransactionRecurrence, TransactionRecurrenceType>{

}
