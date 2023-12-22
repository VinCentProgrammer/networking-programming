/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mymulticast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author admin
 */
public class Sender {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("230.0.0.1");
            MulticastSocket socket = new MulticastSocket();
            
            String message = "Hello from a sender.";
            byte[] sendData = message.getBytes();
            
            while(true) {
                DatagramPacket dataPacket = new DatagramPacket(
                        sendData, sendData.length, group, 9876);
                socket.send(dataPacket);
                Thread.sleep(1000);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
