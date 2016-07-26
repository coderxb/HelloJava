package com.china.gavin.javabase.file;

import java.io.File;

public class HelloFiles {

	public static void listFileAll(File file) {
		if (file == null) {
			System.out.println("this file is not exist");
			return;
		}
		System.out.println("Start output file context ...");
		if (file.isDirectory()) {
			File[] fileArray = file.listFiles();
			for (int i = 0; i < fileArray.length; i++) {
				listFileAll(fileArray[i]);
			}
		} else {
			System.out.println(file);
		}
	}

	public static void main(String[] args) {
		File file = new File("D:" + File.separator);
		listFileAll(file);
	}

}
