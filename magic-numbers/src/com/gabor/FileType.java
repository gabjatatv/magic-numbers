package com.gabor;

public class FileType {

	private String extension;
	private String[] magicPatterns;
	
	public FileType(String extension, String[] magicPatterns) {
		this.extension = extension;
		this.magicPatterns = magicPatterns;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String[] getMagicPatterns() {
		return magicPatterns;
	}
	public void setMagicPatterns(String[] magicPatterns) {
		this.magicPatterns = magicPatterns;
	}
	
}
