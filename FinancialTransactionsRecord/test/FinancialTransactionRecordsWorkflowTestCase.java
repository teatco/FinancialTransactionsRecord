package test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Main.FinancialTransactionRecordsWorkflow;

class FinancialTransactionRecordsWorkflowTestCase {
	
	
	@Test
	void testGetAllTransactions() throws IOException, ParseException {
		String accountId="ACC998877";
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date from = formatter.parse("20/10/2018 12:00:00");
		Date to = formatter.parse("20/10/2018 19:00:00");
		String fileName="test/testData1";
		
		FinancialTransactionRecordsWorkflow ftrwf = new FinancialTransactionRecordsWorkflow();
		ftrwf.run(accountId, from, to, fileName);
		
		assertEquals(5,ftrwf.getAllTransactions().size());
	}
	
	/* To test the balance and the number of transactions of the account ACC334455 in a specific period*/
	@Test
	void testAccountBalance1() throws IOException, ParseException {
		String accountId="ACC334455";
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date from = formatter.parse("20/10/2018 12:00:00");
		Date to = formatter.parse("20/10/2018 19:00:00");
		String fileName="test/testData1";
		
		FinancialTransactionRecordsWorkflow ftrwf = new FinancialTransactionRecordsWorkflow();
		ftrwf.run(accountId, from, to, fileName);
		
		assertEquals(1,ftrwf.getNumberOfTransactions());
		assertEquals(-25.0, ftrwf.getBalance(), 0.00);

	}
	
	/* To test the balance and the number of transactions of the account ACC778899 in a specific period*/
	@Test
	void testAccountBalance2() throws IOException, ParseException {
		String accountId="ACC778899";
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date from = formatter.parse("20/10/2018 12:00:00");
		Date to = formatter.parse("20/10/2018 19:00:00");
		String fileName="test/testData1";
		
		FinancialTransactionRecordsWorkflow ftrwf = new FinancialTransactionRecordsWorkflow();
		ftrwf.run(accountId, from, to, fileName);
		
		assertEquals(2,ftrwf.getNumberOfTransactions());
		assertEquals(30.0, ftrwf.getBalance(), 0.00);

	}
	
	/* To test the balance and the number of transactions of the account ACC998877 in a specific period*/
	@Test
	void testAccountBalance3() throws IOException, ParseException {
		String accountId="ACC998877";
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date from = formatter.parse("20/10/2018 12:00:00");
		Date to = formatter.parse("20/10/2018 19:00:00");
		String fileName="test/testData1";
		
		FinancialTransactionRecordsWorkflow ftrwf = new FinancialTransactionRecordsWorkflow();
		ftrwf.run(accountId, from, to, fileName);
		
		assertEquals(1,ftrwf.getNumberOfTransactions());
		assertEquals(-5.0, ftrwf.getBalance(), 0.00);

	}

}
