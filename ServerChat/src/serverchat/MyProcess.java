/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverchat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class MyProcess extends Thread{
    private Socket socket;

    public MyProcess(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            
            Scanner sc = new Scanner(System.in);
            while(true) {
                String msg;
                // Nhan tin nhan
                msg = br.readLine();
                System.out.println("Client: " + msg);
                // Gui tin nhan
                System.out.print("Server: ");
                msg = sc.nextLine();
                pw.println(msg);
                pw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
