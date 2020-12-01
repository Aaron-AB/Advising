package advising;
//This class is to test that the Facade is functional;
import java.util.ArrayList;
public class FacadeTest {

        public static ArrayList<String> courses1() { //Test data for Student 1 
            ArrayList<String> courses1 = new ArrayList<>();
    
           /* Course comp1600 = new Course("COMP1600", "Introduction to Computing Concepts", "None", 3,"1");
            Course comp1601 = new Course("COMP1601", "Computer Programming 1", "None", 3,"1");
            Course comp1602 = new Course("COMP1602", "Computer Programming 2", "None", 3,"2");
            Course comp1603 = new Course("COMP1603", "Computer Programming 3", "None", 3,"2");
            Course comp1604 = new Course("COMP1604", "Mathematics for Computing", "None", 3,"2");
            Course info1600 = new Course("INFO1600", "Introduction to Information Technology Concepts", "None", 3,"1");
            Course info1601 = new Course("INFO1601", "Introduction to WWW Programming", "None", 3,"2");
    */
            courses1.add("COMP 1600");
            courses1.add("COMP 1601");
            courses1.add("COMP 1602");
            courses1.add("COMP 1603");
            courses1.add("COMP 1604");
            courses1.add("INFO 1600");
            courses1.add("INFO 1601");
    
            return courses1;
        }
        /*
        public static ArrayList<Course> courses2() { //Test data for Student 2
            ArrayList<Course> courses2 = new ArrayList<>();
    
            Course comp1600 = new Course("COMP1600", "Introduction to Computing Concepts", "None", 3,"1");
            Course comp1601 = new Course("COMP1601", "Computer Programming 1", "None", 3,"1");
            Course comp1602 = new Course("COMP1602", "Computer Programming 2", "None", 3,"2");
            Course comp1603 = new Course("COMP1603", "Computer Programming 3", "None", 3,"2");
    
            courses2.add(comp1600);
            courses2.add(comp1601);
            courses2.add(comp1602);
            courses2.add(comp1603);
    
            return courses2;
        }
        public static ArrayList<Course> courses3() { //Test data for Student 3
            ArrayList<Course> courses3 = new ArrayList<>();
            Course comp1602 = new Course("COMP1602", "Computer Programming 2", "None", 3,"2");
            Course comp1603 = new Course("COMP1603", "Computer Programming 3", "None", 3,"2");
            courses3.add(comp1602);
            courses3.add(comp1603);
            return courses3;
        }*/
        public static ArrayList<Course> coursesOffered(){ //May not be necessary (Was not used yet)
            ArrayList<Course>offered  = new ArrayList<>();
            offered.add(new Course("COMP 2601", "Computer Architecture", "COMP 1600", 3,"1"));
            offered.add(new Course("COMP 2602", "Computer Networks", "COMP 1600", 3,"1"));
            offered.add(new Course("COMP 2605", "Enterprise Database Systems", "COMP 1601", 3,"1"));
            offered.add(new Course("COMP 2611", "Data Structures", "COMP 1603", 3,"1"));
            offered.add(new Course("MATH 2250", "Indutrial Statistics", "None", 3,"1"));
            offered.add(new Course("INFO 2601", "Networking Technologies Fundamentals", "INFO 1600 OR COMP 1600", 3,"1"));
            offered.add(new Course("INFO 2603", "Platform Technologies I", "INFO 1600 OR COMP 1600", 3,"1"));
            offered.add(new Course("INFO 2605", "Professional Ethics and Law", "INFO 1600 OR COMP 1600", 3,"1"));
            offered.add(new Course("COMP 2603", "Object Oriented Programming I", "COMP 1603", 3,"2"));
            offered.add(new Course("COMP 2604", "Operating Systems", "COMP 1600", 3,"2"));
            offered.add(new Course("COMP 2606", "Software Engineering I", "COMP 1603", 3,"2"));
            offered.add(new Course("INFO 2600", "Information Systems Development", "INFO 1600", 3,"2"));
            offered.add(new Course("INFO 2602", "Web Programming and Technologies I", "INFO 1601", 3,"2"));
            offered.add(new Course("INFO 2604", "Information Systems Security", "COMP 1602", 3,"2"));
            return offered;
        }
    
        public static void main(String args[]) {
    
            //HomePage homePage = new HomePage(); //GUI Declaration and Instantiation. Need to 'hook' code
            // homePage.setVisible(true);
    
            ArrayList<String> student1Courses = courses1(); //for testing 
           // ArrayList<Course> student2Courses = courses2();
            //ArrayList<Course> student3Courses = courses3();
            
            //ArrayList<Course> coursesOffered = coursesOffered(); //needed for Advising constructor. Not used atm
            
            //ArrayList<Student> student = new ArrayList<Student>(); //To test students 
            
            Student rose =new Student ("012", "Rose Bushe","1","2","BSc. Computer Science (Special)", 4.21, student1Courses);
            //Student masha = new Student ("112", "Marsha Mello","2","2", "BSc. Information Technology (Special)", 2.3, student2Courses);
            //Student jub = new Student ("212", "Jub Jubilee","1","2", "BSc. Computer Science (Special)", 1.9, student3Courses);
           
            Facade testerRose = new Facade(rose);
            System.out.println(testerRose.adviseStudent());
/*
            Facade testerMasha = new Facade(masha);
            System.out.println(testerMasha.adviseStudent());

            Facade testerJub = new Facade(jub);
            System.out.println(testerJub.adviseStudent());
    */
        }
    }