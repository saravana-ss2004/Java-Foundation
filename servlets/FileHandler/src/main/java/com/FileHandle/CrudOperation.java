package com.FileHandle;

import java.io.*;

public class CrudOperation {
	
	public static CrudOperation instance = new CrudOperation();
	public static CrudOperation getInstance() {
		return instance;
	}
	
	
	//Initialize the file
	public void initFile(String filename, String filePath) {
		
		if(filePath != null) {
			try {
				new File("/home/sarav-zstch1200/Files/"+filePath).mkdirs();
				if(filename != null) {
					File f = new File("/home/sarav-zstch1200/Files/"+filePath+filename+".txt");
					if(!f.exists()) {
						f.createNewFile();
					}
					else {
						System.out.print("file already exists");
					}
				}		
			}catch(Exception e) {	
				
			}
		}
		
		else {
			try {
				File f = new File("/home/sarav-zstch1200/Files/"+filename+".txt");
				if(!f.exists()) {
					f.createNewFile();
				}
				else {
					System.out.print("file already exists");
				}
				
			}catch(Exception e) {
				
			}
		}
	}
	
	
	//read the file
	public String readFile(String fileName, String path) {
		String output="";
		if(path != null) {
			try {
				File f= new File("/home/sarav-zstch1200/Files/"+path+fileName+".txt");
				if(f.exists()) {
					FileReader fr = new FileReader("/home/sarav-zstch1200/Files/"+path+fileName+".txt");
					int c;
					while((c=fr.read()) != -1) {
						output+=(char) c;
					}
					fr.close();
				}
			}catch(Exception e) {
				
			}
		}
		
		else {
			try {
				File f= new File("/home/sarav-zstch1200/Files/"+fileName+".txt");
				if(f.exists()) {
					FileReader fr = new FileReader("/home/sarav-zstch1200/Files/"+fileName+".txt");
					int c;
					while((c=fr.read()) != -1) {
						output+=(char) c;
					}
					fr.close();
				}
			}catch(Exception e) {
				
			}
		}
		return output;
	}
	
	
	//updates the file
	public void updateFile(String fileName, String fileContent, String path) {
		if(path != null) {
			try {
				File f= new File("/home/sarav-zstch1200/Files/"+path+fileName+".txt");
				if(f.exists()) {
					FileWriter fw = new FileWriter("/home/sarav-zstch1200/Files/"+path+fileName+".txt", true);
					fw.write(fileContent);
					fw.close();
				}
			}catch(Exception e) {
				
			}
		}
		else {
			try {
				File f= new File("/home/sarav-zstch1200/Files/"+fileName+".txt");
				if(f.exists()) {
					FileWriter fw = new FileWriter("/home/sarav-zstch1200/Files/"+fileName+".txt", true);
					fw.write(fileContent);
					fw.close();
				}
			}catch(Exception e) {
				
			}
		}
	}
	

	//deletes the file
	public void deleteFile(String fileName, String path) {
		
		if(path != null) {
			File f= new File("/home/sarav-zstch1200/Files/"+path+fileName+".txt");
			if(f.exists()) {
				f.delete();
			}	
		}
		else {
			File f= new File("/home/sarav-zstch1200/Files/"+fileName+".txt");
			if(f.exists()) {
				f.delete();
			}
		}
	}
}
