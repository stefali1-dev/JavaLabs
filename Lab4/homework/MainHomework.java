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

        // initialising objects to match the problem example
        TreeSet<Project> projectSet0 = new TreeSet<>(); // S0 = {P0, P1, P2}
        TreeSet<Project> projectSet1 = new TreeSet<>(); // S1 = {P0, P1}
        TreeSet<Project> projectSet2 = new TreeSet<>(); // S2 = {P0}

        for(Project proj : projects)

        {
            projectSet0.add(proj);
            projectSet1.add(proj);
            projectSet2.add(proj);
        }

        // removing problem from sets to match the example
        projectSet1.remove(projects[2]);
        projectSet2.remove(projects[2]);
        projectSet2.remove(projects[1]);

        // setting the admissible projects set
        studentList.get(0).setAdmissibleProjects(projectSet0);
        studentList.get(1).setAdmissibleProjects(projectSet1);
        studentList.get(2).setAdmissibleProjects(projectSet2);

        Problem problem = new Problem();
        problem.setStudentList(studentList);

        //displaying all the students that have a number of preferences lower than the average number of preferences(S2)
        problem.displayLowPreferencesStudents();

        // creating students with random names
        LinkedList<Student> randomStudents = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            randomStudents.add(new Student(Faker.instance().name().fullName()));
        }
        // creating projects with random names
        Set<Project> randomProjects = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            randomProjects.add(new Project(Faker.instance().code().gtin8()));
        }

        // randomly assign admissible projects to each student
        for (Student student : randomStudents) {
            int numPreferences = (int) (Math.random() * randomProjects.size());

            // making a net set with the randomly assigned projects
            TreeSet<Project> preferencesSet = new TreeSet<>();

            int count = 0;
            for (Project project : randomProjects){
                preferencesSet.add(project);
                count++;

                if(count == numPreferences)
                    break;
            }

            // saving the randomly assigned projects to each student
            student.setAdmissibleProjects(preferencesSet);
        }

        randomStudents.forEach(student -> {
            System.out.println("Admissible projects for student " + student.getName() + ": "
                    + student.getAdmissibleProjects());
        });

        problem.setStudentList(randomStudents);
        problem.setProjects(randomProjects);

        System.out.println("\nThe maximum cardinality matching between students and projects: ");
        System.out.println(problem.greedySolve());
    }
}