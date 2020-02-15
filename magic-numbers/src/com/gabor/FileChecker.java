package com.gabor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FileChecker {

	private static final FileType[] SUPPORTED_FILETYPES_BESIDE_TXT = new FileType[] {new FileType("jpg", new String[] {}), new FileType("gif", new String[] {"474946383761", "474946383961"})};
	
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	
	public boolean checkWhetherExtensionReal(File fileToCheck) throws FileNotFoundException, UnsupportedOperationException{
		
		if (fileToCheck == null || !fileToCheck.exists() || !fileToCheck.isFile()) {
			throw new FileNotFoundException();
		}
		String extension = getExtension(fileToCheck);
		
		if (!isSupportedExtension(extension) && extension != "txt") {
			throw new UnsupportedOperationException();
		}
		
		String firstBytesOfFile = getFirstBytes(fileToCheck);
		
		System.out.println(hasMagicalNumber(firstBytesOfFile));
		
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
	
	private String getFirstBytes(File fileToRead) {
		
		InputStream inputStream = null;
		
		try {
			byte[] buffer = new byte[12]; 
			inputStream = new FileInputStream(fileToRead);
			inputStream.read(buffer);
			return bytesToHex(buffer);
		} catch(IOException e) {
			return null;
		}
	}
	
	private static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	private String hasMagicalNumber(String firstBytes) {
		for (FileType nextFileType : SUPPORTED_FILETYPES_BESIDE_TXT) {
			for (String nextPattern : nextFileType.getMagicPatterns()) {
				int length = nextPattern.length();
				if (firstBytes.length() >= length && firstBytes.substring(0, length).equals(nextPattern)) {
					return nextFileType.getExtension();
				}
			}
		}
		return null;
	}
}
