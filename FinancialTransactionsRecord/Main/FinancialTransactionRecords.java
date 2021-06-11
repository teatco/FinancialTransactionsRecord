package Main;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FinancialTransactionRecords {

	public static void main(String[] args) throws IOException, ParseException {
		
		String accountId="ACC998877";
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date from = formatter.parse("20/10/2018 12:00:00 ");
		Date to = formatter.parse("20/10/2018 19:00:00");
		String fileName="data";
		FinancialTransactionRecordsWorkFlow ftrwf = new FinancialTransactionRecordsWorkFlow();
		String result=ftrwf.run(accountId.trim(), from, to, fileName);
		System.out.println(result);
		
	}

}
;