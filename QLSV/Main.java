package QLSV;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách");
            System.out.println("3. Tính điểm trung bình");
            System.out.println("4. Tìm sinh viên điểm cao nhất");
            System.out.println("5. Tìm sinh viên điểm thấp nhất");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    System.out.print("Nhập số sinh viên: ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng thừa
                    for (int i = 0; i < n; i++) {
                        System.out.print("SV " + (i + 1) + ": Tên = ");
                        String name = scanner.nextLine();
                        System.out.print("Điểm = ");
                        double score = scanner.nextDouble();
                        scanner.nextLine(); // Đọc bỏ dòng thừa
                        manager.addStudent(name, score);
                    }
                    break;
                case 2:
                    System.out.println("Danh sách sinh viên:");
                    manager.printStudents();
                    break;
                case 3:
                    System.out.println("Điểm trung bình cả lớp: " + manager.calculateAverageScore());
                    break;
                case 4:
                    Student highest = manager.findHighestScoreStudent();
                    if (highest != null) {
                        System.out.println("Sinh viên có điểm cao nhất: " + highest);
                    } else {
                        System.out.println("Danh sách sinh viên trống.");
                    }
                    break;
                case 5:
                    Student lowest = manager.findLowestScoreStudent();
                    if (lowest != null) {
                        System.out.println("Sinh viên có điểm thấp nhất: " + lowest);
                    } else {
                        System.out.println("Danh sách sinh viên trống.");
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);

        scanner.close();
    }
}