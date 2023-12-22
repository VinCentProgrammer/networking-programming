/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myinetaddress;

import java.net.InetAddress;

/**
 *
 * @author admin
 */
public class MyInetAddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String domain = "google.com";
        try {
            // Example 1
            InetAddress address = InetAddress.getByName(domain);
            System.out.println("Domain: " + domain);
            System.out.println("IP: " + address.getHostAddress());
            
            // Example 2
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("IP localhost is: " + localHost.getHostAddress());
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
