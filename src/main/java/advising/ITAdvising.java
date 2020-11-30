/**
 * See CS Advising for comments / documentations
 * Ideally both gives same funtionality 
 */
package advising;
 import java.util.ArrayList;
 
public class ITAdvising implements AcademicAdvising {
    final double gpaLowerLimit = 2;
    private Student student;
    private ArrayList<Course> recommendedCourses;
    private ArrayList<Course> coreCourses;

    public ITAdvising(Student student, ArrayList<Course> coursesOffered){
        this.student = student;
        this.coreCourses = itSpecialCoursesL2();
        recommendedCourses = new ArrayList<Course>();
    }

    public boolean checkPrerequisitesForCoreCourses(Course course){
        String prereq = course.getPrerequisites();
        for (Course c: student.getCoursesCompleted()){
            if ((c.getCourseCode().equals(course.getPrerequisites())) || prereq.equals("NONE"))
                return true;
        }
        return false;
        //Use Iterator
        // Add all the semester courses to a courses recommended ArrayList
       // If the courses the student needs(Failed Prerequisites) is in courses offered, Add to an ArrayList of recommended courses 
    }

    public ArrayList<Course> getAdvisedListOfCourses(){
        String currSem = student.getCurrentSemester();
        
        for (Course c: coreCourses){
                if ((c.getSemesterOffered().equals(currSem)) && checkPrerequisitesForCoreCourses(c) 
                && (recommendedCourses.size()< getNumberOfCoursesBasedOnGPA(this.student))){
                    recommendedCourses.add(c);
                }  
        }
        addLevel1Courses();
        return recommendedCourses;
    } 


    public void addLevel1Courses(){
        ArrayList<Course> l1 = itSpecialCoursesL1();
        String currSem = student.getCurrentSemester();
        int numCourses = getNumberOfCoursesBasedOnGPA(this.student);

        for (Course c: l1){
                if ((c.getSemesterOffered().equals(currSem)) && !isCompleted(c)){
                    if ((recommendedCourses.size()<numCourses)){
                    //System.out.println(numRecommendations + "vs: " + numCourses);
                    recommendedCourses.add(c);
                    }
                }  
        }
    }

    private boolean isCompleted(Course course){
        boolean completed = false; 
        for (Course c: student.getCoursesCompleted()){
                if (c.getCourseCode().equals(course.getCourseCode()))
                    completed = true;
        }
        return completed;
    }

    public int getNumberOfCoursesBasedOnGPA(Student student) {
        if (student.getGPA() > gpaLowerLimit)
            return 5;
        return 3;
    }
 
    //To be replaced by a file IT level 2 courses 
    public static ArrayList<Course> itSpecialCoursesL2(){
        ArrayList<Course> l2 = new ArrayList<>();
        l2.add(new Course("COMP 2605", "Enterprise Database Systems", "COMP 1602", 3,"1"));
        l2.add(new Course("INFO 2601", "Networking Technologies Fundamentals", "COMP 1600", 3,"1")); //OR INFO 1600
        l2.add(new Course("INFO 2603 ", "Platform Technologies I", "COMP 1600", 3,"1")); //OR
        l2.add(new Course("INFO 2506", "Professional Ethics and Law ", "COMP 1600", 3,"1")); //OR
        l2.add(new Course("MATH 2250", "Indutrial Statistics", "None", 3,"1"));
        l2.add(new Course("COMP 2603", "Object Oriented Programming I", "COMP 1603", 3,"2"));
        l2.add(new Course("COMP 2606", "Software Engineering I", "COMP 1603", 3,"2"));
        l2.add(new Course("INFO 2600", "Information Systems Development", "INFO 1600", 3,"2"));
        l2.add(new Course("INFO 2602", "Web Programming and Technologies I", "INFO 1601", 3,"2"));
        l2.add(new Course("INFO 2604", "Information Systems Security", "COMP 1602", 3,"2"));
        return l2;
    }

    //To be replaced by a file same as CS 
    public static ArrayList<Course> itSpecialCoursesL1(){
        ArrayList<Course> l1 = new ArrayList<>();
        l1.add(new Course("COMP 1600", "Introduction to Computing Concepts", "None", 3,"1"));
        l1.add(new Course("COMP 1601", "Computer Programming 1", "None", 3,"1"));
        l1.add(new Course("COMP 1602", "Computer Programming 2", "None", 3,"2"));
        l1.add(new Course("COMP 1603", "Computer Programming 3", "None", 3,"2"));
        l1.add(new Course("COMP 1604", "Mathematics for Computing", "None", 3,"2"));
        l1.add(new Course("INFO 1600", "Introduction to Information Technology Concepts", "None", 3,"1"));
        l1.add(new Course("INFO 1601", "Introduction to WWW Programming", "None", 3,"2"));
        return l1;
    }

}