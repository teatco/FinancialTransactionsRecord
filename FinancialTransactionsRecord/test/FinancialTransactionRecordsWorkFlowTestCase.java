package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Main.FinancialTransactionRecordsWorkFlow;

class FinancialTransactionRecordsWorkFlowTestCase {

	@Test
	void test() throws IOException, ParseException {
		String accountId="ACC334455";
		Date from = new Date();
		Date to = new Date();
		String fileName="test/testData1";
		FinancialTransactionRecordsWorkFlow ftrwf = new FinancialTransactionRecordsWorkFlow();
		ftrwf.run(accountId, from, to, fileName);
		
		assertEquals(2,ftrwf.getAllTransactions().size());

	}

}
