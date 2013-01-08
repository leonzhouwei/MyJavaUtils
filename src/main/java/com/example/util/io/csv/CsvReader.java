package com.example.util.io.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * 
 * @author Wei Zhou
 */

public class CsvReader {
	
	 public static int DEFAULT_SKIP_LINES = CSVReader.DEFAULT_SKIP_LINES;
	 
	 private final CSVReader csvReader;
	 
	 public CsvReader(String path) throws FileNotFoundException {
		 csvReader = new CSVReader(new BufferedReader(new FileReader(path)));
	 }
	 
	 public CsvReader(String path, String charsetName) throws UnsupportedEncodingException, FileNotFoundException {
		csvReader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName)));
	 }
	 
	 /**
	  * 
	  * @param path
	  * @param charsetName
	  * @param separator  the delimiter to use for separating entries
	  * @throws UnsupportedEncodingException
	  * @throws FileNotFoundException
	  */
	 public CsvReader(String path, String charsetName, char separator) throws UnsupportedEncodingException, FileNotFoundException {
		 csvReader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName)), separator);
	 }
	 
	 /**
	  * 
	  * @param path
	  * @param charsetName
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @throws UnsupportedEncodingException
	  * @throws FileNotFoundException
	  */
	 public CsvReader(String path, String charsetName, char separator, char quotechar) throws UnsupportedEncodingException, FileNotFoundException {
		 csvReader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName)), separator, quotechar);
	 }
	 
	 /**
	  * 
	  * @param path
	  * @param charsetName
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param strictQuotes  sets if characters outside the quotes are ignored
	  * @throws UnsupportedEncodingException
	  * @throws FileNotFoundException
	  */
	 public CsvReader(String path, String charsetName, char separator, char quotechar, boolean strictQuotes) throws UnsupportedEncodingException, FileNotFoundException {
		 csvReader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName)), separator, quotechar, strictQuotes);
	 }
	 
	 /**
	  * 
	  * @param path
	  * @param charsetName
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param escape  the character to use for escaping a separator or quote
	  * @throws UnsupportedEncodingException
	  * @throws FileNotFoundException
	  */
	 public CsvReader(String path, String charsetName, char separator, char quotechar, char escape) throws UnsupportedEncodingException, FileNotFoundException {
		 csvReader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName)), separator, escape);
	 }
	 
	 /**
	  * 
	  * @param path
	  * @param charsetName
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param escape  the character to use for escaping a separator or quote
	  * @param line  the line number to skip for start reading
	  * @throws UnsupportedEncodingException
	  * @throws FileNotFoundException
	  */
	 public CsvReader(String path, String charsetName, char separator, char quotechar, char escape, int line) throws UnsupportedEncodingException, FileNotFoundException {
		 csvReader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName)), separator, quotechar, escape, line);
	 }
	 
	 /**
	  * 
	  * @param path
	  * @param charsetName
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param escape  the character to use for escaping a separator or quote
	  * @param line  the line number to skip for start reading
	  * @param strictQuotes  sets if characters outside the quotes are ignored
	  * @throws UnsupportedEncodingException
	  * @throws FileNotFoundException
	  */
	 public CsvReader(String path, String charsetName, char separator, char quotechar, char escape, int line, boolean strictQuotes) throws UnsupportedEncodingException, FileNotFoundException {
		 csvReader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName)), separator, quotechar, escape, line, strictQuotes);
	 }
	 
	 /**
	  * 
	  * @param path
	  * @param charsetName
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param escape  the character to use for escaping a separator or quote
	  * @param line  the line number to skip for start reading
	  * @param strictQuotes  sets if characters outside the quotes are ignored
	  * @param ignoreLeadingWhiteSpace
	  * @throws UnsupportedEncodingException
	  * @throws FileNotFoundException
	  */
	 public CsvReader(String path, String charsetName, char separator, char quotechar, char escape, int line, boolean strictQuotes, boolean ignoreLeadingWhiteSpace) throws UnsupportedEncodingException, FileNotFoundException {
		 csvReader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName)), separator, quotechar, escape, line, strictQuotes, ignoreLeadingWhiteSpace);
	 }
	 
	 /**
	  * 
	  * @param path
	  * @param charsetName
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param line  the line number to skip for start reading
	  * @throws UnsupportedEncodingException
	  * @throws FileNotFoundException
	  */
	 public CsvReader(String path, String charsetName, char separator, char quotechar, int line) throws UnsupportedEncodingException, FileNotFoundException {
		 csvReader = new CSVReader(new BufferedReader(new InputStreamReader(new FileInputStream(path), charsetName)), separator, quotechar, line);
	 }
	 
	 public CsvReader(Reader reader) {
		 csvReader = new CSVReader(reader);
	 }
	 
	 /**
	  * 
	  * @param reader
	  * @param separator  the delimiter to use for separating entries
	  */
	 public CsvReader(Reader reader, char separator)  {
		 csvReader = new CSVReader(reader, separator);
	 }
	 
	 /**
	  * 
	  * @param reader
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  */
	 public CsvReader(Reader reader, char separator, char quotechar) {
		 csvReader = new CSVReader(reader, separator, quotechar);
	 }
	 
	 /**
	  * 
	  * @param reader
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param strictQuotes  sets if characters outside the quotes are ignored
	  */
	 public CsvReader(Reader reader, char separator, char quotechar, boolean strictQuotes) {
		 csvReader = new CSVReader(reader, separator, quotechar, strictQuotes);
	 }
	 
	 /**
	  * 
	  * @param reader
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param escape  the character to use for escaping a separator or quote
	  */
	 public CsvReader(Reader reader, char separator, char quotechar, char escape) {
		 csvReader = new CSVReader(reader, separator, quotechar, escape);
	 }
	 
	 /**
	  * 
	  * @param reader
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param escape  the character to use for escaping a separator or quote
	  * @param line  the line number to skip for start reading
	  */
	 public CsvReader(Reader reader, char separator, char quotechar, char escape, int line) {
		 csvReader = new CSVReader(reader, separator, quotechar, escape, line);
	 }
	 
	 /**
	  * 
	  * @param reader
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param escape  the character to use for escaping a separator or quote
	  * @param line  the line number to skip for start reading
	  * @param strictQuotes  sets if characters outside the quotes are ignored
	  */
	 public CsvReader(Reader reader, char separator, char quotechar, char escape, int line, boolean strictQuotes) {
		 csvReader = new CSVReader(reader, separator, quotechar, escape, line, strictQuotes);
	 }
	 
	 /**
	  * 
	  * @param reader
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param escape  the character to use for escaping a separator or quote
	  * @param line  the line number to skip for start reading
	  * @param strictQuotes  sets if characters outside the quotes are ignored
	  * @param ignoreLeadingWhiteSpace
	  */
	 public CsvReader(Reader reader, char separator, char quotechar, char escape, int line, boolean strictQuotes, boolean ignoreLeadingWhiteSpace) {
		 csvReader = new CSVReader(reader, separator, quotechar, escape, line, strictQuotes, ignoreLeadingWhiteSpace);
	 }
	 
	 /**
	  * 
	  * @param reader
	  * @param separator  the delimiter to use for separating entries
	  * @param quotechar  the character to use for quoted elements
	  * @param line  the line number to skip for start reading
	  */
	 public CsvReader(Reader reader, char separator, char quotechar, int line) {
		 csvReader = new CSVReader(reader, separator, quotechar, line);
	 }
	 
	 public void close() throws IOException {
		 csvReader.close();
	 }
	 
	 /**
	  * Reads the entire file into a List with each element being a String[] of tokens. 
	  *
	  * @return  a List of List<String>, with each List<String> representing a line of the file
	  * @throws IOException
	  */
	 public List<List<String>> readAllAsListNestedWithList() throws IOException {
		 List<String[]> original = csvReader.readAll();
		 List<List<String>> list = new ArrayList<List<String>>(original.size());
		 final int lines = original.size();
		 for (int i = 0; i < lines; ++i) {
			 String[] strings = original.get(i);
			 final int length = strings.length;
			 List<String> line = new ArrayList<String>();
			 list.add(line);
			 for (int j = 0; j < length; ++j) {
				 String string = strings[j];
				 line.add(string);
			 }
		 }
		 
		 return list;
	 }
	 
	 /**
	  * Reads the next line from the buffer and converts to a string array. 
	  * 
	  * @return  a string list with each comma-separated element as a separate entry
	  * @throws IOException
	  */
	 public List<String> readLineAsList() throws IOException {
		 List<String> list = new ArrayList<String>();
		 String[] strings = csvReader.readNext();
		 final int length = strings.length;
		 if (!(length > 0)) {
			 return list;
		 }
		 int j = length - 1;
		 for (; j >= 0 && strings[j].length() > 0; --j);
		 if (j < 0) {
			 return list;
		 }
		 final int realLength = j + 1;
		 for (j = 0; j < realLength; ++j) {
			 String string = strings[j];
			 list.add(string);
		 }
		 
		 return list;
	 }
	 
	 /**
	  * Reads the entire file into a List with each element being a String[] of tokens. 
	  *
	  * @return  a List of String[], with each String[] representing a line of the file
	  * @throws IOException
	  */
	 public List<String[]> readAll() throws IOException {
		 return csvReader.readAll();
	 }
	 
	 /**
	  * Reads the next line from the buffer and converts to a string array. 
	  * 
	  * @return  a string array with each comma-separated element as a separate entry
	  * @throws IOException
	  */
	 public String[] readLine() throws IOException {
		 return csvReader.readNext();
	 }
	 
}
