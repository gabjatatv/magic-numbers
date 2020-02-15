package com.gabor;

import java.io.File;
import java.io.FileNotFoundException;

public class FileChecker {

	private static final FileType[] SUPPORTED_FILETYPES_BESIDE_TXT = new FileType[] {new FileType("txt", new String[] {}), new FileType("jpg", new String[] {}), new FileType("gif", new String[] {})};
	
	public boolean checkWhetherExtensionReal(File fileToCheck) throws FileNotFoundException, UnsupportedOperationException{
		
		if (fileToCheck == null || !fileToCheck.exists() || !fileToCheck.isFile()) {
			throw new FileNotFoundException();
		}
		String extension = getExtension(fileToCheck);
		
		if (!isSupportedExtension(extension)) {
			throw new UnsupportedOperationException();
		}
		
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
	
	private boolean isSupportedExtension(String extension) {
		if (extension == null) {
			return false;
		}
		for (FileType nextFileType : SUPPORTED_FILETYPES_BESIDE_TXT) {
			if (extension.equals(nextFileType.getExtension().toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
