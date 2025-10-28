package QLTV;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

  
    public void addBook(Book book) {
        books.add(book);
        System.out.println("==> Thêm sách thành công!");
    }

    //líst book 
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Thư viện hiện không có sách nào.");
        } else {
            System.out.println("Danh sách sách:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Search name 
    public void searchBookByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với tên: " + title);
        }
    }

    // borrow book 
    public void borrowBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("==> Mượn sách thành công!");
                } else {
                    System.out.println("Sách đã được mượn.");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ID: " + id);
    }

    // reture book 
    public void returnBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("==> Trả sách thành công!");
                } else {
                    System.out.println("Sách chưa được mượn.");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ID: " + id);
    }
}
