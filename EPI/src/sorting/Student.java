package sorting;

public class Student implements Comparable<Student> {

    public String name;
    public double gradePointAverage;

    public Student(String name,double gradePointAverage){
        this.name = name;
        this.gradePointAverage = gradePointAverage;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}