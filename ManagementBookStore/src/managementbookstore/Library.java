/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementbookstore;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Library {

    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public /* synchronized */ void addBook(Book book) {
        System.out.println(">>> Da them sach " + book.getTitle());
        books.add(book);
    }

    public synchronized void borrowBook(long id, String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (book.isStatus()) {
                    book.setStatus(false);
                    System.out.println("<<< Sinh vien " + id + " da muon sach " + book.getTitle());
                    return;
                }
            }
        }
        System.out.println("--- Khong the muon sach " + title);
    }

    public synchronized void returnBook(long id, String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && !book.isStatus()) {
                book.setStatus(true);
                System.out.println(">>> Sinh vien " + id + " da tra sach " + book.getTitle());
                return;
            }
        }
        System.out.println("--- Khong the tra sach " + title);
    }

    public void print() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
