/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package remotedesktopclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class RemoteDesktopClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            boolean exit = false;
            while (!exit) {
                System.out.println("\n--MENU--");
                System.out.println("1. Shutdown");
                System.out.println("2. Restart");
                System.out.println("3. Cancel Shutdown/Restart");
                System.out.println("4. Screenshot");
                int choice = sc.nextInt();
                System.out.println("Ban da chon: " + choice);
                sc.nextLine();
                
                switch (choice) {
                    case 1:
                        pw.println("shutdown");
                        pw.flush();
                        System.out.println(br.readLine());
                        break;
                    case 2:
                        pw.println("restart");
                        pw.flush();
                        System.out.println(br.readLine());
                        break;
                    case 3:
                        pw.println("cancel");
                        pw.flush();
                        System.out.println(br.readLine());
                        break;
                    case 4:
                        pw.println("screenshot");
                        pw.flush();

                        int imageSize = Integer.parseInt(br.readLine());
                        byte[] imageBytes = new byte[imageSize];
                        int byteRead = socket.getInputStream().read(imageBytes);
                        if (byteRead > 0) {
                            System.out.println("Nhap ten anh: ");
                            String fileName = sc.nextLine();
                            Path imagePath = Paths.get(fileName + ".jpg");
                            Files.write(imagePath, imageBytes);
                            System.out.println("Done!");
                        }

                        break;
                    default:
                        throw new AssertionError();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
