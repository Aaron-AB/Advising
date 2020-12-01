package advising;
//Strategy1
import java.util.ArrayList;
public class CSAdvising implements AcademicAdvising {

    final double gpaLowerLimit = 2;
    private Student student; 
    private ArrayList<Course> recommendedCourses; 
    private ArrayList<Course> coreCourses; //for level 2 core courses 
    ////private ArrayList<Course> coursesOffered; // maybe consider if it is being offered, or assume that hte courses read into the arrays are updated based on what is offered. 

    public CSAdvising(Student student){//Not used:, ArrayList<Course> coursesOffered){
        this.student = student; 
        this.coreCourses = csSpecialCoursesL2();
        //this.coursesOffered = coursesOffered;// see declaration for note
        recommendedCourses = new ArrayList<Course>();
    }

    /**
     * Checks if student successfully completed a prereq
     */
    public boolean checkPrerequisitesForCoreCourses(Course course){
        String prereq = course.getPrerequisites();
        for (String c: student.getCoursesCompleted()){
            if ((c.equals(course.getPrerequisites())) || prereq.equals("NONE"))
                return true;
        }
        return false;
        //Use Iterator
        // Add all the semester courses to a courses recommended ArrayList
       // If the courses the student needs(Failed Prerequisites) is in courses offered, Add to an ArrayList of recommended courses 
    }

    /**
     * Creates listed of 3-5 courses 
     */
    public String getAdvisedListOfCourses(){
        String currSem = student.getCurrentSemester(); 
        
        for (Course c: coreCourses){
                if ((c.getSemesterOffered().equals(currSem)) && checkPrerequisitesForCoreCourses(c) && (recommendedCourses.size()<getNumberOfCoursesBasedOnGPA(this.student))){
                    recommendedCourses.add(c);
                }  
        }
        addLevel1Courses(); //any outstanding level 1 if max not reached 
        
        return formattedRecommendations();
    } 

    /**
     * Add level one courses that were not successfully completed 
     */
    private void addLevel1Courses(){
        ArrayList<Course> l1 = csSpecialCoursesL1();
        String currSem = student.getCurrentSemester();
        int numCourses = getNumberOfCoursesBasedOnGPA(this.student);

        for (Course c: l1){
                if ((c.getSemesterOffered().equals(currSem)) && !isCompleted(c)){
                    if ((recommendedCourses.size()<numCourses)){
                        recommendedCourses.add(c);
                    }
                }  
        }
    }
    
    /**
     * Checks if course was preiously completed
     * This data would have been obtained from GUI choices 
     */
    private boolean isCompleted(Course course){
        boolean completed = false; 
        for (String c: student.getCoursesCompleted()){
                if (c.equals(course.getCourseCode()))
                    completed = true;
        }
        return completed;

    }

    public int getNumberOfCoursesBasedOnGPA(Student student) {
        if (student.getGPA() > gpaLowerLimit)
            return 5;
        return 3;
    }

    public String formattedRecommendations(){
        String formattedList = " ";
        for(Course c: recommendedCourses){
            formattedList += c.toString();
        }
        return formattedList;
    }
 
    //To be replaced by a file level 2 courses offered for CS only
    private static ArrayList<Course> csSpecialCoursesL2(){
        ArrayList<Course> l2 = new ArrayList<>();
        l2.add(new Course("COMP 2601", "Computer Architecture", "COMP 1600", 3,"1"));
        l2.add(new Course("COMP 2602", "Computer Networks", "COMP 1600", 3,"1"));
        l2.add(new Course("COMP 2605", "Enterprise Database Systems", "COMP 1602", 3,"1"));
        l2.add(new Course("COMP 2611", "Data Structures", "COMP 1603", 3,"1"));
        l2.add(new Course("MATH 2250", "Indutrial Statistics", "None", 3,"1"));
        l2.add(new Course("COMP 2603", "Object Oriented Programming I", "COMP 1603", 3,"2"));
        l2.add(new Course("COMP 2604", "Operating Systems", "COMP 1600", 3,"2"));
        l2.add(new Course("COMP 2606", "Software Engineering I", "COMP 1603", 3,"2"));
        l2.add(new Course("INFO 2602", "Web Programming and Technologies I", "INFO 1601", 3,"2"));
        l2.add(new Course("INFO 2604", "Information Systems Security", "COMP 1602", 3,"2"));
        return l2;
    }

    //To be replaced by a file Level 1 courses offered same file for CS and IT 
    private static ArrayList<Course> csSpecialCoursesL1(){
        ArrayList<Course> l1 = new ArrayList<>();
        l1.add(new Course("COMP 1600", "Introduction to Computing Concepts", "None", 3,"1"));
        l1.add(new Course("COMP 1601", "Computer Programming 1", "None", 3,"1"));
        l1.add(new Course("COMP 1602", "Computer Programming 2", "None", 3,"2"));
        l1.add(new Course("COMP 1603", "Computer Programming 3", "None", 3,"2"));
        l1.add(new Course("COMP 1604", "Mathematics for Computing", "None", 3,"2"));
        l1.add(new Course("INFO 1600", "Introduction to Information Technology Concepts", "None", 3,"1"));
        l1.add(new Course("INFO1601", "Introduction to WWW Programming", "None", 3,"2"));
        return l1;
    }

}