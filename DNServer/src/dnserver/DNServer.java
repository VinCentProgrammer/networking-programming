/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dnserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author admin
 */
public class DNServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Tao ket noi
            DatagramSocket socket = new DatagramSocket(9876);
            System.out.println("DNS server is running...");
            
            // Gia lap bang dinh danh
            String[][] dnsTable = {
                {"www.example.com", "192.198.1.101"},
                {"www.example2.com", "88.88.88.88"},
                {"www.example3.com", "31.45.24.89"}
            };
            
            while(true) {
                // Tao va nhan packet
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                // Truy van IP tu domain
                String domainName = new String(
                        receivePacket.getData(), 0, receivePacket.getLength());
                domainName = domainName.trim();
                domainName = domainName.toLowerCase();
                
                String response = "Not found";
                
                for (String[] entry : dnsTable) {
                    if(entry[0].equals(domainName)) {
                        response = entry[1];
                        break;
                    }
                }
                
                // Phan hoi
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                
                byte[] responseData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        responseData, responseData.length, clientAddress, clientPort);
                socket.send(sendPacket);
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
