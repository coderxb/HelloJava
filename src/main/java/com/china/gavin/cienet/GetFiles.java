package com.china.gavin.cienet;

import java.io.File;

public class GetFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "D:\\J_LearningMeterial";
		File files = new File(path);
		String[] fileArray = files.list();
		for (String file : fileArray) {
			System.out.println(file);
		}
	}

}
