package com.banking.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.banking.dao.TransactionDAO;
import com.banking.model.Transaction;

@Transactional(readOnly = true)
public class TransactionServiceImpl implements TransactionService{
	
	//Inject TransactionDAO
	TransactionDAO transactionDAO;
	
	public TransactionDAO getTransactionDAO() {
		return transactionDAO;
	}

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}

	@Transactional(readOnly = false)
	@Override
	public void addTransaction(Transaction transaction) {
		getTransactionDAO().addTransaction(transaction);		
	}

	@Transactional(readOnly = false)
	@Override
	public void updateTransaction(Transaction transaction) {
		getTransactionDAO().updateTransaction(transaction);		
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteTransaction(Transaction transaction) {
		getTransactionDAO().deleteTransaction(transaction);		
	}

	@Override
	public Transaction getTransactionById(int id) {
		return getTransactionDAO().getTransactionById(id);
	}

	@Override
	public List<Transaction> getTransaction() {
		return getTransactionDAO().getTransaction();
	}

	@Override
	public List<Transaction> getTransactionByDate(Date startDate, Date endDate) {
		return getTransactionDAO().getTransactionByDate(startDate, endDate);
	}

}
