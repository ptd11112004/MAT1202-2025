package hus.oop.students;

import java.util.Comparator;

public class StudentComparator {
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getAverageGrade(), s2.getAverageGrade());
    }
}