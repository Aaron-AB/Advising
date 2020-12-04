package advising;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseTest {
    private Course course;

    @BeforeEach
    public void setUp(){
        course = new Course("COMP 1600", "Introduction to Computing Concepts", "NONE", 3, "1");
    }

    @Test
    public void testCourseCreation(){
        assertNotNull(course);
    }

    @Test
    public void testGetCourseCode(){
        String expected = "COMP1600";
        String actual = course.getCourseCode();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrequisites(){
        String expected1 = "NONE";
        String actual1 = course.getPrerequisites();
        assertEquals(expected1, actual1);

        Course course2 = new Course("COMP 2604", "Operating System", "COMP 1600", 3, "2");
        String expected2 = "COMP1600";
        String actual2 = course2.getPrerequisites();
        assertEquals(expected2, actual2);
    }

    @Test
    public void testGetSemesterOffered(){
        String expected = "1";
        String actual = course.getSemesterOffered();
        assertEquals(expected, actual);

        Course course2 = new Course("COMP 2604", "Operating System", "COMP 1600", 3, "2");
        String expected2 = "2";
        String actual2 = course2.getSemesterOffered();
        assertEquals(expected2, actual2);
    }

    @Test
    public void testDisplayCourseInformation(){
        String expected = "Course Code: COMP 1600";
        expected += "\n Course Title: Introduction to Computing Concepts";
        expected += "\n Semester Offered: 1";
        expected += "\n Prerequisites: NONE";
        expected += "\n Credits: 3\n";
        String actual = course.displayCourseInformation();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString(){
        String expected = "Course Code: COMP 1600";
        expected += "\tCourse Title: Introduction to Computing Concepts";
        expected += "\tCredits: 3\n";
        String actual = course.toString();
        assertEquals(expected, actual);
    }
    
}
