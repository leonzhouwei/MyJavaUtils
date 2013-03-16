package com.example.gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Gcj {

	private static final String CHARSET_NAME_UTF_8 = "utf-8";
	private static final String OUTPUT_CASE_HEADER = "Case #";
	private GcjOutputFileWriter writer;
	private String inputFilePath;

	public Gcj(String inputFilePath, String outputFilePath) throws UnsupportedEncodingException, FileNotFoundException {
		this.inputFilePath = inputFilePath;
		writer = new GcjOutputFileWriter(outputFilePath);
	}
	
	public static void main(String[] args) {
		// files define
		final String inputFilePath = "C-small-0.in";
		final String outputFilePath = "C-small-0.out";
		Gcj gcj = null;
		
		// solve the problem
		try {
			gcj = new Gcj(inputFilePath, outputFilePath);
			// read the input
			List<String> input = gcj.read();
			gcj.print(input);
			// process
			List<String> output = gcj.process(input);
			// write the output
			gcj.write(output);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				gcj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> process(List<String> input) {
		List<String> output = new ArrayList<String>();
//		output.addAll(input);
		// TODO
		return output;
	}

	public List<String> read() {
		BufferedReader br = null;
		List<String> list = new ArrayList<String>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), CHARSET_NAME_UTF_8));
			String s = null;
			while ((s = br.readLine()) != null) {
				list.add(s.trim());
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void write(List<String> list) throws IOException {
		writer.append(list);
	}

	public void close() throws IOException {
		writer.close();
	}

	public void print(List<String> list) {
		final int size = list.size();
		for (int i = 0; i < size; ++i) {
			System.out.println(list.get(i));
		}
	}

	class GcjOutputFileWriter {

		private BufferedWriter writer;
		private int caseNumber = 0;

		public GcjOutputFileWriter(String path) throws UnsupportedEncodingException, FileNotFoundException {
			File file = new File(path);
			if (file.exists()) {
				file.delete();
			}
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), CHARSET_NAME_UTF_8));
		}

		public void append(List<String> list) throws IOException {
			final int size = list.size();
			for (int i = 0; i < size; ++i) {
				writer.append(OUTPUT_CASE_HEADER);
				++caseNumber;
				writer.append(Integer.toString(caseNumber));
				writer.append(": ");
				writer.append(list.get(i));
				writer.newLine();
			}
			writer.flush();
		}

		public void close() throws IOException {
			writer.flush();
			writer.close();
		}
	}
	
}
