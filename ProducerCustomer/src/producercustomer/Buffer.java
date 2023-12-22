/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producercustomer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Buffer {
    private int capacity;
    private ArrayList<Integer> products = new ArrayList<Integer>();

    public Buffer() {
        this.capacity = 0;
        this.products = new ArrayList<Integer>();
    }

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.products = new ArrayList<Integer>();
    }
    
    public int getSize() {
        return this.products.size();
    }
    
    public int getCapacity() {
        return this.capacity;
    }
    
    // Add product
    public void addProduct(int productID, int producerID) {
        System.out.println(">>>>----------------------");
        System.out.println("Nha san xuat " + producerID + " da them san pham " + productID);
        this.products.add(productID);
        System.out.println("So luong ton kho: " + this.products.size());
    }
    // Remove product
    public void removeProduct(int customerID) {
        System.out.println("<<<<----------------------");
        System.out.println("Khach hang " + customerID + " da mua san pham : " + this.products.get(0));
        this.products.remove(0);
        System.out.println("So luong ton kho: " + this.products.size());
    }
}
