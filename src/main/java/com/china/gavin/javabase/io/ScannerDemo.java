package com.china.gavin.javabase.io;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner s = new Scanner("123");
		// Scanner s = new
		// Scanner("123 asdf sd 45 789 sdf asdfl,sdf.sdfl,asdf    ......asdfkl    las");
		// s.useDelimiter(" |,|\\.");

		printValue(s);
	}

	public static void printValue(Scanner scanner) {
		while (scanner.hasNext()) {
			// System.out.println(scanner.next());
			System.out.println(scanner.nextLine());
		}
	}

	public void inputScanner() {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入字符串：");
		while (true) {
			String line = s.nextLine();
			if (line.equals("exit"))
				break;
			System.out.println(">>>" + line);
		}
	}

}