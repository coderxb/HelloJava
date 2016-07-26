package com.china.gavin.javabase.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TalkClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 4700);
			BufferedReader is = new BufferedReader(new InputStreamReader(
					System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
