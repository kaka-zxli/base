package com.kaka.base.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClientTest {

	public static void main(String[] args) {
		try {
			System.out.println("begin");
			Socket socket = new Socket(InetAddress.getLocalHost(), 8855);

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			out.println("hello");
			System.out.println("out over");

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(in.readLine());
			
			out.close();
			in.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
