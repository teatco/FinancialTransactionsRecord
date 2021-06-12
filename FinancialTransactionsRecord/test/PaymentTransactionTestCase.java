package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Main.PaymentTransaction;
import Main.Transaction;

class PaymentTransactionTestCase {

	@Test
	void testConstructor() throws ParseException {
		String transactionId ="TX10001";
		 String fromAccountId="ACC334455";
		 String toAccountId="ACC778899";
		 SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date createdAt=formatter.parse("20/10/2018 18:00:00");
		 double amount=25.0;
		 Transaction paymentTransaction=new PaymentTransaction(transactionId, fromAccountId, toAccountId,createdAt, amount);
		 String paymentType=paymentTransaction.getTransactionType();
		 
		 assertEquals(transactionId, paymentTransaction.getTransactionId());
		 assertEquals(fromAccountId, paymentTransaction.getFromAccountId());
		 assertEquals(toAccountId, paymentTransaction.getToAccountId());
		 assertEquals(amount, paymentTransaction.getAmount());
		 assertEquals(createdAt, paymentTransaction.getCreatedAt());
		 assertEquals(paymentType,"PAYMENT");
		 		 
	}
	
	@Test
	void testGetTransactionType() throws ParseException {
		String transactionId ="TX10001";
		 String fromAccountId="ACC334455";
		 String toAccountId="ACC778899";
		 SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date createdAt=formatter.parse("20/10/2018 18:00:00");
		 double amount=25.0;
		 Transaction paymentTransaction=new PaymentTransaction(transactionId, fromAccountId, toAccountId,createdAt, amount);
		 
		 String paymentType=paymentTransaction.getTransactionType();
		 
		
		 assertTrue("PAYMENT"==paymentType);
		 
	}


}
