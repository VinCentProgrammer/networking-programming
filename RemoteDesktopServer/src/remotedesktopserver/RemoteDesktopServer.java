/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package remotedesktopserver;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

/**
 *
 * @author admin
 */
public class RemoteDesktopServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to server: " + clientSocket.getInetAddress().getHostAddress());
                Thread threadClient = new Thread(
                        () -> threadClientHandler(clientSocket)
                );
                threadClient.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void threadClientHandler(Socket socket) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            while (true) {
                String request = br.readLine();
                if (request.equals("shutdown")) {
                    Runtime.getRuntime().exec("shutdown -s -t 3600");
                    pw.println("May tinh dang tat ...");
                    pw.flush();
                } else if (request.equals("restart")) {
                    Runtime.getRuntime().exec("shutdown -r -t 3600");
                    pw.println("May tinh dang khoi dong lai ...");
                    pw.flush();
                } else if (request.equals("cancel")) {
                    Runtime.getRuntime().exec("shutdown -a");
                    pw.println("May tinh dang huy shutdown hoac restart ...");
                    pw.flush();
                } else if (request.equals("screenshot")) {
                    // Chup anh
                    BufferedImage screenshot = new Robot().createScreenCapture(
                            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())
                    );
                    
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(screenshot, "jpg", baos);
                    
                    byte[] imageBytes = baos.toByteArray();
                    baos.close();
                    
                    pw.println(imageBytes.length);
                    pw.flush();
                    socket.getOutputStream().write(imageBytes);
                    
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
