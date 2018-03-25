package main.java;

import java.util.ArrayList;
import java.util.List;

public class GroupOfStudents<T extends Number> {
    private Discipline discipline;
    private List<List<T>> groupMarks = new ArrayList<>();
    private List<Student> listOfStudents = new ArrayList<>();

    public GroupOfStudents(Discipline discipline){
        this.discipline = discipline;
    }

    public void addStudents (Student... students){
        for (Student std : students){
            if(!listOfStudents.contains(std)){
                listOfStudents.add(std);
                groupMarks.add(new ArrayList<>());
            }
        }

    }

    public void addMarks (Student std, T... marks){
        if(!listOfStudents.contains(std) || marks == null){
            return;
        }
        for(T mark : marks) {
            if (mark.getClass() == Double.class) {
                if ((Double) mark < 1 || (Double) mark > 5) {
                    return;
                }
            }
            if (mark.getClass() == Integer.class) {
                if ((Integer) mark < 1 || (Integer) mark > 5) {
                    return;
                }
            }
            int indexStd = listOfStudents.indexOf(std);
            groupMarks.get(indexStd).add(mark);
        }

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Student s : listOfStudents){
            result.append("[").append(s.getName()).append(" ").append(s.getLastName()).append("]").append(": ")
                    .append(groupMarks.get(listOfStudents.indexOf(s)).toString()).append("\n");
        }
        return result.toString();
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public List<List<T>> getGroupMarks() {
        return groupMarks;
    }

}
