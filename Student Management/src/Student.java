import java.util.Objects;

public class Student {
    private int studentId;
    private String studentName;
    private String major;

    public Student(int studentId, String studentName, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.major = major;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Student[" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", major='" + major + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentId);
    }

}
