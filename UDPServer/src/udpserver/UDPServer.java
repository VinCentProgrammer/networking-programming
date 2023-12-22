/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udpserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author admin
 */
public class UDPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String receiveMessage = new String(
                        receivePacket.getData(), 0, receivePacket.getLength());
                if (receiveMessage.trim().length() > 0) {
                    System.out.println("receiveMessage" + receiveMessage);
                }
            }

//            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
