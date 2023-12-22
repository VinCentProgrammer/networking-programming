/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreading;

/**
 *
 * @author admin
 */
public class TaskA extends Thread{

    @Override
    public void run() {
        while(true) {
            System.out.println("Task AAAAAAAA");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
    
}
