package Main;


import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class FinancialTransactionRecords {

	public static void main(String[] args) throws IOException, ParseException {
		
		String accountId="";
		Date from = new Date();
		Date to = new Date();
		String fileName="data";
		FinancialTransactionRecordsWorkFlow ftrwf = new FinancialTransactionRecordsWorkFlow();
		String result=ftrwf.run(accountId, from, to, fileName);
		System.out.println(result);
		
	}

}
;