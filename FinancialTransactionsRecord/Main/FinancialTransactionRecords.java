package Main;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class FinancialTransactionRecords {

	public static void main(String[] args) throws IOException, ParseException {
		
		String accountId="";
		Date from = new Date();
		Date to = new Date();
		String fileName="test/testData1";
		FinancialTransactionRecordsWorkFlow ftrwf = new FinancialTransactionRecordsWorkFlow();
		ftrwf.run(accountId, from, to, fileName);
		
		assertEquals(2,ftrwf.getAllTransactions().size());
	}

}
;