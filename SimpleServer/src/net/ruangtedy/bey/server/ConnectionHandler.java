package net.ruangtedy.bey.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class ConnectionHandler implements Runnable {
	private Socket socket;

	public ConnectionHandler(Socket socket) {
		this.socket = socket;

		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String inputLine;

			//while ((inputLine = in.readLine()) != null)
			while(true){
				inputLine = in.readLine();
				 if (inputLine == null) {
                     break;
                 }
				System.out.println(inputLine);
				
			}
			socket.close();
			//	System.out.println("Waiting for client message...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}