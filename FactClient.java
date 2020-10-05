package demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;



public class FactClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			while(true) {
			Socket skClient = new Socket("localhost", 5000);
			//gui n di
			Scanner key = new Scanner(System.in);
			System.out.println("Nhap n=");
			String n = key.nextLine();
			//tao luong gui du lieu
			DataOutputStream outClient = new DataOutputStream(skClient.getOutputStream());
			outClient.writeUTF(n);
			//nhan dieu tu server
			DataInputStream inputClient = new DataInputStream(skClient.getInputStream());
			String kq = inputClient.readUTF();
			System.out.println("Giai thua ="+kq);
			outClient.close();
			inputClient.close();
			skClient.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
