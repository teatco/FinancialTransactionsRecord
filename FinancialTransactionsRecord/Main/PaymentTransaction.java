package Main;

import java.util.Date;

public class PaymentTransaction extends Transaction {
	
	private final  String transactionType="PAYMENT";


	public PaymentTransaction(String transactionId, String fromAccountId, String toAccountId, Date createdAt, double amount) {
		// TODO Auto-generated constructor stub
		super(transactionId, fromAccountId, toAccountId, createdAt, amount);
	}


	public String getTransactionType() {
		return transactionType;
	}

}
