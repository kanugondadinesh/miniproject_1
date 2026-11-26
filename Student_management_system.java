import java.util.Scanner;
public class Student_management_system {
    public static void main(String[] args) {
        Student stu = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("===== STUDENT MANAGEMENT SYSTEM =====");
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Enter Marks");
            System.out.println("3. Display Student Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    stu = new Student(id, name, dept);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    if (stu == null) {
                        System.out.println("Please add a student first!");
                        break;
                    }
                    System.out.print("Enter Subject 1 Marks: ");
                    int m1 = sc.nextInt();
                    System.out.print("Enter Subject 2 Marks: ");
                    int m2 = sc.nextInt();
                    System.out.print("Enter Subject 3 Marks: ");
                    int m3 = sc.nextInt();
                    stu.setmarks(m1, m2, m3);
                    System.out.println("Marks updated successfully.");
                    break;
                case 3:
                    if (stu == null) {
                        System.out.println("Please add a student first!");
                        break;
                    }
                    stu.displayReport();
                    break;
                case 4:
                    System.out.println("Exiting Student Management System...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }
        }
    }
}
class Student {
    private int student_id;
    private String name;
    private String department;
    private int m1, m2, m3;
    Student(int student_id, String name, String department) {
        this.student_id = student_id;
        this.name = name;
        this.department = department;
    }
    public void setmarks(int m1, int m2, int m3) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }
    public int calculateTotal() {
        return m1 + m2 + m3;
    }
    public double calculateAverage() {
        return calculateTotal() / 3.0;
    }
    public String calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 90 && avg <= 100) {
            return "A+";
        } else if (avg >= 80) {
            return "A";
        } else if (avg >= 70) {
            return "B";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 50) {
            return "D";
        } else {
            return "Fail";
        }
    }
    public String getResult() {
        return calculateAverage() >= 50 ? "PASS" : "FAIL";
    }
    public void displayReport() {
        System.out.println("===== STUDENT REPORT =====");
        System.out.println("Student ID   : " + student_id);
        System.out.println("Name         : " + name);
        System.out.println("Department   : " + department);
        System.out.println("Total Marks  : " + calculateTotal());
        System.out.printf("Average      : %.1f%n", calculateAverage());
        System.out.println("Grade        : " + calculateGrade());
        System.out.println("Result       : " + getResult());
    }
}