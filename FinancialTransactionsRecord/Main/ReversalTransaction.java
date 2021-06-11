/**
 * 
 */
package Main;

import java.util.Date;

/**
 * @author mugahedhussain
 *
 */
public class ReversalTransaction extends Transaction{
	
	private final  String transactionType="REVERSAL";
	private Transaction transaction;

	/**
	 * 
	 */
	public ReversalTransaction(String transactionId, String fromAccountId, String toAccountId, Date createdAt, double amount, Transaction transaction) {
		// TODO Auto-generated constructor stub
		super(transactionId, fromAccountId, toAccountId, createdAt, amount);
		this.setTransaction(transaction);

	}

	public String getTransactionType() {
		return transactionType;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
