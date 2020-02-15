package com.gabor;

import java.io.File;
import java.io.FileNotFoundException;

public class FileCheckerProgram {

	public static void main(String[] args) {

		File fileToCheck = new File("/home/gabor/Scaricati/GIF-Buon-Anno.gif");
		
		FileChecker fileChecker = new FileChecker();
		
		try {
			System.out.println(fileChecker.checkWhetherExtensionReal(fileToCheck) ? "true" : "false");
		} catch (FileNotFoundException e) {
			System.out.println("Not existing file.");
		}
	}

}
