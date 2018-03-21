package test.java;

import main.java.Faculty;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestFaculty {
    Faculty facl = new Faculty();

    @Test
    public void compareStudentMarksTest(){
        assertEquals("[Name: Roman | Last name: Kozlov] MATH: [3, 3, 4, 2, 5]; " +
                        "PHYSICS: []; PHILOSOPHY: []; ENGLISH: []; ",
                facl.compareStudentMarks(facl.getStudents().get(2)));
    }


}
