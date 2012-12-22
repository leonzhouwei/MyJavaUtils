package main.java.com.example.gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GcjIoFileHandler {

	public static final String OUTPUT_CASE_HEADER = "Case #";
	public static final String CHAR_SET_NAME_UTF_8 = "UTF-8";

	private BufferedReader mBufferedReader = null;
	private BufferedWriter mBufferedWriter = null;
	private Integer caseNumber = 1;

	public GcjIoFileHandler(String inputFilePath, String outputFilePath) throws FileNotFoundException, IOException {
		mBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), CHAR_SET_NAME_UTF_8));
		mBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), CHAR_SET_NAME_UTF_8));
	}

	public String readLine() throws IOException {
		return mBufferedReader.readLine();
	}

	public void writeLine(String result) throws IOException {
		mBufferedWriter.write(OUTPUT_CASE_HEADER);
		mBufferedWriter.write(caseNumber.toString());
		++caseNumber;
		mBufferedWriter.write(": ");
		mBufferedWriter.write(result);
		mBufferedWriter.newLine();
	}

	public void writeLine(int result) throws IOException {
		mBufferedWriter.write(OUTPUT_CASE_HEADER);
		mBufferedWriter.write(caseNumber.toString());
		++caseNumber;
		mBufferedWriter.write(": ");
		mBufferedWriter.write(result);
		mBufferedWriter.newLine();
	}

	public void close() throws IOException {
		mBufferedReader.close();
		mBufferedWriter.flush();
		mBufferedWriter.close();
	}
	
	public static void main(String[] args) throws IOException {
		GcjIoFileHandler gcj = null;
		try {
			gcj = new GcjIoFileHandler("C-small-0.in", "C-small-0.out");
			String s = null;
			while ((s = gcj.readLine()) != null) {
				System.out.println(s);
				gcj.writeLine(s);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			gcj.close();
		}
	}

}
