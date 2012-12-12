package test.java.com.example.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.com.example.util.XlsWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XlsWriterTest {
	
	private String defaultPath = XlsWriterTest.class.getName() + ".xls";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAppend() {
		String xlsFilePath = defaultPath;
		XlsWriter xlsWriter = null;
		try {
			xlsWriter = new XlsWriter(xlsFilePath, XlsWriter.MODE.WRITE);
			String sheetName = "sheet1";
			List<String> sheetTitles = new ArrayList<String>();
			String column1Title = "$column1Title";
			sheetTitles.add(column1Title);
			xlsWriter.createSheet(sheetName, sheetTitles);
			List<String> data = new ArrayList<String>();
			data.add("1");
			xlsWriter.append(sheetName, data);
			data = new ArrayList<String>();
			data.add("2");
			data.add("3");
			xlsWriter.append(sheetName, data);
			data = new ArrayList<String>();
			data.add("4");
			data.add("5");
			data.add("6");
			xlsWriter.append(sheetName, data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (xlsWriter != null) {
				xlsWriter.close();
			}
		}
	}
	
//	@Test
	public void testClearSheet() {
		String xlsFilePath = defaultPath;
		XlsWriter xlsWriter = null;
		try {
			xlsWriter = new XlsWriter(xlsFilePath, XlsWriter.MODE.APPEND);
			String sheetName = "sheet1";
			xlsWriter.clearSheet(sheetName);
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
