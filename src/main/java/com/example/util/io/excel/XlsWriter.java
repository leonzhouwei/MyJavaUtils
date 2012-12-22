package main.java.com.example.util.io.excel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class XlsWriter {
	
	public enum MODE {
		APPEND, WRITE
	}
	
	private final CellStyle CELL_STYLE_ALIGN_CENTER;
	private final OutputStream outputStream;
	private Workbook workbook = null;
	
	/**
	 * 
	 * @param path
	 * @param mode
	 * @throws IOException
	 */
	public XlsWriter(String path, MODE mode) throws IOException {
		File file = new File(path);
		if (file.exists() == false || mode == MODE.WRITE) {
			workbook = new HSSFWorkbook();
		} else {
			InputStream inputStream = new FileInputStream(file);
			workbook = new HSSFWorkbook(inputStream);
			inputStream.close();
		}
		
		outputStream = new BufferedOutputStream(new FileOutputStream(path));
		CELL_STYLE_ALIGN_CENTER = workbook.createCellStyle();
		CELL_STYLE_ALIGN_CENTER.setAlignment(CellStyle.ALIGN_CENTER);
	}
	
	/**
	 * create a new sheet
	 * 
	 * @param name  the name of the sheet
	 * @param titles  the titles of the sheet
	 * @return true on success, false otherwise, such as the sheet already exists
	 * @throws IOException 
	 */
	public boolean createSheet(String sheetName, List<String> sheetTitles) throws IOException {
		if (workbook.getSheet(sheetName) != null) {
			return false;
		}
		
		// create a sheet
		Sheet sheet = workbook.createSheet(sheetName);
		
		// create titles if needed
		if (sheetTitles != null && sheetTitles.size() > 0) {
			Row titleRow = sheet.createRow(0);
			final int size = sheetTitles.size();
			for (int i = 0; i < size; ++i) {
				String value = sheetTitles.get(i);
				Cell cell = titleRow.createCell(i);
				cell.setCellStyle(CELL_STYLE_ALIGN_CENTER);
				cell.setCellValue(value);
			}
		}
		
		return true;
	}
	
	public void clearSheet(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet != null) {
			int lastRowNumber = sheet.getLastRowNum();
			for (int i = lastRowNumber; i >=0 ; --i) {
				Row row = sheet.getRow(i);
				sheet.removeRow(row);
			}
		}
	}
	
	public void removeSheet(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet != null) {
			int index = workbook.getSheetIndex(sheet);
			workbook.removeSheetAt(index);
		}
	}

	/**
	 * append a new row to the sheet
	 * 
	 * @param sheetName
	 * @param data
	 * @return true on success, false otherwise
	 * @throws IOException 
	 */
	public boolean append(String sheetName, List<String> data) {
		if (workbook.getSheet(sheetName) == null) {
			System.out.println("sheet named with " + sheetName + " does not exist");
			return false;
		}
		
		Sheet sheet = workbook.getSheet(sheetName);
		final int size = data.size();
		if (size > 0) {
			int lastRowNumber = sheet.getLastRowNum();
			if (lastRowNumber == Integer.MAX_VALUE) {
				// if the rows count has reached the upper limit
				return false;
			}
			int newRowNumber = -1;
			if (lastRowNumber == 0 && sheet.getPhysicalNumberOfRows() == 0) {
				newRowNumber = lastRowNumber;
			} else {
				newRowNumber = lastRowNumber + 1;
			}
			Row row = sheet.createRow(newRowNumber);
			for (int i = 0; i < size; ++i) {
				Cell cell = row.createCell(i);
				String value = data.get(i);
				cell.setCellValue(value);
			}
		}
		
		return true;
	}
	
	public void flush() throws IOException {
		outputStream.flush();
	}

	/**
	 * save and close the excel file
	 * 
	 */
	public void close() {
		try {
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			// no operations
		}
	}

}
