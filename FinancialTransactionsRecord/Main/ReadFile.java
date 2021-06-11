package Main;

import java.io.*;
import java.util.*;

public class ReadFile {

	public ReadFile() {}
	
	public  String[] read() throws IOException {
		BufferedReader abc = new BufferedReader(new FileReader(new File("data")));
		List<String> lines = new ArrayList<String>();
		String line="";
		while(( line = abc.readLine()) != null) {
		    lines.add(line);
		}
		abc.close();

	   String[] data = lines.toArray(new String[]{});
		return data;
	}

	

}
