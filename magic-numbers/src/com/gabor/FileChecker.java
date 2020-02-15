package com.gabor;

import java.io.File;
import java.io.FileNotFoundException;

public class FileChecker {

	private static final FileType[] SUPPORTED_FILETYPES_BESIDE_TXT = new FileType[] {};
	
	public boolean checkWhetherExtensionReal(File fileToCheck) throws FileNotFoundException{
		
		if (fileToCheck == null || !fileToCheck.exists() || !fileToCheck.isFile()) {
			throw new FileNotFoundException();
		}
		String extension = getExtension(fileToCheck);
		
		System.out.println(extension);
		
		return false;
	}
	
	private String getExtension(File file) {
		
		if (file == null) {
			return null;
		}

		String fileName = file.getName();
		int pointPosition = fileName.lastIndexOf('.');

		if (pointPosition > 0) {
		    return fileName.substring(pointPosition+1);
		}
		
		return null;
	}
}
