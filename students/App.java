package hus.oop.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }
                if (dataList.get(0).equalsIgnoreCase("id")) {
                    continue; // Skip header
                }

                String id = dataList.get(0);
                String lastName = dataList.get(1);
                String firstName = dataList.get(2);
                int yearOfBirth = Integer.parseInt(dataList.get(3));
                double mathsGrade = Double.parseDouble(dataList.get(4));
                double physicsGrade = Double.parseDouble(dataList.get(5));
                double chemistryGrade = Double.parseDouble(dataList.get(6));

                Student newStudent = new Student.StudentBuilder(id)
                        .withLastname(lastName)
                        .withFirstname(firstName)
                        .withYearOfBirth(yearOfBirth)
                        .withMathsGrade(mathsGrade)
                        .withPhysicsGrade(physicsGrade)
                        .withChemistryGrade(chemistryGrade)
                        .build();

                StudentManager.getInstance().append(newStudent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null) {
                    dataReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (String item : splitData) {
                result.add(item.trim());
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }
        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        init();

        System.out.println("=== Test original data ===");
        testOriginalData();

        System.out.println("\n=== Test sort students by name ===");
        testSortStudentsByName();

        System.out.println("\n=== Test sort students by average grade increasing ===");
        testSortAverageGradeIncreasing();

        System.out.println("\n=== Test sort students by average grade decreasing ===");
        testSortAverageGradeDecreasing();

        System.out.println("\n=== Test filter pass students ===");
        testFilterPassStudents();

        System.out.println("\n=== Test filter failure students ===");
        testFilterFailureStudents();
    }

    public static void init() {
        String filePath = "C:\\Users\\PhamDuyen\\Downloads\\OOPHKII2425_MidtermExam_De3\\data\\students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        
        StudentManager.getInstance().printListStudents();
    }

    public static void testSortStudentsByName() {
        List<Student> sortedList = StudentManager.getInstance().sortStudentsByName();
        StudentManager.print(sortedList);
    }

    public static void testSortAverageGradeIncreasing() {
        List<Student> sortedList = StudentManager.getInstance().sortAverageGradeIncreasing();
        StudentManager.print(sortedList);
    }

    public static void testSortAverageGradeDecreasing() {
        List<Student> sortedList = StudentManager.getInstance().sortAverageGradeDecreasing();
        StudentManager.print(sortedList);
    }

    public static void testFilterPassStudents() {
        List<Student> passList = StudentManager.getInstance().filterPassStudents();
        StudentManager.print(passList);
    }

    public static void testFilterFailureStudents() {
        List<Student> failList = StudentManager.getInstance().filterFailureStudents();
        StudentManager.print(failList);
    }
}
