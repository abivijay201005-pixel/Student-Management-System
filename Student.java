
package studentmanagement;

public class Student {
    private final int id;
    private String name;
    private int age;
    private String course;
    private String email;

    public Student(int id, String name, int age, String course, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student ID: " + id
                + "\nName: " + name
                + "\nAge: " + age
                + "\nCourse: " + course
                + "\nEmail: " + email;
    }

    public String toFileLine() {
        return id + "\t" + name + "\t" + age + "\t"
                + course + "\t" + email;
    }
}
