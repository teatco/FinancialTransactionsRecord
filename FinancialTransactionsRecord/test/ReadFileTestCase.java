package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import Main.ReadFile;

class ReadFileTestCase {

	@Test
	void test() throws IOException {
		ReadFile radFile=new ReadFile();
		String[] transactionsData= radFile.read("test/testData1");
		assertEquals(2, transactionsData.length);
	}

}
