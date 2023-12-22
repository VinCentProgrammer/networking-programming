/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package portscanner;

import java.net.Socket;

/**
 *
 * @author admin
 */
public class PortScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        checkPort("https://vandung.devcv.online/");
    }
    
    // Phuong thuc quet qua cac port cua mot website co dang mo khong?
    public static void checkPort(String urlString) {
        int portStart = 1;
        int portEnd = 100000;
        
        for(int i = portStart; i <= portEnd; i++) {
            try {
                Socket socket = new Socket(urlString, i);
                System.out.println("Cong " + i + " dang mo !");
                socket.close();
            } catch (Exception e) {
            }
        }
        
        System.out.println("Ket thuc scan port!");
    }
    
}
