package Main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FinancialTransactionRecordsWorkFlow {
	private List<Transaction> allTransactions=new ArrayList<Transaction>();
	private double balance=0;
	private int numberOfTransactions=0;

	public FinancialTransactionRecordsWorkFlow() {
		// TODO Auto-generated constructor stub
	}
	
	public  String run(String accountId, Date from, Date to, String fileName) throws IOException, ParseException {
	
		//read data form the file
		String [] transactionsData=this.getTransactionsData(fileName);
		
		//transaction data digestion 
		this.digesTransactionstData(transactionsData);
		
		//search with an account Id and period 
		return this.search(accountId, from, to);
	
		
	}
	

	private String[] getTransactionsData(String fileName) throws IOException {
		ReadFile radFile=new ReadFile();
		return radFile.read(fileName);
	}
	
	private void digesTransactionstData(String[] transactionsData) throws ParseException {
		for(int i=0; i<transactionsData.length; i++) {
			String [] transaction = transactionsData[i].trim().split(",");	
			String transactionId=transaction[0].trim();
			String fromAccountId=transaction[1].trim();
			String toAccountId=transaction[2].trim();
			SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			Date date = formatter.parse(transaction[3].trim());
			double amount=Double.parseDouble(transaction[4].trim());

			if(transaction.length==7) {
				String refersedlTransactionId=transaction[6].trim();
				Transaction t=this.findTranscation(refersedlTransactionId);
				allTransactions.add(new ReversalTransaction(transactionId, fromAccountId,toAccountId, date, amount,t));
				
			}else if(transaction.length==6) {
				allTransactions.add(new PaymentTransaction(transactionId, fromAccountId, toAccountId,date, amount));

			}
		}		
	}
	
	private String search(String accountId, Date from, Date to) {
		String str ="Relative balance for the period is: ";
		this.transferTo(accountId, from, to);
		this.transferFrom(accountId, from, to);
		
		str+=balance+"\n"+"Number of transactions included is: "+numberOfTransactions;
		return str;

	}
	
	private void transferFrom(String accountId, Date from, Date to) {
		for (int i=0; i<this.allTransactions.size(); i++) {
			if(this.allTransactions.get(i).getFromAccountId().equalsIgnoreCase(accountId)){
				if(this.getAllTransactions().get(i) instanceof PaymentTransaction && this.allTransactions.get(i).getCreatedAt().after(from)&&this.allTransactions.get(i).getCreatedAt().before(to)) {
					balance=balance-this.allTransactions.get(i).getAmount();
					numberOfTransactions=numberOfTransactions+1;
				}
				else if (this.getAllTransactions().get(i) instanceof ReversalTransaction) {
					balance=balance+this.getAllTransactions().get(i).getAmount();
					numberOfTransactions=numberOfTransactions-1;
				}
			}
		}
		
	}

	private void transferTo(String accountId, Date from, Date to) {
		for (int i=0; i<this.allTransactions.size(); i++) {
			if(this.allTransactions.get(i).getToAccountId().equalsIgnoreCase(accountId)){
				if(this.getAllTransactions().get(i) instanceof PaymentTransaction && this.allTransactions.get(i).getCreatedAt().after(from)&&this.allTransactions.get(i).getCreatedAt().before(to)) {
					balance=balance+this.allTransactions.get(i).getAmount();
					numberOfTransactions=numberOfTransactions+1;
				}
				else if (this.getAllTransactions().get(i) instanceof ReversalTransaction) {
					balance=balance-this.getAllTransactions().get(i).getAmount();
					numberOfTransactions=numberOfTransactions-1;
				}
			}
		}
		
	}

	private Transaction findTranscation(String transactionId) {
		Transaction transaction=null;
		for(int i=0; i<allTransactions.size(); i++)
			if(allTransactions.get(i).getTransactionId().equalsIgnoreCase(transactionId))
				transaction= allTransactions.get(i);
		return transaction;
	}
	
	public List<Transaction> getAllTransactions(){
		return this.allTransactions;
	}

}
