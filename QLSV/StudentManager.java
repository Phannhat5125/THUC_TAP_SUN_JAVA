package QLSV;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // 1. Nhập danh sách sinh viên
    public void addStudent(String name, double score) {
        students.add(new Student(name, score));
    }

    // 2. In danh sách sinh viên
    public void printStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println("SV " + (i + 1) + ": " + students.get(i));
            }
        }
    }

    // 3. Tính điểm trung bình
    public double calculateAverageScore() {
        if (students.isEmpty()) return 0;
        double total = 0;
        for (Student student : students) {
            total += student.getScore();
        }
        return total / students.size();
    }

    // 4. Tìm sinh viên có điểm cao nhất
    public Student findHighestScoreStudent() {
        if (students.isEmpty()) return null;
        Student highest = students.get(0);
        for (Student student : students) {
            if (student.getScore() > highest.getScore()) {
                highest = student;
            }
        }
        return highest;
    }

    // 5. Tìm sinh viên có điểm thấp nhất
    public Student findLowestScoreStudent() {
        if (students.isEmpty()) return null;
        Student lowest = students.get(0);
        for (Student student : students) {
            if (student.getScore() < lowest.getScore()) {
                lowest = student;
            }
        }
        return lowest;
    }
}