/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatroomclient;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.annotation.processing.Messager;

/**
 *
 * @author admin
 */
public class ChatClient {
    private static final String URL = "localhost";
    private static final int PORT = 5000;
    
    public void startClient() {
        try {
            Socket socketClient = new Socket(URL, PORT);
            System.out.println("Connected to server.");
            
            // Lien tuc doc du lieu tu server
            ClientListener clientListener = new ClientListener(socketClient);
            new Thread(clientListener).start();
            
            // Lien tuc doc du lieu tu scanner
            OutputStream output = socketClient.getOutputStream();
            Scanner sc = new Scanner(System.in);
            while(true) {
                String msg = sc.nextLine();
                output.write(msg.getBytes());
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
