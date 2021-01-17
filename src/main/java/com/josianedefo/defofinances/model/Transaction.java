package com.josianedefo.defofinances.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.josianedefo.defofinances.util.TransactionRecurrenceType;
import com.josianedefo.defofinances.util.TransactionType;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
		
	private LocalDate date;
	private String description; 
	private double amount; 
	
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	
	private String category; 
	private String account; 
	private String notes; 
	
	@OneToOne
    @JoinColumn
	private TransactionRecurrence recurrence;
		
	
	public Transaction() { }

	public Transaction(LocalDate date, double amount, TransactionType type) {
		this.date = date;
		this.description = "";
		this.amount = amount;
		this.type = type;
		this.category = "";
		this.account = "";
		this.notes = "";
		this.recurrence = new TransactionRecurrence(TransactionRecurrenceType.ONETIME, -1);
	}
	
	public Transaction(LocalDate date, String description, double amount, TransactionType type, String category, String account,
			String notes, TransactionRecurrence recurrence) {
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.type = type;
		this.category = category;
		this.account = account;
		this.notes = notes;
		this.recurrence = recurrence;
	}
	
	public Transaction(LocalDate date, String description, double amount, TransactionType type, String category, String account,
			String notes) {
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.type = type;
		this.category = category;
		this.account = account;
		this.notes = notes;
		this.recurrence = new TransactionRecurrence(TransactionRecurrenceType.ONETIME, -1);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransactionType getType() {
		return type;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public TransactionRecurrence getRecurrence() {
		return recurrence;
	}
	public void setRecurrence(TransactionRecurrence recurrence) {
		this.recurrence = recurrence;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Transaction [id=" + id + ", date=" + date + ", description=" + description + ", amount=" + amount
				+ ", type=" + type + ", category=" + category + ", account=" + account + ", notes=" + notes
				+ ", recurrence=" + recurrence + "]";
	}
}
