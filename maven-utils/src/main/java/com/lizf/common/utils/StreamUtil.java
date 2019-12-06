package com.lizf.common.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
	
	/**
	 *关闭流方法 
	 * @param autoCloseables
	 */
	public static void closeAll(AutoCloseable... autoCloseables) {
		if (autoCloseables != null) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	
	/**
	 * 以流的方式，读取文本文件内容
	 * @param file
	 * @return
	 */
	public static String readTextFile(File file) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			String str = "";
			while (inputStream.read(b) != -1) {
				str += new String(b);
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeAll(inputStream);
		}
	}

	/**
	 * 根据文件全名读取文件内容
	 * @param fileFullName
	 * @return
	 */
	public static String readTextFile(String fileFullName) {

		return readTextFile(new File(fileFullName));

	}
	public static void writeTextFile(String content,File file,boolean append) {
		BufferedWriter writer=null;
		try {
			//判断写文件的文件夹是否存在
			String parent=file.getParent();
			File parenFile=new File(parent);
			if (!parenFile.exists()) {
				parenFile.mkdirs();
			}
			//写文件
			writer=new BufferedWriter(new FileWriter(file,append));
			writer.write(content);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			closeAll(writer);
		}
		
	}
	public static void writeTextFile(String content,String fileFullName,boolean append) {
		writeTextFile(content,new File(fileFullName), append);
	}
	public static void main(String [] args) {
		String readTextFile=readTextFile("C:\\Users\\Administrator\\Desktop\\pom.xml");
		System.out.println(readTextFile);
		writeTextFile(readTextFile,"C:\\Users\\Administrator\\Desktop\\aa\\aa.xml",false);
	}
}
