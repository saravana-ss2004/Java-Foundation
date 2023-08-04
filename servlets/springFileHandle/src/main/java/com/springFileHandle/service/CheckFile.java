package com.springFileHandle.service;

import java.io.File;

import org.springframework.stereotype.Component;

/**
 * @Author SaravanaKumar S S
 * @Email saravanakumar.ss@zohocorp.com
 * @since 02/08/2023
 */

/**
 * This class has checkFile method that returns Boolean value
 */
@Component("check")
public class CheckFile {
	
	/**
	 * This method checks the file exists or not
	 * @param filePath contains folder path
	 * @param fileName contains file name
	 * @return true if the file exists otherwise false
	 */
	public Boolean checkFile(String filePath, String fileName) {
		
		if(filePath != null) {
			if(fileName != null) {
				File f = new File("/home/sarav-zstch1200/Files/"+filePath+fileName+".txt");
				if(f.exists()) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		else {
			File f = new File("/home/sarav-zstch1200/Files/"+fileName+".txt");
			if(f.exists()) {
				return true;
			}
			else {
				return false;
			}
		}
		return null;
	}
	
}
