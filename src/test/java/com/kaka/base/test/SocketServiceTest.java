package com.kaka.base.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServiceTest {

	public static void main(String[] args) {
		try {
			System.out.println("begin");
			ServerSocket ss = new ServerSocket(8855);
			System.out.println("wait");
			Socket socket = ss.accept();
			System.out.println("accept");

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			String line = in.readLine();
			System.out.println("you input is :" + line);

			out.println("you input is :" + line);
			
			out.close();
			in.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
