import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // Student class
    static class Student {
        String name;
        int rollNo;
        String grade;

        Student(String name, int rollNo, String grade) {
            this.name = name;
            this.rollNo = rollNo;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    students.add(new Student(name, roll, grade));

                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Roll Number to Search: ");
                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.rollNo == searchRoll) {
                            System.out.println("\nStudent Found");
                            System.out.println("Name : " + s.name);
                            System.out.println("Roll No : " + s.rollNo);
                            System.out.println("Grade : " + s.grade);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.println("\n----- Student List -----");
                        for (Student s : students) {
                            System.out.println("Name : " + s.name);
                            System.out.println("Roll No : " + s.rollNo);
                            System.out.println("Grade : " + s.grade);
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Remove: ");
                    int removeRoll = sc.nextInt();

                    boolean removed = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).rollNo == removeRoll) {
                            students.remove(i);
                            removed = true;
                            System.out.println("Student removed successfully.");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Student Management System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
