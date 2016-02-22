package com.banking.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="transactionreport")
public class Transaction {
	
	@Id
	@Column(name="ID" , unique = true, nullable = false)
	@GeneratedValue
	private int id;
	
	@Column(name="TRANSACTION_DATE", nullable = false)
	private Date date;
	
	@Column(name="TRANSACTION_DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name="WITHDRAWALS")
	private BigDecimal withdrawals;
	
	@Column(name="DEPOSITS")
	private float deposits;
	
	@Column(name="BALANCE", nullable = false)
	private float balance;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getWithdrawals() {
		return withdrawals;
	}
	public void setWithdraws(BigDecimal withdraws) {
		this.withdrawals = withdraws;
	}
	public float getDeposits() {
		return deposits;
	}
	public void setDeposits(float deposits) {
		this.deposits = deposits;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	@Override
	 public String toString() {
		  StringBuffer sb = new StringBuffer();
		  sb.append("Bean id : ").append(getId());
		  sb.append(", date : ").append(getDate());
		  sb.append(", description : ").append(getDescription());
		  sb.append(", withdrawals : ").append(getWithdrawals());
		  sb.append(", deposits : ").append(getDeposits());
		  sb.append(", balance : ").append(getBalance());
		  return sb.toString();
	 }
	
}
