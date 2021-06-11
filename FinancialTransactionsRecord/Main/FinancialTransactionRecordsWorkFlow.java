package Main;

import java.io.IOException;
import java.util.*;

public class FinancialTransactionRecordsWorkFlow {
	private List<Transaction> allTransactions=new ArrayList<Transaction>();

	public FinancialTransactionRecordsWorkFlow() {
		// TODO Auto-generated constructor stub
	}
	
	public  void run(String accountId, Date from, Date to) throws IOException {
	
		//read data form the file
		String [] data=this.getData();
		
		//data digestion 
		this.digestData(data);
		
		//search 
		this.search(accountId, from, to);
	
		
	}
	

	private String[] getData() throws IOException {
		ReadFile rf=new ReadFile();
		return rf.read();
	}
	
	private void digestData(String[] transactions) {
		for(int i=0; i<transactions.length; i++) {
			String [] transaction = transactions[i].trim().split(",");	
			if(transaction.length==7) {
				for(int j=0; j<transaction.length;j++) {
					Transaction t=this.findTranscation(transaction[6].trim());
					allTransactions.add(new ReversalTransaction(transaction[0].trim(), transaction[0].trim(),transaction[0].trim(),new Date(), 0,t));
					//System.out.println(t.getAmount());
				}
			}else if(transaction.length==6) {
				allTransactions.add(new PaymentTransaction(transaction[0].trim(), transaction[0].trim(),transaction[0].trim(),new Date(), 0));

			}
		}		
	}
	
	private void search(String accountId, Date from, Date to) {
		// TODO Auto-generated method stub
		
	}
	
	private Transaction findTranscation(String transactionId) {
		Transaction transaction=null;
		for(int i=0; i<allTransactions.size(); i++)
			if(allTransactions.get(i).getTransactionId().equalsIgnoreCase(transactionId))
				transaction= allTransactions.get(i);
		return transaction;
	}

}
