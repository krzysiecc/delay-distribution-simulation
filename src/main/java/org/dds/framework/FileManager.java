package org.dds.framework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	private String fileName;

	public FileManager(String fileName) {
		this.fileName = fileName;
	}

	public void createFile() {
	    try {
	        File file = new File(fileName);
	        file.delete();
	        file.createNewFile();
	    } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
	}

	public void writeToFile(String stuff) {
		try {
		    FileWriter fw = new FileWriter(fileName, true);
		    fw.write(stuff);
		    fw.close();
	    } catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
	    }
	}
}
