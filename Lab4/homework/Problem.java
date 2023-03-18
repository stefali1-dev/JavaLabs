package homework;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {

    LinkedList<Student> studentList;
    Map<Student, Project> maximumCardinalityMatching;

    public Problem() {
        studentList = new LinkedList<>();
        maximumCardinalityMatching = new HashMap<>();
    }

    public LinkedList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(LinkedList<Student> studentList) {
        this.studentList = studentList;
    }


    public Map<Student, Project> getMaximumCardinalityMatching() {
        return maximumCardinalityMatching;
    }

    public void displayLowPreferencesStudents()
    {
        double averagePreferences = studentList.stream()
                .mapToInt(student -> student.getAdmissibleProjects().size())
                .average()
                .orElse(0);

        List<Student> studentsWithFewPreferences = studentList.stream()
                .filter(student -> student.getAdmissibleProjects().size() < averagePreferences)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println("Students with fewer preferences than the average:");

        for(Student stud : studentsWithFewPreferences){
            System.out.println(stud.getName());
        }
    }
}
