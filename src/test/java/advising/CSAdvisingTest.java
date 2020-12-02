package advising;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CSAdvisingTest {
    
    private Student student;
    private CSAdvising advising;
    private ArrayList<String> courses;

    @BeforeEach
    public void setUp(){
        courses = new ArrayList<String>();
        student = new Student("123", "Dolly", "1","Year 2", "BSc. Computer Science (Special)", 4.0, courses);
        advising = new CSAdvising(student);
    }

    @Test
    public void testCheckPrerequisitesForCoreCourses(){
        courses.add("COMP1600");
        Course course1 = new Course("MATH 2250", "", "NONE", 3, "1");
        assertTrue(advising.checkPrerequisitesForCoreCourses(course1));

        Course course2 = new Course("COMP 2601", "", "COMP 1600", 3, "1");
        assertTrue(advising.checkPrerequisitesForCoreCourses(course2));
    }

    @Test
    public void testGetAdvisedListOfCourses(){
        courses.add("COMP1600");
        courses.add("COMP1601");
        courses.add("COMP1602");
        courses.add("COMP1603");
        courses.add("COMP1604");
        courses.add("INFO1600");
        courses.add("INFO1601");
        courses.add("MATH1115");
        String actual = advising.getAdvisedListOfCourses();
        String expected = "Hello Computer Science (Special) student.\nHere are your recommended courses for Semester 1";
        expected += "\nCourse Code: COMP 2601	Course Title: Computer Architecture	Credits: 3";
        expected +="\nCourse Code: COMP 2602	Course Title: Computer Networks	Credits: 3";
        expected +="\nCourse Code: COMP 2605	Course Title: Enterprise Database Systems	Credits: 3";
        expected +="\nCourse Code: COMP 2611	Course Title: Data Structures	Credits: 3";
        expected += "\nCourse Code: MATH 2250	Course Title: Industrial Statistics	Credits: 3\n";
        assertEquals(expected, actual);
    }

    @Test
    public void testIsCompleted(){
        courses.add("COMP1600");
        Course course = new Course("COMP1600", "", "", 3, "1");
        assertTrue(advising.isCompleted(course));
    }

    @Test
    public void testGetNumberOfCoursesBasedOnGPA(){
        int actual = advising.getNumberOfCoursesBasedOnGPA(student);
        int expected = 5;
        assertEquals(expected, actual);

        ArrayList<String> courses = new ArrayList<String>();
        student = new Student("123", "Dolly", "1","Year 2", "BSc. Computer Science (Special)", 1.4, courses);
        int actual2 = advising.getNumberOfCoursesBasedOnGPA(student);
        int expected2 = 3;
        assertEquals(expected2, actual2);

        student = new Student("123", "Dolly", "1","Year 2", "BSc. Computer Science (Special)", 400, courses);
        int actual3 = advising.getNumberOfCoursesBasedOnGPA(student);
        int expected3 = 0;
        assertEquals(expected3, actual3);
    }


}
