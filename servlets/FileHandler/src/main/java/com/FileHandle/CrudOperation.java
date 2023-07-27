package com.FileHandle;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CrudOperation {
	
	public static CrudOperation instance = new CrudOperation();
	public static CrudOperation getInstance() {
		return instance;
	}
	
	
	public void createFile(String fileName,String fileContent) {
		try {
			FileWriter fw = new FileWriter("/home/sarav-zstch1200/Files/"+fileName+".txt");
			fw.write(fileContent);
			fw.close();
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	//Initialize the file
	public void initFile(String filename) {
		createFile(filename,"empty!");
	}
	
	
	//read the file
	public String readFile(String fileName) {
		String output="";
		try {
        	FileReader reader = new FileReader("/home/sarav-zstch1200/Files/"+fileName+".txt");
        	int c;
        	while((c=reader.read()) != -1) {
        		output+=(char) c;
        	}
        	reader.close();
        	
        }catch(Exception e) {
        	System.out.println(e);
        	e.printStackTrace();
        }
		return output;
	}
	
	
	//updates the file
	public void updateFile(String fileName, String fileContent) {
		createFile(fileName, fileContent);
	}
	
	
	//deletes the file
	public void deleteFile(String fileName) {
		File f= new File("/home/sarav-zstch1200/Files/"+fileName+".txt");
		f.delete();
	}
}
