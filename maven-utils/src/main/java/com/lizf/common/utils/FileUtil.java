package com.lizf.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

public class FileUtil {
	
	/**
	 *根据文件，截取扩展名 
	 * @param fileName
	 * @return
	 */
	public static String getExtName(String fileName) {
		//处理空异常
		if (fileName==null || "".equals(fileName)) {
			throw new RuntimeException("文件名不能为空");
		}
		if (fileName.indexOf(".")<=-1) {
			throw new RuntimeException(fileName+":改文件名没有包含扩展名");
		}
		String extName = fileName.substring(fileName.lastIndexOf("."));
		return extName;
	}
	
	/**
	 *获取系统当前用户目录 
	 * @return
	 */
	public static String getSystemUserHome() {
		return System.getProperty("user.home");
	}
	
	/**
	 *读取文件内容  
	 * @param pathname
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String readTextFileByLine(String pathname) {
		BufferedReader br;
		StringBuffer sb=new StringBuffer();
		try {
			br=new BufferedReader(new FileReader(new File(pathname)));
		    do {
		    	sb.append(br.readLine());
		    	sb.append("\r\n");
			} while (br.read()!=-1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return sb.toString();
	}
	/**
	 * 按行读取文件内容到list集合
	 * @param pathname
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static List<String> readTextFileOfList(String pathname) throws IOException{
		BufferedReader br;
		List<String> strList=new ArrayList<>();
		 try {
			br=new BufferedReader(new FileReader(new File(pathname)));
			do {
				strList.add(br.readLine());
			} while (br.read()!=-1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return strList;
	}
	/**
	 * 递归删除文件
	 * @param file
	 * @return 
	 */
	public static void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] listFiles=file.listFiles();
			for(File theFile:listFiles) {
				deleteFile(theFile);
			}
			file.delete();
		}else {
			file.delete();
		}
	}
	/**
	 * 递归删除文件
	 * @param theFile
	 */
	private static void deleteFile(String filePath) {
		deleteFile(new File(filePath));
		
	}

	public static String getFileSize(File file) {
	   long length=file.length();
	   return Math.round((length/1024.0))+"kb";
	   
    }
	public static String getFileSize(String fileFullName) {
		return getFileSize(new File(fileFullName));
		
	}
	public static void main(String [] args) {
		System.out.println(getFileSize("C:\\Users\\Administrator\\Desktop\\pom.xml"));
		
	}
}
