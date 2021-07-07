package main.java;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private List<GroupOfStudents> groups = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public Faculty(){
        groups.add(new GroupOfStudents(Discipline.MATH));
        groups.add(new GroupOfStudents(Discipline.PHYSICS));
        groups.add(new GroupOfStudents(Discipline.PHILOSOPHY));
        groups.add(new GroupOfStudents(Discipline.ENGLISH));

        students.add(new Student("Katya", "Glazacheva"));
        students.add(new Student("Artur", "Kallimulin"));
        students.add(new Student("Roman", "Kozlov"));
        students.add(new Student("Dimka", "Struzhkin"));

        for (GroupOfStudents group : groups) {
            for (Student student : students) {
                group.addStudents(student);
            }
        }
        Integer[] marksRoman = {3, 3, 4 , 2, 5};
        Integer[] marksArtur = {4, 5, 5 , 5};
        Double[] marksArturDouble = {4.4, 5d, 4.5, 4.7};
        Integer[] marksKatya = {5, 5, 5 , 5, 5};
        Integer[] marksKatya2 = {5, 5, 5 , 5};
        Double[] marksKatyaDouble = {4.9, 5d, 4.9, 4.99};

        groups.get(0).addMarks(students.get(2), marksRoman);
        groups.get(1).addMarks(students.get(1), marksArturDouble);
        groups.get(2).addMarks(students.get(1), marksArtur);
        groups.get(0).addMarks(students.get(0), marksKatya);
        groups.get(1).addMarks(students.get(0), marksKatyaDouble);
        groups.get(2).addMarks(students.get(0), marksKatya2);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (GroupOfStudents g : groups){
            result.append(g.getDiscipline().toString()).append("\n").append(g.toString());
        }
        return result.toString();
    }

    public String compareStudentMarks(Student student){
        if (student == null){
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append("[").append(student.toString()).append("] ");
        for (GroupOfStudents g : groups){
            if (g.getListOfStudents().contains(student)){
                result.append(g.getDiscipline()).append(": ");
                result.append(g.getGroupMarks().get(g.getListOfStudents().indexOf(student)).toString()).append("; ");
            }
        }
        return result.toString();
    }

    public List<Student> getStudents(){
        return students;
    }
}
