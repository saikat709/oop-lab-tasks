import java.util.*;

public class StudentManagementSystem {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        add5Students(students);
        for(Student student : students) {
            System.out.println(student);
        }

        students.add(2, new Student(678901, "Abccccc", "Biology"));
        students.remove(1);
        System.out.println();


        Set<Student> oopCourse = new HashSet<>();
        oopCourse.add(students.get(0));
        oopCourse.add(students.get(1));
        oopCourse.add(students.get(2));
        oopCourse.add(new Student(students.get(0).getStudentId(), "p", "der"));

        System.out.println("Number of students in OOP Course: " + oopCourse.size());
        if ( oopCourse.contains(students.get(1)) ) {
            System.out.println("SUCCESS: " + students.get(1) + " is already in OOP Course.");
        } else {
            System.out.println("ERROR:   " + students.get(1) + " is not in OOP Course.");
        }

        for (Student std: oopCourse) {
            System.out.println(std);
        }
        System.out.println();



        Map<Integer, Student> studentMap = new HashMap<>();
        for(Student student : students) {
            studentMap.put(student.getStudentId(), student);
        }
        Student std = studentMap.get(678901);
        if ( std != null ) {
            System.out.println("From map: " + std);
        } else {
            System.out.println("ERROR: Student not found.");
        }
    }

    public static void add5Students(List<Student> students) {
        students.add(new Student(123456, "Saikat", "Computer Science"));
        students.add(new Student(234567, "Tamim", "Mathematics"));
        students.add(new Student(345678, "Darun", "Physics"));
        students.add(new Student(456789, "Abc", "Biology"));
        students.add(new Student(567890, "Afif", "Chemistry"));
    }
}
