package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Main.*;

class ReversalTransactionTestCase {

	@Test
	void test() throws ParseException {
		 String paymentTransactionId ="TX10001";
		 String payemntFromAccountId="ACC334455";
		 String paymentToAccountId="ACC778899";
		 SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date PaymentCreatedAt=formatter.parse("20/10/2018 18:00:00");
		 double PayemntAmount=25.0;
		 Transaction paymentTransaction=new PaymentTransaction(paymentTransactionId, payemntFromAccountId, paymentToAccountId,PaymentCreatedAt, PayemntAmount);
		 
		 String reversalTransactionId ="TX10002";
		 String preversalFromAccountId="ACC334455";
		 String reversalToAccountId="ACC778899";
		 Date reversalCreatedAt=formatter.parse("21/10/2018 18:00:00");
		 double reversalAmount=25.0;
		 Transaction reversalTransaction=new ReversalTransaction(reversalTransactionId, preversalFromAccountId,reversalToAccountId, reversalCreatedAt, reversalAmount, paymentTransaction);
				 
		 assertEquals(reversalTransactionId, reversalTransaction.getTransactionId());
		 assertEquals(preversalFromAccountId, reversalTransaction.getFromAccountId());
		 assertEquals(reversalToAccountId, reversalTransaction.getToAccountId());
		 assertEquals(reversalAmount, reversalTransaction.getAmount());
		 assertEquals(reversalCreatedAt, reversalTransaction.getCreatedAt());
		 assertEquals("REVERSAL", reversalTransaction.getTransactionType());
	}

}
