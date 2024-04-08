import java.io.*;
import java.util.*;

class Student {
    private String name;
    private int age;
    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Address: " + address;
    }
}

public class Main {
    private static final String FILENAME = "students.txt";

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
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner, students);
                    saveStudentsToFile(students);
                    break;
                case 2:
                    viewAllStudents(students);
                    break;
                case 3:
                    saveStudentsToFile(students);
                    break;
                case 4:
                    loadStudentsFromFile(students);
                    break;
                case 5:
                    updateStudent(scanner, students);
                    saveStudentsToFile(students);
                    break;
                case 6:
                    deleteStudent(scanner, students);
                    saveStudentsToFile(students);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void addStudent(Scanner scanner, List<Student> students) {
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

    private static void viewAllStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void saveStudentsToFile(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getAge() + "," + student.getAddress());
                writer.newLine();
            }
            System.out.println("Students saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    private static void loadStudentsFromFile(List<Student> students) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    students.add(new Student(name, age, address));
                }
            }
            System.out.println("Students loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("Error loading students from file: " + e.getMessage());
        }
    }

    private static void updateStudent(Scanner scanner, List<Student> students) {
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

    private static void deleteStudent(Scanner scanner, List<Student> students) {
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
}

