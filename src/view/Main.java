package view;

import model.Student;
import storage.ReadWriteFile;
import studentManager.StudentManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Save Students to File");
            System.out.println("4. Load Students from File");
            System.out.println("5. Update Student Info");
            System.out.println("6. Delete Student");
            System.out.println("7. Search Student by Name");
            System.out.println("8. Sort Students by Age (Descending)");
            System.out.println("9. Sort Students by Age (Ascending)");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    StudentManager.addStudent(scanner, students);
                    ReadWriteFile.saveStudentsToFile(students);
                    break;
                case 2:
                    StudentManager.viewAllStudents(students);
                    break;
                case 3:
                    ReadWriteFile.saveStudentsToFile(students);
                    break;
                case 4:
                    ReadWriteFile.loadStudentsFromFile(students);
                    break;
                case 5:
                    StudentManager.updateStudent(scanner, students);
                    ReadWriteFile.saveStudentsToFile(students);
                    break;
                case 6:
                    StudentManager.deleteStudent(scanner, students);
                    ReadWriteFile.saveStudentsToFile(students);
                    break;
                case 7:
                    StudentManager.searchStudentByName(scanner, students);
                    break;
                case 8:
                    StudentManager.sortStudentsByAgeDescending(students);
                    break;
                case 9:
                    StudentManager.sortStudentsByAgeAscending(students);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
