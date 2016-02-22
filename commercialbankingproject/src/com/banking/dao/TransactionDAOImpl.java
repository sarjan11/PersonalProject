package com.banking.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.banking.model.Transaction;


public class TransactionDAOImpl implements TransactionDAO{
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		getSessionFactory().getCurrentSession().save(transaction);	
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		getSessionFactory().getCurrentSession().update(transaction);
	}

	@Override
	public void deleteTransaction(Transaction transaction) {
		getSessionFactory().getCurrentSession().delete(transaction);
	}

	@Override
	public Transaction getTransactionById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Transaction where id = ?")
											.setParameter(0, id).list();
		return (Transaction)list.get(0);
	}

	@Override
	public List<Transaction> getTransaction() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Transaction").list();
		return list;
	}
	
	
	@Override
	public List<Transaction> getTransactionByDate(Date startDate, Date endDate) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Transaction where date between ? and ?")
											.setParameter(0, startDate)
											.setParameter(1, endDate)
											.list();
		return list;
	}
	
}
