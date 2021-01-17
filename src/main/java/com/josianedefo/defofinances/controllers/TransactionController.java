package com.josianedefo.defofinances.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.josianedefo.defofinances.model.Transaction;
import com.josianedefo.defofinances.model.TransactionRecurrence;
import com.josianedefo.defofinances.repositories.TransactionRecurrenceRepository;
import com.josianedefo.defofinances.repositories.TransactionRepository;
import com.josianedefo.defofinances.util.TransactionRecurrenceType;

@Controller
public class TransactionController {
	
	public TransactionRepository transactionRepository;
	private final TransactionRecurrenceRepository transactionRecurenceRepository;
	
	public TransactionController(TransactionRepository transactionRepository, TransactionRecurrenceRepository transactionRecurenceRepository) {
		this.transactionRepository = transactionRepository;
		this.transactionRecurenceRepository = transactionRecurenceRepository;
	} 
	
	@GetMapping("/transactions")
	public String getTransactions(Model model) {
		model.addAttribute("transactions", this.transactionRepository.findAll());
		return "transactions/list";
	}
	
	@PostMapping("/addtransaction")
	public String addTransaction(@ModelAttribute("transac") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Transaction transac, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
	      System.out.println("Binding has errors: ");
	      System.out.println(bindingResult.getErrorCount());
	      
	      bindingResult
	      .getFieldErrors()
	      .stream()
	      .forEach(f -> System.out.println(f.getField() + ": " + f.getDefaultMessage()));
	      //TODO: add error page for fallback
	    }
		
		model.addAttribute("date", transac.getDate());
		model.addAttribute("amount", transac.getAmount());
		model.addAttribute("type", transac.getType());
		transactionRecurenceRepository.save(transac.getRecurrence());
		transactionRepository.saveAndFlush(transac);
		System.out.println("++++Posted Transaction: "+transac);
		
		return "redirect:/transactions";
	}
	
}
