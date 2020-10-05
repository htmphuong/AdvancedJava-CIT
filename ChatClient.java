package demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			while(true) {
				Socket skClient = new Socket("localhost",5001);
				DataOutputStream outClient = new DataOutputStream(skClient.getOutputStream());
				Scanner key = new Scanner(System.in);
				System.out.println("Client:");
				String chuoiClient = key.nextLine();
				outClient.writeUTF(chuoiClient+"\n");
				
				//nhan server gui ve
				DataInputStream inputClient = new DataInputStream(skClient.getInputStream());
				System.out.println("Server:"+inputClient.readUTF());
				inputClient.close();
				outClient.close();
				skClient.close();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
