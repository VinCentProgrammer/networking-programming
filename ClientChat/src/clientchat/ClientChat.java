/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientchat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ClientChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Ket noi den server
            int port = 99;
            Socket cs = new Socket("localhost", port);

            BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter pw = new PrintWriter(cs.getOutputStream());

            Scanner sc = new Scanner(System.in);
            String msg;

            while (true) {
                // Gui tin nhan
                System.out.print("Client: ");
                msg = sc.nextLine();
                pw.println(msg);
                pw.flush();

                // Nhan tin nhan
                msg = br.readLine();
                System.out.println("Server: " + msg);
            }
        } catch (Exception e) {
            System.out.println("Ket noi khong thanh cong!");
        }
    }

}
