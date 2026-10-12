
package studentmanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    private FileHandler() {
    }

    public static boolean saveStudents(List<Student> students) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {
                writer.write(student.toFileLine());
                writer.newLine();
            }

            return true;

        } catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
            return false;
        }
    }

    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t", -1);

                if (data.length != 5) {
                    continue;
                }

                try {
                    int id = Integer.parseInt(data[0]);
                    int age = Integer.parseInt(data[2]);

                    if (id > 0 && age > 0) {
                        students.add(new Student(
                                id, data[1], age, data[3], data[4]
                        ));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid student record.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading records: " + e.getMessage());
        }

        return students;
    }
}
