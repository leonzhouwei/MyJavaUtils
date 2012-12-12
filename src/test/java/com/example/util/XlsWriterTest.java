package test.java.com.example.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.example.util.XlsWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XlsWriterTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAppend() {
		String xlsFilePath = "XlsWriterTest.xls";
		XlsWriter xlsWriter = null;
		try {
			xlsWriter = new XlsWriter(xlsFilePath);
			String sheetName = "sheet1";
			List<String> sheetTitles = new ArrayList<String>();
			String column1Title = "$column1Title";
			sheetTitles.add(column1Title);
			boolean createSheetResult = xlsWriter.createSheet(sheetName, null);
			System.out.println("createSheetResult: " + createSheetResult);
			List<String> data = new ArrayList<String>();
			data.add("lalalala");
			boolean result = xlsWriter.append(sheetName, data);
			System.out.println("append: " + result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (xlsWriter != null) {
				xlsWriter.close();
			}
		}
	}

}
