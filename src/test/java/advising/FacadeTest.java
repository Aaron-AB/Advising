package advising;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class FacadeTest {

    private Facade facade;

    private Student itStudent;
    private Student csStudent;
    private ArrayList<String> courses;

    @BeforeEach
    public void setUp(){
        this.facade = new Facade();
        courses = new ArrayList<String>();
        itStudent = new Student("321", "Polly", "1","Year 2", "BSc. Information Technology (Special)", 1.5, courses);
        csStudent = new Student("322", "Molly", "2", "Year 2", "Bsc. Computer Science (Special)", 4.2, courses);
    }


    @Test
    public void testFacadeCreation(){
        assertNotNull((Object)this.facade);
    }

    @Test
    public void testAdviseStudent(){

        courses.add("COMP1600");
        courses.add("COMP1601");
        courses.add("COMP1602");
        courses.add("COMP1603");
        courses.add("COMP1604");
        courses.add("INFO1600");
        courses.add("INFO1601");
        courses.add("MATH1115");
        String expected = "Hello Information Technology (Special) student.\nHere are your recommended courses for Semester 1"
                        + "\nCourse Code: COMP 2605\tCourse Title: Enterprise Database Systems\tCredits: 3"
                        + "\nCourse Code: INFO 2601\tCourse Title: Networking Technologies Fundamentals\tCredits: 3"
                        + "\nCourse Code: INFO 2603\tCourse Title: Platform Technologies I\tCredits: 3\n";
        assertEquals(expected, facade.adviseStudent(itStudent));
    }

    @Test
    public void testAdviseStudent2(){

        courses.add("COMP1600");
        courses.add("COMP1601");
        courses.add("COMP1602");
        courses.add("COMP1603");
        courses.add("COMP1604");
        courses.add("INFO1600");
        courses.add("INFO1601");
        courses.add("MATH1115");

        String expected = "Hello Computer Science (Special) student.\nHere are your recommended courses for Semester 2"
                        + "\nCourse Code: COMP 2603\tCourse Title: Object Oriented Programming I\tCredits: 3"
                        + "\nCourse Code: COMP 2604\tCourse Title: Operating Systems\tCredits: 3"
                        + "\nCourse Code: COMP 2606\tCourse Title: Software Engineering I\tCredits: 3"
                        + "\nCourse Code: INFO 2602\tCourse Title: Web Programming and Technologies I\tCredits 3"
                        + "\nCourse Code: INFO 2604\tCourse Title: Information Systems Security\tCredits 3\n";
        assertEquals(expected, facade.adviseStudent(csStudent));


    }
    
}
