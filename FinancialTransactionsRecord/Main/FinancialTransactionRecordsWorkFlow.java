package Main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FinancialTransactionRecordsWorkFlow {
	private List<Transaction> allTransactions=new ArrayList<Transaction>();

	public FinancialTransactionRecordsWorkFlow() {
		// TODO Auto-generated constructor stub
	}
	
	public  void run(String accountId, Date from, Date to) throws IOException, ParseException {
	
		//read data form the file
		String [] transactionsData=this.getTransactionsData();
		
		//transaction data digestion 
		this.digesTransactionstData(transactionsData);
		
		//search with an account Id and period 
		this.search(accountId, from, to);
	
		
	}
	

	private String[] getTransactionsData() throws IOException {
		ReadFile radFile=new ReadFile();
		return radFile.read("data");
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
	
	private void search(String accountId, Date from, Date to) {
		
		for(int i=0; i<allTransactions.size(); i++)
			System.out.println(allTransactions.get(i).getTransactionId());

	}
	
	private Transaction findTranscation(String transactionId) {
		Transaction transaction=null;
		for(int i=0; i<allTransactions.size(); i++)
			if(allTransactions.get(i).getTransactionId().equalsIgnoreCase(transactionId))
				transaction= allTransactions.get(i);
		return transaction;
	}

}
