/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stream;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Stream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("StreamOut"); // Output Stream
        Scanner sc = new Scanner(System.in); // Input Stream
        System.out.println("Nhap x = ");
        int x = sc.nextInt();
        x = x + 1;
        System.out.println("x = " + x);
        
    }
    
}
