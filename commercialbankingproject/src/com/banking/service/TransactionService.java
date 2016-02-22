package com.banking.service;

import java.util.Date;
import java.util.List;

import com.banking.model.Transaction;

public interface TransactionService {
	public void addTransaction(Transaction transaction);
	
	public void updateTransaction(Transaction transaction);
	
	public void deleteTransaction(Transaction transaction);
	
	public Transaction getTransactionById(int id);
	
	public List<Transaction> getTransaction();
	
	public List<Transaction> getTransactionByDate(Date startDate, Date endDate);
}
