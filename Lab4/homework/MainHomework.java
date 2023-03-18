package homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;
public class MainHomework {
    public static void main(String[] args) {

        // creating student objects array with streams
        Student[] students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);

        LinkedList<Student> studentList = new LinkedList<>();

        for(Student stud : students){
            studentList.add(stud);
        }

        // sorting the student list
        Collections.sort(studentList);

        // creating project objects array with streams
        Project[] projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);

        Arrays.sort(projects);

        TreeSet<Project> projectSet0 = new TreeSet<>();
        TreeSet<Project> projectSet1 = new TreeSet<>();
        TreeSet<Project> projectSet2 = new TreeSet<>();

        for(Project proj : projects)

        {
            projectSet0.add(proj);
            projectSet1.add(proj);
            projectSet2.add(proj);
        }

        projectSet1.remove(projects[2]);
        projectSet2.remove(projects[2]);
        projectSet2.remove(projects[1]);

        studentList.get(0).setAdmissibleProjects(projectSet0);
        studentList.get(1).setAdmissibleProjects(projectSet1);
        studentList.get(2).setAdmissibleProjects(projectSet2);

        Problem problem = new Problem();
        problem.setStudentList(studentList);

        problem.displayLowPreferencesStudents();

        // Create random names for students and projects
        List<Student> randomStudents = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            randomStudents.add(new Student(Faker.instance().name().fullName()));
        }

        List<Project> randomProjects = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            randomProjects.add(new Project(Faker.instance().code().gtin8()));
        }

        // Assign admissible projects to each student
        for (Student student : students) {
            int numPreferences = (int) (Math.random() * randomProjects.size());
            List<Project> preferences = randomProjects.subList(0, numPreferences);
            student.getAdmissibleProjects().addAll(preferences);
        }

        randomStudents.forEach(student -> {
            System.out.println(student.getName());
        });
        randomProjects.forEach(project -> {
            System.out.println(project.getName());
        });
    }
}