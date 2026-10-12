
package studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students =
            new ArrayList<>(FileHandler.loadStudents());

    public boolean addStudent(Student student) {
        if (findStudentById(student.getId()) != null) {
            System.out.println("Student ID already exists!");
            return false;
        }

        students.add(student);

        if (FileHandler.saveStudents(students)) {
            System.out.println("Student added successfully!");
            return true;
        }

        students.remove(student);
        return false;
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            System.out.println("\n" + student);
            System.out.println("---------------------------");
        }
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void searchStudent(int id) {
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println(student);
        }
    }

    public boolean updateStudent(
            int id, String name, int age, String course, String email) {

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }

        String oldName = student.getName();
        int oldAge = student.getAge();
        String oldCourse = student.getCourse();
        String oldEmail = student.getEmail();

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setEmail(email);

        if (FileHandler.saveStudents(students)) {
            System.out.println("Student updated successfully!");
            return true;
        }

        student.setName(oldName);
        student.setAge(oldAge);
        student.setCourse(oldCourse);
        student.setEmail(oldEmail);
        return false;
    }

    public boolean deleteStudent(int id) {
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }

        students.remove(student);

        if (FileHandler.saveStudents(students)) {
            System.out.println("Student deleted successfully!");
            return true;
        }

        students.add(student);
        return false;
    }

    public int getStudentCount() {
        return students.size();
    }

    public int getNextId() {
        int maxId = 0;

        for (Student student : students) {
            if (student.getId() > maxId) {
                maxId = student.getId();
            }
        }

        return maxId + 1;
    }
}
