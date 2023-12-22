/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package counter;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 1000; i++) {
                        counter.increasement();
                    }
                }
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i < 1000; i++) {
                        counter.increasement();
                    }
                }
        );
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Couter = " + counter.getCounter());
    }
}
