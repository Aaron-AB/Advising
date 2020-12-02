package advising;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Order;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class StudentTest {
    
    private static Student student;

    @BeforeEach
    public void setUp(){
        ArrayList<String> courses = new ArrayList<String>();
        //courses.add("COMP1600","COMP1601","COMP1602","COMP1603","COMP1604","INFO1600","INFO1601","MATH1115");
        student = new Student("123", "Dolly", "1","Year 2", "BSc. Computer Science (Special)", 4.0, courses);
    }

    @Test
    public static void testGetDegree(){
        String actual = student.getDegree();
        String expected = "BSc. Computer Science (Special)";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetName(){
        String actual = student.getName();
        String expected = "Dolly";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetGpa(){
        Double actual = student.getGPA();
        Double expected = 4.0;
        assertEquals(expected, actual);

        ArrayList<String> courses = new ArrayList<String>();
        Student student2 = student = new Student("321", "Peaches", "1","Year 2", "BSc. Computer Science (Special)", "-123", courses);
        Double actual2 = student2.getGPA();
        Double expected2 = -1.0;
        assertEquals(expected2, actual2);
    }

    @Test
    public void testGetCurrentSemester(){
        String actual = student.getCurrentSemester();
        String expected = "1";
        assertEquals(expected, actual);
    }

    @Test
    @Order(3)
    public void testAddCoursesNeeded(){
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("COMP1600","COMP1601"));
        student.addCoursesNeeded(expected);
        ArrayList<String> actual = student.getCoursesCompleted();
        assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    public void testAddCourseToNeeded(){
        String course = "COMP1603";
        student.addCourseToNeeded(course);
        ArrayList<String> actual = student.getCoursesCompleted();
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("COMP1603"));
        assertEquals(expected, actual);
    }

    @Test
    public void testToString(){
        String expected = "Student ID: 123\nStudent Name: Dolly\nSemester: 1\nYear: Year 2\nDegree: BSc. Computer Science (Special)\nStudent GPA: 4.0";
        String actual = student.toString();
        assertEquals(expected, actual);
    }
}