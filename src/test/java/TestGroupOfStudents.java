package test.java;

import main.java.Discipline;
import main.java.GroupOfStudents;
import main.java.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestGroupOfStudents {

    private GroupOfStudents<Integer> math = new GroupOfStudents<>(Discipline.MATH);
    private GroupOfStudents<Integer> phys = new GroupOfStudents<>(Discipline.PHYSICS);
    private GroupOfStudents<Double> phil = new GroupOfStudents<>(Discipline.PHILOSOPHY);
    private GroupOfStudents<Double> engl = new GroupOfStudents<>(Discipline.ENGLISH);

    private Student katya = new Student("Katya", "Glazacheva");
    private Student artur = new Student("Artur", "Kallimulin");
    private Student roman = new Student("Roman", "Kozlov");
    private Student dimka = new Student("Dimka", "Struzhkin");

    @Before
    public void setUp(){
        math.addStudents(katya,artur,roman,dimka);
        phys.addStudents(katya,artur,dimka);
        phil.addStudents(katya,artur);
        engl.addStudents(katya);

        math.addMarks(katya,5,5,5,5,5);
        math.addMarks(artur,4,4,4,4);
        math.addMarks(roman,3,3,3,3);
        phil.addMarks(katya,5d);
        engl.addMarks(katya,5d,5d,5d);
    }

    @Test
    public void testForAddStudents(){
        assertEquals("Name: Katya | Last name: Glazacheva",math.getListOfStudents().get(0).toString());
    }

    public void testForAddMarks(){
        List<Integer> marks = new ArrayList();
        marks.add(5);
        marks.add(5);
        marks.add(5);
        marks.add(5);
        marks.add(5);
        assertEquals(marks.toString(),math.getGroupMarks().get(0).toString());
    }
}
