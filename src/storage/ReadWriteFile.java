package storage;

import model.Student;

import java.io.*;
import java.util.List;

public class ReadWriteFile {
    private static final String FILENAME = "students.txt";
    public static void saveStudentsToFile(List<Student> students) {
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

    public static void loadStudentsFromFile(List<Student> students) {
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
}
