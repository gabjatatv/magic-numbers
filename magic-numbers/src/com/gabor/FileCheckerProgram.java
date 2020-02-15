package com.gabor;

import java.io.File;

public class FileCheckerProgram {

	public static void main(String[] args) {

		File fileToCheck = new File("/home/gabor/Scaricati/GIF-Buon-Anno.gif");
		
		FileChecker fileChecker = new FileChecker();
		
		System.out.println(fileChecker.checkWhetherExtensionReal(fileToCheck) ? "true" : "false");
	}

}
