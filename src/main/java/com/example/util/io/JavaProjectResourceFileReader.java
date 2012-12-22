package main.java.com.example.util.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 源代码的文件结构，JavaProjectResourceFileReader.java 的包名为 main.java.com.example.util
 * 
 * src
 *     |-- main // 此为顶包
 *         |-- java
 *         |    |-- com
 *         |        |-- example
 *         |            |-- util
 *         |                |-- JavaProjectResourceFileReader.java
 *         |-- resources
 *             |-- conf
 *                 |-- test.txt
 *
 *
 *
 * jar包解压缩后的文件结构
 * 
 * a.jar
 *     |-- main
 *         |-- java
 *         |   |-- com
 *         |       |-- example
 *         |           |-- util
 *         |               |-- JavaProjectResourceFileReader.class
 *         |-- resources
 *             |-- conf
 *                 |-- test.txt
 *     
 * @author Leon
 *
 */

public class JavaProjectResourceFileReader {
	
	public static final String CHAR_SET_UTF_8 = "UTF-8";
	
	public static void main(String[] args) {
		try {
			String name = "/main/resources/conf/test.txt";
			InputStream inputStream = JavaProjectResourceFileReader.class.getResourceAsStream(name);
			
			// set char set as utf-8
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, CHAR_SET_UTF_8);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			// read the file
			String string = null;
			while ( (string=bufferedReader.readLine()) != null) {
				System.out.println(string);
			}
			
			// close the file
			bufferedReader.close();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
