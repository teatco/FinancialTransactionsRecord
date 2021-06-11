package Main;

import java.io.IOException;
import java.util.*;

public class FinancialTransactionRecords {

	public static void main(String[] args) throws IOException {
		
		String accountId="";
		Date from = new Date();
		Date to = new Date();
		FinancialTransactionRecordsWorkFlow ftrwf = new FinancialTransactionRecordsWorkFlow();
		ftrwf.run(accountId, from, to);
	}

}
;