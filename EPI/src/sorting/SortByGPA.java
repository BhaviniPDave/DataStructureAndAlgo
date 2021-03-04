package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByGPA {

    public static void sortByName(List<Student> students){
        Collections.sort(students);
    }

    public static void sortByGPA(List<Student> students) {
        students.sort((a,b) -> Double.compare(a.gradePointAverage,b.gradePointAverage));
    }

    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ian",45));
        students.add(new Student("July",95));
        students.add(new Student("April",75));
        students.add(new Student("David",85));
        students.add(new Student("Bhavini",90));

//        sortByGPA(students);
//
//        System.out.println(students);
        sortByName(students);

        System.out.println(students);

    }
}
