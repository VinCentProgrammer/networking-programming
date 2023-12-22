/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightstick;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class LightStickControllerServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("230.0.0.1");
            MulticastSocket socket = new MulticastSocket();
            
            String[] colors = {"Red", "Green", "Blue"};
            int colorIndex = 0;
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            
            while (true) {
                System.out.println("Ban muon chon mau gi?");
                System.out.println("0. Red");
                System.out.println("1. Green");
                System.out.println("2. Blue");
                
                colorIndex = sc.nextInt();
                if (colorIndex < 0 || colorIndex > 2) {
                    colorIndex = 0;
                }
                
                String message = colors[colorIndex];
                byte[] sendData = message.getBytes();
                DatagramPacket receivePacket = new DatagramPacket(
                        sendData, sendData.length, group, 9876);
                socket.receive(receivePacket);
                
                Thread.sleep(5000);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
