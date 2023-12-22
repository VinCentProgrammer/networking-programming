/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dnclient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class DNClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("Nhap ten mien can tim IP: ");
                String domain = sc.nextLine();

                // Gui truy van
                byte[] sendData = domain.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData, sendData.length, serverAddress, serverPort);
                socket.send(sendPacket);

                // Nhap phan hoi
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                // Xuat ket qua
                String IP = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("IP: " + IP);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
