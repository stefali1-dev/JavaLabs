package compulsory;

public class Student implements Comparable<Student>{
    String name;

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
}
