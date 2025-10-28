package QLTV;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xem danh sách sách");
            System.out.println("3. Tìm sách theo tên");
            System.out.println("4. Mượn sách");
            System.out.println("5. Trả sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String title = scanner.nextLine();
                    System.out.print("Tác giả: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Nhập tên sách cần tìm: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBookByTitle(searchTitle);
                    break;
                case 4:
                    System.out.print("Nhập ID sách cần mượn: ");
                    String borrowId = scanner.nextLine();
                    library.borrowBook(borrowId);
                    break;
                case 5:
                    System.out.print("Nhập ID sách cần trả: ");
                    String returnId = scanner.nextLine();
                    library.returnBook(returnId);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
