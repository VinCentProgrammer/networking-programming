/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package producercustomer;

/**
 *
 * @author admin
 */
public class ProducerCustomer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buffer buffer = new Buffer(100);
        Producer producer = new Producer(333, buffer);
        Customer customer = new Customer(1, buffer);
        
        Producer producer2 = new Producer(333, buffer);
        Customer customer2 = new Customer(2, buffer);
        
        Producer producer3 = new Producer(333, buffer);
        Customer customer3 = new Customer(3, buffer);
        
        producer.start();
        customer.start();
        
        producer2.start();
        customer2.start();
        
        producer3.start();
        customer3.start();

    }

}
