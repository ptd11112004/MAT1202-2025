package hus.oop.students;

import java.util.*;

public class StudentManager {
    private static StudentManager instance;
    public List<Student> studentList;

    private StudentManager() {
        studentList = new ArrayList<>();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public void append(Student student) {
        studentList.add(student);
    }

    public void add(Student student, int index) {
        studentList.add(index, student);
    }

    public void remove(int index) {
        studentList.remove(index);
    }

    public Student studentAt(int index) {
        return studentList.get(index);
    }

    public int numberOfStudents() {
        return studentList.size();
    }

    public List<Student> sortStudentsByName() {
        List<Student> sorted = new ArrayList<>(studentList);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).compareTo(sorted.get(j)) > 0) {
                    Student temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }

    public List<Student> sortAverageGradeIncreasing() {
        List<Student> sorted = new ArrayList<>(studentList);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).getAverageGrade() > sorted.get(j).getAverageGrade()) {
                    Student temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }

    public List<Student> sortAverageGradeDecreasing() {
        List<Student> sorted = new ArrayList<>(studentList);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).getAverageGrade() < sorted.get(j).getAverageGrade()) {
                    Student temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }

    public List<Student> filterPassStudents() {
        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getAverageGrade() > 5.0 &&
                s.getMathsGrade() >= 4.0 &&
                s.getPhysicsGrade() >= 4.0 &&
                s.getChemistryGrade() >= 4.0) {
                result.add(s);
            }
        }
        return result;
    }

    public List<Student> filterFailureStudents(int howMany) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            int failCount = 0;
            if (s.getMathsGrade() < 4.0) failCount++;
            if (s.getPhysicsGrade() < 4.0) failCount++;
            if (s.getChemistryGrade() < 4.0) failCount++;
            if (s.getAverageGrade() < 5.0) failCount++;
            if (failCount >= howMany) result.add(s);
        }
        return result;
    }

    public List<Student> filterFailureStudents() {
        return filterFailureStudents(1);
    }

    public static void print(List<Student> students) {
        System.out.println("[");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("]");
    }

    public void printListStudents() {
        print(studentList);
    }

    public static String idOfStudentsToString(List<Student> students) {
        StringBuilder sb = new StringBuilder("[");
        for (Student s : students) {
            sb.append(s.getId()).append(" ");
        }
        return sb.toString().trim() + "]";
    }
}