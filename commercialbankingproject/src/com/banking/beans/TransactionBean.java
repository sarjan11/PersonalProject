package com.banking.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;




import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.dao.DataAccessException;

import com.banking.model.Transaction;
import com.banking.service.TransactionService;


@ManagedBean(name="transactionBean")
@SessionScoped
public class TransactionBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	//Inject TransactionService 
	@ManagedProperty(value="#{transactionServiceImpl}")
	TransactionService transactionService;
	
	List<Transaction> transactionList;
	
	/*@PostConstruct
	public void init(){
		transactionList = transactionService.getTransactionByDate(startDate, endDate);
	}*/
	
	private int id;
	private Date date;
	private String description;
	private BigDecimal withdrawals;
	private float deposits;
	private float balance;
	
	private Date startDate;
	private Date endDate;
	
	
	public String addTransaction(){
		try{
			Transaction transaction = new Transaction();
			//transaction.setId(getId());
			transaction.setDate(getDate());
			transaction.setDescription(getDescription());
			transaction.setWithdraws(getWithdrawals());
			transaction.setDeposits(getDeposits());
			transaction.setBalance(getBalance());
			getTransactionService().addTransaction(transaction);
			return SUCCESS;
			
		}catch(DataAccessException e){
			e.printStackTrace();
		}
		
		return ERROR;	
	}
	
	public void resetField(){
		//this.setId(0);
		this.setDate(null);
		this.setDescription("");
		this.setWithdrawals(null);
		this.setDeposits(0);
		this.setBalance(0);
	}
	
	
	/*Setter and Getter*/
	
	public TransactionService getTransactionService() {
		return transactionService;
	}
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
/*	public List<Transaction> getTransactionList() {
		
		
		
		transactionList = new ArrayList<Transaction>();
		//transactionList.addAll(getTransactionService().getTransaction());
		transactionList.addAll(getTransactionService().getTransactionByDate(startDate, endDate));
		System.out.println("The list: " + transactionList);
	//	System.out.println("The date: " + startDate + " " + endDate);
		System.out.println("ID:" + id + "Des: " + description);
		return transactionList;
	}*/
	
	public List<Transaction> getTransactionList() {
		transactionList = new ArrayList<Transaction>();
		transactionList.addAll(getTransactionService().getTransaction());
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	
	
	
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
	public void setWithdrawals(BigDecimal withdrawals) {
		this.withdrawals = withdrawals;
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
	
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
