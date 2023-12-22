/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpclient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author admin
 */
public class UDPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress addressServer = InetAddress.getByName("localhost");
            int serverPort = 9877;

//            int i = 0;
            while (true) {
                String message = "Hello, UDP Server";
                byte[] sendData = message.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(
                        sendData, sendData.length, addressServer, serverPort);

                socket.send(sendPacket);
//                if (i == 10000) {
//                    break;
//                }
//                i++;
            }

//            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
