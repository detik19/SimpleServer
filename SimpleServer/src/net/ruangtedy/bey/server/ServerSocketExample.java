package net.ruangtedy.bey.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//File Name GreetingServer.java

public class ServerSocketExample {
    private ServerSocket server;
    private int port = 9000;

    public ServerSocketExample() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSocketExample example = new ServerSocketExample();
        example.handleConnection();
    }

    public void handleConnection() {
        System.out.println("Waiting for client message...");

        //
        // The server do a loop here to accept all connection initiated by the
        // client application.
        //
        while (true) {
            try {
                Socket socket = server.accept();
                new ConnectionHandler(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

