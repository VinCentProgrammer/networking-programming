/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverchat;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class ServerChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Tao server socket va lang nghe
            int port = 99;
            ServerSocket ss = new ServerSocket(port);
            
            // Chap nhan ket noi tu 1 client
            //Socket cs = ss.accept();
            
            // Chap nhan ket noi tu nhieu client
            while(true) {
                Socket cs = ss.accept();
                Thread client = new MyProcess(cs);
                client.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
