package main.java.com.example.util;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.ResultSetHelper;

public class CsvWriter {

	public static final int size = CSVWriter.INITIAL_STRING_SIZE;
	public static final char DEFAULT_ESCAPE_CHARACTER = CSVWriter.DEFAULT_ESCAPE_CHARACTER;
	public static final char DEFAULT_SEPARATOR = CSVWriter.DEFAULT_SEPARATOR;
	public static final char DEFAULT_QUOTE_CHARACTER = CSVWriter.DEFAULT_QUOTE_CHARACTER;
	public static final char NO_QUOTE_CHARACTER = CSVWriter.NO_QUOTE_CHARACTER;
	public static final char NO_ESCAPE_CHARACTER = CSVWriter.NO_ESCAPE_CHARACTER;
	public static final String DEFAULT_LINE_END = CSVWriter.DEFAULT_LINE_END;

	private CSVWriter csvWriter = null;

	public CsvWriter(String path) throws IOException {
		initialize(path);
	}

	public CsvWriter(String path, char separator) throws IOException {
		initialize(path);
	}

	public CsvWriter(Writer writer, char separator, char quotechar) {
		csvWriter = new CSVWriter(writer, separator, quotechar);
	}

	public CsvWriter(Writer writer, char separator, char quotechar, char escapechar) {
		csvWriter = new CSVWriter(writer, separator, quotechar, escapechar);
	}

	public CsvWriter(Writer writer, char separator, char quotechar, String lineEnd) {
		csvWriter = new CSVWriter(writer, separator, quotechar, lineEnd);
	}

	public CsvWriter(Writer writer, char separator, char quotechar, char escapechar, String lineEnd) {
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
	
	public void writeLines(List<List<String>> allLines) {
		final int count = allLines.size();
		for (int i = 0; i < count; ++i) {
			List<String> line = allLines.get(i);
			final int size = line.size();
			String[] strings = line.toArray(new String[size]);
			csvWriter.writeNext(strings);
		}
	}
	
	public void writeLine(List<String> line) {
		final int size = line.size();
		String[] strings = line.toArray(new String[size]);
		csvWriter.writeNext(strings);
	}
	
	public void writeLine(String string) {
		String[] strings = { string };
		csvWriter.writeNext(strings);
	}

	public void writeAll(List<String[]> allLines) {
		csvWriter.writeAll(allLines);
	}

	public void writeAll(ResultSet rs, boolean includeColumnNames) throws SQLException, IOException {
		csvWriter.writeAll(rs, includeColumnNames);
	}

	public void writeNext(String[] nextLine) {
		csvWriter.writeNext(nextLine);
	}
	
	private void initialize(String path) throws IOException {
		Writer writer = new BufferedWriter(new FileWriter(path));
		csvWriter = new CSVWriter(writer);
	}

}
