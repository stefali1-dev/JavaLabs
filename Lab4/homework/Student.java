package homework;

import java.util.TreeSet;

public class Student implements Comparable<Student>{
    String name;

    TreeSet<Project> admissibleProjects;
    public TreeSet<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void setAdmissibleProjects(TreeSet<Project> admissibleProjects) {
        this.admissibleProjects = admissibleProjects;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student student2) {
        return this.name.compareTo(student2.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
