/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package counter;

/**
 *
 * @author admin
 */
public class Counter {

    // Dong bo (synchronized) : Tai 1 thoi diem chi cho 1 thread duoc goi
    private int counter = 0;

    public synchronized void increasement() {
        counter++;
    }

    public int getCounter() {
        return this.counter;
    }
}
