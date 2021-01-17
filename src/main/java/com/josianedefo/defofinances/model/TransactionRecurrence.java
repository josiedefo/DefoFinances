package com.josianedefo.defofinances.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.josianedefo.defofinances.util.TransactionRecurrenceType;

@Entity
public class TransactionRecurrence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TransactionRecurrenceType type;
	
	private int dayOfTheMonth; //Contraint 1-31? 	
	
	private String monthsOfTheYear;

	public TransactionRecurrence() {	}
	
	public TransactionRecurrence(TransactionRecurrenceType type, int dayOfTheMonth) {
		this.type = type;
		this.dayOfTheMonth = dayOfTheMonth;
		if(this.type == TransactionRecurrenceType.MONTHLY) {
			this.monthsOfTheYear = "1,2,3,4,5,6,7,8,9,10,11,12";
		}else {
			this.monthsOfTheYear = "";
		}
	}

	
	public TransactionRecurrenceType getType() {
		return type;
	}

	public void setType(TransactionRecurrenceType type) {
		this.type = type;
	}

	public int getDayOfTheMonth() {
		return dayOfTheMonth;
	}

	public void setDayOfTheMonth(int dayOfTheMonth) {
		this.dayOfTheMonth = dayOfTheMonth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonthsOfTheYear() {
		return monthsOfTheYear;
	}

	public void setMonthsOfTheYear(String monthsOfTheYear) {
		this.monthsOfTheYear = monthsOfTheYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		TransactionRecurrence other = (TransactionRecurrence) obj;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransactionRecurrence [type=" + type + ", dayOfTheMonth=" + dayOfTheMonth + ", monthOfTheYear="
				+ monthsOfTheYear + "]";
	}


	
}
