/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producercustomer;

import static java.lang.Thread.sleep;

/**
 *
 * @author admin
 */
public class Customer extends Thread {

    private int id;
    private Buffer buffer;

    public Customer(int id, Buffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            if (buffer.getSize() > 0) {
                buffer.removeProduct(this.id);
                try {
                    sleep((long) Math.random() * 100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
