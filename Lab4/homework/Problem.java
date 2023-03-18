package homework;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {

    LinkedList<Student> studentList;
    Set<Project> projects;

    public Problem() {
        studentList = new LinkedList<>();
    }

    public LinkedList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(LinkedList<Student> studentList) {
        this.studentList = studentList;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
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

    /**
     * The algorithm starts with an empty set and a capacity of 1 for each project.
     * Then it tries to assign each student to one of its preferred projects that still has capacity.
     * If a match is found, the student and the project are added to the matching
     * and the capacity of the project is reduced by 1.
     * @return the maximum cardinality matching between students and projects
     */
    public Set<Pair> greedySolve() {
        Set<Pair> matching = new HashSet<>();
        Map<Project, Integer> projectToCapacity = new HashMap<>();
        for (Project project : projects) {
            projectToCapacity.put(project, 1);
        }
        for (Student student : studentList) {
            for (Project project : student.getAdmissibleProjects()) {
                if (projectToCapacity.get(project) > 0) {
                    matching.add(new ImmutablePair<>(student, project));
                    projectToCapacity.put(project, projectToCapacity.get(project) - 1);
                    break;
                }
            }
        }
        return matching;
    }
}
