package advising;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class AdvisingAgentTest {

    private AdvisingAgent agent;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private ArrayList<String> courses;

    @BeforeEach
    public void setUp(){
        this.agent = new AdvisingAgent();
        courses = new ArrayList<String>();
        student1 = new Student("321", "Polly", "1","Year 2", "BSc. Information Technology (Special)", 1.5, courses);
        student2 = new Student("322", "Molly", "2", "Year 2", "BSc. Computer Science (Special)", 3.2, courses);
        student3 = new Student("323", "Dolly", "1", "Year 2", "BSc. Computer Science (Special)", 3, courses);
        student4 = new Student("324", "Bob", "1", "Year 2", "BSc. Information Technology (Special)", -2, courses);
    }

    @Test
    public void testAdvisingAgentCreation(){
        assertNotNull((Object)this.agent);
    }
    
    @Test
    public void testAdviseStudent1(){

        courses.add("COMP1601");
        courses.add("COMP1602");
        courses.add("COMP1604");
        courses.add("INFO1600");
        courses.add("INFO1601");
        String expected = "Hello Information Technology (Special) student.\nHere are your recommended courses for Semester 1"
                        + "\nCourse Code: COMP 2605\tCourse Title: Enterprise Database Systems\tCredits: 3"
                        + "\nCourse Code: INFO 2601\tCourse Title: Networking Technologies Fundamentals\tCredits: 3"
                        + "\nCourse Code: INFO 2603\tCourse Title: Platform Technologies I\tCredits: 3\n";
        assertEquals(expected, agent.adviseStudent(student1));
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
                        + "\nCourse Code: INFO 2602\tCourse Title: Web Programming and Technologies I\tCredits: 3"
                        + "\nCourse Code: INFO 2604\tCourse Title: Information Systems Security\tCredits: 3\n";
        assertEquals(expected, agent.adviseStudent(student2));
    }
    
    @Test
    public void testAdviseStudent3(){
        courses.add("COMP1601");
        courses.add("COMP1602");
        courses.add("COMP1604");
        courses.add("INFO1600");
        courses.add("INFO1601");

        String expected = "Hello Computer Science (Special) student.\nHere are your recommended courses for Semester 1"
                        + "\nCourse Code: COMP 2605\tCourse Title: Enterprise Database Systems\tCredits: 3"
                        + "\nCourse Code: MATH 2250\tCourse Title: Industrial Statistics\tCredits: 3"
                        + "\nCourse Code: COMP 1600\tCourse Title: Introduction to Computing Concepts\tCredits: 3"
                        + "\nCourse Code: MATH 1115\tCourse Title: Fundamental Mathematics for the General Sciences I\tCredits: 3\n";
        assertEquals(expected, agent.adviseStudent(student3));
    }

    @Test
    public void testAdviseStudent4(){
        courses.add("COMP1600");
        courses.add("COMP1601");
        courses.add("COMP1602");
        courses.add("COMP1603");
        courses.add("COMP1604");
        courses.add("INFO1600");
        courses.add("INFO1601");
        courses.add("MATH1115");
        
        String expected = "Attention Bob! Please enter a valid GPA!";
        String actual = agent.adviseStudent(student4);
        assertEquals(expected, actual);
    }  

}
