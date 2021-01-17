package com.josianedefo.defofinances.bootstrap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.josianedefo.defofinances.model.Transaction;
import com.josianedefo.defofinances.model.TransactionRecurrence;
import com.josianedefo.defofinances.repositories.TransactionRecurrenceRepository;
import com.josianedefo.defofinances.repositories.TransactionRepository;
import com.josianedefo.defofinances.util.TransactionRecurrenceType;
import com.josianedefo.defofinances.util.TransactionType;

@Component
public class BootstrapData implements CommandLineRunner {
	private final TransactionRepository transactionRepository;
	private final TransactionRecurrenceRepository transactionRecurenceRepository;

	public BootstrapData(TransactionRepository transactionRepository, TransactionRecurrenceRepository transactionRecurenceRepository) {
		this.transactionRepository = transactionRepository;
		this.transactionRecurenceRepository = transactionRecurenceRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		TransactionRecurrence oneTimeRecurrence = new TransactionRecurrence(TransactionRecurrenceType.ONETIME, -1);
		transactionRecurenceRepository.save(oneTimeRecurrence);
		
		TransactionRecurrence mortgageBillRecurrence = new TransactionRecurrence(TransactionRecurrenceType.MONTHLY, 1);
		transactionRecurenceRepository.save(mortgageBillRecurrence);
		
		TransactionRecurrence energyBillRecurrence = new TransactionRecurrence(TransactionRecurrenceType.MONTHLY, 8);
		transactionRecurenceRepository.save(energyBillRecurrence);
		
		
		TransactionRecurrence carInsuranceBillRecurrence = new TransactionRecurrence(TransactionRecurrenceType.BIANNUAL, 25);
		String carInsuranceBillRecurrenceMonths = "2,8";
		carInsuranceBillRecurrence.setMonthsOfTheYear(carInsuranceBillRecurrenceMonths);
		transactionRecurenceRepository.save(carInsuranceBillRecurrence);
		
		Transaction transaction = new Transaction(); 
		transaction.setDate(LocalDate.of(2021, 1, 15));
		transaction.setDescription("COSTCO GAS #0439 AURORA CO P00301015617403163 CARD 5362");
		transaction.setAmount(28.32);
		transaction.setType(TransactionType.DEBIT);
		transaction.setCategory("AUTO_FUEL&GAZ");
		transaction.setAccount("WF Checkings");
		transaction.setNotes("Gaz for Avalon");
		transaction.setRecurrence(oneTimeRecurrence);
		transactionRepository.save(transaction);
		
		Transaction t2 = new Transaction(LocalDate.of(2021, 1, 18), "COSTCO WHSE #0439 AURORA CO P00301016062764215 CARD 5362", 87.90, TransactionType.CREDIT, "GIFT", "WF Checkings", "Courses for Daniel birthday", oneTimeRecurrence);
		transactionRepository.save(t2);
		
		Transaction t3 = new Transaction(LocalDate.of(2021, 1, 15), "COSTCO WHSE #0439 AURORA CO P00301016049664470 CARD 5362", 10.75, TransactionType.CREDIT, "RESTAURANTS", "WF Checkings", "Pizza", oneTimeRecurrence);
		transactionRepository.save(t3);
		
		Transaction t4 = new Transaction(LocalDate.of(2021, 1, 15), "ATM 9926L ILLIFF & BU Aurora CO CARD9232", 240.00, TransactionType.DEBIT, "GIFT", "WF Checkings", "Money for Cameroon + Ade Family sad news", oneTimeRecurrence);
		transactionRepository.save(t4);
		
		Transaction mortgageOfJan2021 = new Transaction(LocalDate.of(2021, 1, 1), "AMERISAVE", 1640.00, TransactionType.DEBIT, "MORTGAGE", "Family Checking", "House Mortgage", mortgageBillRecurrence);
		transactionRepository.save(mortgageOfJan2021);
		
		Transaction energyPaymentOfJan2021 = new Transaction(LocalDate.of(2021, 1, 8), "EXCEL ENERGY OC COLORADO", 157.35, TransactionType.DEBIT, "HOME_ENERGY", "Family Checking", "Energy Bill for Janury", energyBillRecurrence);
		transactionRepository.save(energyPaymentOfJan2021);
		
		Transaction carInsuranceFirstPaymentOf2021 = new Transaction(LocalDate.of(2021, 2, 25), "AMERISAVE", 1385.76, TransactionType.DEBIT, "CAR_INSURANCE", "Family Checkings", "Car insurance", carInsuranceBillRecurrence);
		transactionRepository.save(carInsuranceFirstPaymentOf2021);
		
		System.out.println("Welcome to Bootstrap data");
		System.out.println("Number of transactions: "+transactionRepository.count());
	}

}
