/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreading;

/**
 *
 * @author admin
 */
public class TaskB implements Runnable{

    @Override
    public void run() {
        while(true) {
            System.out.println("Task BBBBBBBBBBB");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
    
}
