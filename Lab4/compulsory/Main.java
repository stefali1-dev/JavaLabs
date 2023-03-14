package compulsory;
import java.util.*;
import java.util.stream.*;
public class Main {
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

        TreeSet<Project> projectSet = new TreeSet<>();

        for(Project proj : projects)

        {
            projectSet.add(proj);
        }

        for(Student stud : studentList){
            System.out.print(stud.getName() + " ");
        }

        System.out.println("");

        // the project set is already sorted because it's a tree set
        for(Project proj : projectSet)
        {
            System.out.print(proj.getName() + " ");
        }

    }
}