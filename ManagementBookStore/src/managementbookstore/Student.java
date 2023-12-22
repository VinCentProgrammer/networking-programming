/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementbookstore;

/**
 *
 * @author admin
 */
public class Student extends Thread{
    private long id;
    private Library library;
    private String bookTitle;

    public Student(long id, Library library, String bookTitle) {
        this.id = id;
        this.library = library;
        this.bookTitle = bookTitle;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                library.borrowBook(id, bookTitle);
                sleep((long)Math.random() * 10000);
                library.returnBook(id, bookTitle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
