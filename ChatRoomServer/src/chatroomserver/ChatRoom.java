/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatroomserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ChatRoom {

    private static final int PORT = 5000;
    private List<ClientHandler> clients = new ArrayList<>();

    public void startServer() {
        try {
            // Websocket
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port: " + PORT);

            // Clients connect to server
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(
                        "New client connected: "
                        + clientSocket.getInetAddress().getHostAddress());

                ClientHandler clientHandler = new ClientHandler(
                        clientSocket, System.currentTimeMillis() + "", this);

                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String id, String message) {
        for (ClientHandler client : clients) {
            if (!client.getId().equals(id)) {
                client.sendMessage(id + ": " + message);
            }
        }
    }

}
