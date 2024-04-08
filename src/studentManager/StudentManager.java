package studentManager;

import model.Student;

import java.util.*;

public class StudentManager {
    public static void addStudent(Scanner scanner, List<Student> students) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter student address: ");
        String address = scanner.nextLine();

        Student student = new Student(name, age, address);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public static void viewAllStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void updateStudent(Scanner scanner, List<Student> students) {
        System.out.print("Enter the name of the student you want to update: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter new address: ");
                String newAddress = scanner.nextLine();

                student.setName(newName);
                student.setAge(newAge);
                student.setAddress(newAddress);

                System.out.println("Student information updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void deleteStudent(Scanner scanner, List<Student> students) {
        System.out.print("Enter the name of the student you want to delete: ");
        String name = scanner.nextLine();
        Iterator<Student> iterator = students.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Student deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void searchStudentByName(Scanner scanner, List<Student> students) {
        System.out.print("Enter the name of the student you want to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found:");
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void sortStudentsByAgeDescending(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getAge(), s1.getAge()); // Descending order
            }
        });

        System.out.println("Students sorted by age (descending) successfully.");
    }

    public static void sortStudentsByAgeAscending(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge()); // Ascending order
            }
        });

        System.out.println("Students sorted by age (ascending) successfully.");
    }
}
