package demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// tao 1 server socket de lang nghe client
			ServerSocket serverSocket = new ServerSocket(5001);
			while(true) {
				Socket skServer = serverSocket.accept();
				DataInputStream inputServer = new DataInputStream(skServer.getInputStream());
				System.out.println("Client:"+inputServer.readUTF());
				
				DataOutputStream outServer = new DataOutputStream(skServer.getOutputStream());
				Scanner key = new Scanner(System.in);
				System.out.println("Server:");
				String chuoiServer = key.nextLine();
				outServer.writeUTF(chuoiServer+"\n");
				inputServer.close();
				outServer.close();
				skServer.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		
	}

}
