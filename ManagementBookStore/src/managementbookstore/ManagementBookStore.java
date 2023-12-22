/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package managementbookstore;

/**
 *
 * @author admin
 */
public class ManagementBookStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book(1, "Book 1", "Author 1"));
        lib.addBook(new Book(2, "Book 2", "Author 2"));
        lib.addBook(new Book(3, "Book 3", "Author 3"));
        lib.addBook(new Book(4, "Book 4", "Author 4"));
        lib.addBook(new Book(5, "Book 5", "Author 5"));

        lib.print();

        Thread st1 = new Student(1, lib, "Book 1");
        Thread st2 = new Student(2, lib, "Book 2");
        Thread st3 = new Student(3, lib, "Book 3");

        st1.start();
        st2.start();
        st3.start();
    }

}
