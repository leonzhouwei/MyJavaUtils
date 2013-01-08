package com.example.util.io.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.ResultSetHelper;

/**
 * 
 * @author Wei Zhou
 */

public class CsvWriter {

	public enum MODE {
		APPEND, WRITE
	}

	public static final String CHARSET_NAME_UTF_8 = "UTF-8";
	public static final int size = CSVWriter.INITIAL_STRING_SIZE;
	public static final char DEFAULT_ESCAPE_CHARACTER = CSVWriter.DEFAULT_ESCAPE_CHARACTER;
	public static final char DEFAULT_SEPARATOR = CSVWriter.DEFAULT_SEPARATOR;
	public static final char DEFAULT_QUOTE_CHARACTER = CSVWriter.DEFAULT_QUOTE_CHARACTER;
	public static final char NO_QUOTE_CHARACTER = CSVWriter.NO_QUOTE_CHARACTER;
	public static final char NO_ESCAPE_CHARACTER = CSVWriter.NO_ESCAPE_CHARACTER;
	public static final String DEFAULT_LINE_END = CSVWriter.DEFAULT_LINE_END;

	private final MODE mode;
	private CSVWriter csvWriter = null;

	public CsvWriter(String path, MODE mode, String charsetName) throws IOException {
		this.mode = mode;
		initialize(path, DEFAULT_SEPARATOR, charsetName);
	}

	/**
	 * 
	 * @param path
	 * @param mode
	 * @param separator  the delimiter to use for separating entries
	 * @param charsetName
	 * @throws IOException
	 */
	public CsvWriter(String path, MODE mode, char separator, String charsetName) throws IOException {
		this.mode = mode;
		initialize(path, separator, charsetName);
	}

	public CsvWriter(String path, MODE mode) throws IOException {
		this.mode = mode;
		initialize(path, DEFAULT_SEPARATOR);
	}

	/**
	 * 
	 * @param path
	 * @param mode
	 * @param separator  the delimiter to use for separating entries
	 * @throws IOException
	 */
	public CsvWriter(String path, MODE mode, char separator) throws IOException {
		this.mode = mode;
		initialize(path, separator);
	}

	/**
	 * 
	 * @param writer
	 * @param separator  the delimiter to use for separating entries
	 * @param quotechar  the character to use for quoted elements  the character to use for quoted elements
	 */
	public CsvWriter(Writer writer, char separator, char quotechar) {
		this.mode = MODE.WRITE;
		csvWriter = new CSVWriter(writer, separator, quotechar);
	}

	/**
	 * 
	 * @param writer
	 * @param separator  the delimiter to use for separating entries
	 * @param quotechar  the character to use for quoted elements
	 * @param escapechar  the character to use for escaping quotechars or escapechars
	 */
	public CsvWriter(Writer writer, char separator, char quotechar, char escapechar) {
		this.mode = MODE.WRITE;
		csvWriter = new CSVWriter(writer, separator, quotechar, escapechar);
	}

	/**
	 * 
	 * @param writer
	 * @param separator  the delimiter to use for separating entries
	 * @param quotechar  the character to use for quoted elements
	 * @param lineEnd  the line feed terminator to use
	 */
	public CsvWriter(Writer writer, char separator, char quotechar, String lineEnd) {
		this.mode = MODE.WRITE;
		csvWriter = new CSVWriter(writer, separator, quotechar, lineEnd);
	}

	/**
	 * 
	 * @param writer
	 * @param separator  the delimiter to use for separating entries
	 * @param quotechar  the character to use for quoted elements
	 * @param escapechar  the character to use for escaping quotechars or escapechars
	 * @param lineEnd  the line feed terminator to use
	 */
	public CsvWriter(Writer writer, char separator, char quotechar, char escapechar, String lineEnd) {
		this.mode = MODE.WRITE;
		csvWriter = new CSVWriter(writer, separator, quotechar, escapechar, lineEnd);
	}

	public boolean checkError() {
		boolean result = csvWriter.checkError();
		return result;
	}

	public void close() throws IOException {
		csvWriter.flush();
		csvWriter.close();
	}

	public void flush() throws IOException {
		csvWriter.flush();
	}

	public void setResultService(ResultSetHelper resultService) {
		csvWriter.setResultService(resultService);
	}

	/**
	 * Writes the entire list to a CSV file. The list is assumed to be a String[].
	 * 
	 * @param allLines  a List of List<String>, with each List<String> representing a line of the file
	 */
	public void writeLines(List<List<String>> allLines) {
		final int count = allLines.size();
		for (int i = 0; i < count; ++i) {
			List<String> line = allLines.get(i);
			final int size = line.size();
			String[] strings = line.toArray(new String[size]);
			csvWriter.writeNext(strings);
		}
	}

	/**
	 * Writes the next line to the file. 
	 * 
	 * @param line
	 */
	public void writeLine(List<String> line) {
		final int size = line.size();
		String[] newLine = line.toArray(new String[size]);
		csvWriter.writeNext(newLine);
	}
	
	/**
	 * Writes the next line to the file. 
	 * 
	 * @param line
	 */
	public void writeLine(String[] line) {
		csvWriter.writeNext(line);
	}
	
	/**
	 * Writes the next line to the file. 
	 * 
	 * @param string
	 */
	public void writeLine(String line) {
		String[] newLine = { line };
		csvWriter.writeNext(newLine);
	}
	
	/**
	 * Writes the entire list to a CSV file. The list is assumed to be a String[].
	 * 
	 * @param allLines  a List of String[], with each String[] representing a line of the file
	 */
	public void writeAll(List<String[]> allLines) {
		csvWriter.writeAll(allLines);
	}

	public void writeAll(ResultSet rs, boolean includeColumnNames) throws SQLException, IOException {
		csvWriter.writeAll(rs, includeColumnNames);
	}

	private void initialize(String path, char separator, String charsetName) throws IOException {
		File file = new File(path);
		List<String[]> list = new ArrayList<String[]>(1);
		if (file.exists() == true && mode == MODE.APPEND) {
			CSVReader csvReader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName)));
			list = csvReader.readAll();
			csvReader.close();
		}

		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), charsetName));
		csvWriter = new CSVWriter(writer, separator);
		csvWriter.writeAll(list);
		csvWriter.flush();
	}

	private void initialize(String path, char separator) throws IOException {
		File file = new File(path);
		List<String[]> list = new ArrayList<String[]>(1);
		if (file.exists() == true && mode == MODE.APPEND) {
			CSVReader csvReader = new CSVReader(new BufferedReader(new FileReader(path)));
			list = csvReader.readAll();
			csvReader.close();
		}

		Writer writer = new BufferedWriter(new FileWriter(path));
		csvWriter = new CSVWriter(writer, separator);
		csvWriter.writeAll(list);
		csvWriter.flush();
	}

}