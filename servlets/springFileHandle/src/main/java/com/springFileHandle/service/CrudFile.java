package com.springFileHandle.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.springframework.stereotype.Component;

/**
 * @Author SaravanaKumar S S
 * @Email saravanakumar.ss@zohocorp.com
 * @since 02/08/2023
 */

/*
 * The component annotation creates bean for this class
 */
@Component("crud")
/**
 * This class has core logics for file handling(CRUD operations)
 */
public class CrudFile {
	
	/**
	 * This method creates file into specific location
	 * 
	 * @param filePath contains folder path
	 * @param fileName contain file name
	 * @return "created" when the file is created
	 */
	public String crudCreate(String filePath, String fileName) {
		if(filePath != null) {
			try {
				new File("/home/sarav-zstch1200/Files/"+filePath).mkdirs();
				File f = new File("/home/sarav-zstch1200/Files/"+filePath+fileName+".txt");
				f.createNewFile();
				return "Created";
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		else {
			try {
				File f = new File("/home/sarav-zstch1200/Files/"+fileName+".txt");
				f.createNewFile();
				return "Created";
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	/**
	 * This method reads the file and returns contents
	 * 
	 * @param filePath contains folder path
	 * @param fileName contain file name
	 * @return It returns content from the specific file
	 */
	public String crudRead(String filePath, String fileName) {
		String output="";
		if(filePath != null) {
			try {
				FileReader fr = new FileReader("/home/sarav-zstch1200/Files/"+filePath+fileName+".txt");
				int c;
				while((c=fr.read()) != -1) {
					output+=(char) c;
				}
				fr.close();
				return output;
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		else {
			try {
				FileReader fr = new FileReader("/home/sarav-zstch1200/Files/"+fileName+".txt");
				int c;
				while((c=fr.read()) != -1) {
					output+=(char) c;
				}
				fr.close();
				return output;
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	/**
	 * This method write into files with the given content
	 * 
	 * @param filePath contains folder path
	 * @param fileName contains file name
	 * @param fileContent contains  
	 * @return "updated" when the file is updated
	 */
	public String crudUpdate(String filePath, String fileName, String fileContent) {
		if(filePath != null) {
			try {
				FileWriter fw = new FileWriter("/home/sarav-zstch1200/Files/"+filePath+fileName+".txt");
				fw.write(fileContent);
				fw.close();
				return "updated";
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		else {
			try {
				FileWriter fw = new FileWriter("/home/sarav-zstch1200/Files/"+fileName+".txt");
				fw.write(fileContent);
				fw.close();
				return "updated";
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	
	/**
	 * This method deletes the file
	 * 
	 * @param filePath contains folder path
	 * @param fileName contains file name
	 * @return "deleted" when the file is deleted
	 */
	public String crudDelete(String filePath, String fileName) {
		if(filePath != null) {
			File f= new File("/home/sarav-zstch1200/Files/"+filePath+fileName+".txt");
				f.delete();	
				return "Deleted";
		}
		else {
			File f= new File("/home/sarav-zstch1200/Files/"+fileName+".txt");
				f.delete();
				return "Deleted";
		}
	}
}
