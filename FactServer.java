package demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FactServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// tao 1 server socket de lang nghe client
			ServerSocket serverSocket = new ServerSocket(5000);
			while(true) {			
			//tao 1 socket de trao doi du lieu voi client
			Socket skServer= serverSocket.accept();
			System.out.println("Connected");
			//tao luong nhan du lieu
			DataInputStream inputServer = new DataInputStream(skServer.getInputStream());
			String n = inputServer.readUTF();
			System.out.println("n="+n);
			
			//tinh giai thua, tra kq ve client
			int so = Integer.parseInt(n);
			int kq=1;
			for(int i=1;i<=so;i++) kq=kq*i;
			//gui kq ve client
			DataOutputStream outServer =  new DataOutputStream(skServer.getOutputStream());
			outServer.writeUTF(String.valueOf(kq));
			outServer.close();
			inputServer.close();
			skServer.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
