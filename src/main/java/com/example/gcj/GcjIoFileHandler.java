package main.java.com.example.gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GcjIoFileHandler {

	public static final String OUTPUT_CASE_HEADER = "Case #";
	
	private String mInputFilePath = null;
	private String mOutputFilePath = null;
	private BufferedReader mBufferedReader = null;
	private BufferedWriter mBufferedWriter = null;
	private Integer caseNumber = 1;

	public static void main(String[] args) throws IOException {
		GcjIoFileHandler gcj = new GcjIoFileHandler();
		try {
			gcj.init("C-small-0.in", "C-small-0.out");
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

	public GcjIoFileHandler() {

	}

	public void init(String inputFilePath, String outputFilePath)
			throws FileNotFoundException, IOException {
		mInputFilePath = new String(inputFilePath);
		FileReader in = new FileReader(mInputFilePath);
		mBufferedReader = new BufferedReader(in);
		mOutputFilePath = new String(outputFilePath);
		FileWriter out = new FileWriter(mOutputFilePath);
		mBufferedWriter = new BufferedWriter(out);
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

}
