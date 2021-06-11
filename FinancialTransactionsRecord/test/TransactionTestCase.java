package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Main.PaymentTransaction;
import Main.Transaction;

class TransactionTestCase {

	@Test
	void test() throws ParseException {
		String transactionId ="TX10001";
		 String fromAccountId="ACC334455";
		 String toAccountId="ACC778899";
		 SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date createdAt=formatter.parse("20/10/2018 18:00:00");
		 double amount=25.0;
		 Transaction transaction=new PaymentTransaction(transactionId, fromAccountId, toAccountId,createdAt, amount);
		 
		 assertEquals(transactionId, transaction.getTransactionId());
		 assertEquals(fromAccountId, transaction.getFromAccountId());
		 assertEquals(toAccountId, transaction.getToAccountId());
		 assertEquals(amount, transaction.getAmount());
		 assertEquals(createdAt, transaction.getCreatedAt());
	}

}
