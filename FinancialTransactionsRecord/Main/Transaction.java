package Main;

import java.util.Date;

public abstract class Transaction {
	
	protected String transactionId ="";
	protected String fromAccountId="";
	protected String toAccountId="";
	protected Date createdAt=null;
	protected double amount=0;
	
	public Transaction(String transactionId, String fromAccountId, String toAccountId, Date createdAt, double amount ) {
		this.setTransactionId(transactionId);
		this.setFromAccountId(fromAccountId);
		this.setToAccountId(toAccountId);
		this.setCreatedAt(createdAt);
		this.setAmount(amount);
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public abstract String getTransactionType();
	

}
