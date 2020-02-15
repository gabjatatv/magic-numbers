package com.gabor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileCheckerProgram {

	public static void main(String[] args) {

		// TODO read from the console
		
//		Scanner scanner = new Scanner(System.in);
		
		File fileToCheck = new File("/home/gabor/Scaricati/GIF-Buon-Anno.gif");
		
		FileChecker fileChecker = new FileChecker();
		
		try {
			System.out.println(fileChecker.checkWhetherExtensionReal(fileToCheck));
		} catch (FileNotFoundException e) {
			System.out.println("Not existing file.");
		} catch (UnsupportedOperationException e) {
			System.out.println("The file differentiator cannot handle that type of extension.");
		}
	}

}
