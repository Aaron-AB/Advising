package advising;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ITAdvisingTest {
    
    private Student student;
    private ITAdvising advising;
    private ArrayList<String> courses;

    @BeforeEach
    public void setUp(){
        courses = new ArrayList<String>();
        student = new Student("321", "Polly", "1","Year 2", "BSc. Information Technology (Special)", 1.5, courses);
        advising = new ITAdvising(student);
    }

    @Test
    public void testCheckPrerequisitesForCoreCourses(){
        courses.add("INFO1600");
        Course course1 = new Course("MATH 2250", "", "NONE", 3, "1");
        assertTrue(advising.checkPrerequisitesForCoreCourses(course1));

        Course course2 = new Course("INFO 2601", "", "INFO 1600", 3, "1");
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
        String expected = "Hello Information Technology (Special) student.\nHere are your recommended courses for Semester 1";
        expected += "\nCourse Code: COMP 2605\tCourse Title: Enterprise Database Systems\tCredits: 3";
        expected +="\nCourse Code: INFO 2601\tCourse Title: Networking Technologies Fundamentals\tCredits: 3";
        expected +="\nCourse Code: INFO 2603\tCourse Title: Platform Technologies I\tCredits: 3\n";
        assertEquals(expected, actual);
    }

    @Test
    public void testIsCompleted(){
        courses.add("INFO1600");
        Course course = new Course("INFO1600", "", "", 3, "1");
        assertTrue(advising.isCompleted(course));
    }

    @Test
    public void testGetNumberOfCoursesBasedOnGPA(){
        int actual = advising.getNumberOfCoursesBasedOnGPA(student);
        int expected = 3;
        assertEquals(expected, actual);

        ArrayList<String> courses = new ArrayList<String>();
        student = new Student("123", "Dolly", "1","Year 2", "BSc. Information Technology (Special)", 1.4, courses);
        int actual2 = advising.getNumberOfCoursesBasedOnGPA(student);
        int expected2 = 3;
        assertEquals(expected2, actual2);

        student = new Student("123", "Dolly", "1","Year 2", "BSc. Information Technology (Special)", 400, courses);
        int actual3 = advising.getNumberOfCoursesBasedOnGPA(student);
        int expected3 = 0;
        assertEquals(expected3, actual3);
    }



}

