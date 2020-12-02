package advising;
//Strategy1
import java.util.ArrayList;
public class CSAdvising implements AcademicAdvising {

    final double gpaLowerLimit = 2;
    private Student student; 
    private ArrayList<Course> recommendedCourses; 
    private ArrayList<Course> coreCourses; 

    public CSAdvising(Student student){
        this.student = student; 
        this.coreCourses = csSpecialCoursesL2();
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
    }

    /**
     * Creates listed of 3-5 courses 
     */
    public String getAdvisedListOfCourses(){
        String currSem = student.getCurrentSemester(); 

        if (getNumberOfCoursesBasedOnGPA(student)==0){
            return "Attention " + student.getName() + "! Please enter a valid GPA!";
        }

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
    public boolean isCompleted(Course course){
        boolean completed = false; 
        for (String c: student.getCoursesCompleted()){
                if (c.equals(course.getCourseCode()))
                    completed = true;
        }
        return completed;

    }

    public int getNumberOfCoursesBasedOnGPA(Student student) {
        if (student.getGPA()>4.3 || student.getGPA()<0)
            return 0;
        if (student.getGPA() >= gpaLowerLimit)
            return 5;
        return 3;
    }

    public String formattedRecommendations(){
        String formattedList = "Hello Computer Science (Special) student.";
        formattedList += "\nHere are your recommended courses for Semester " + student.getCurrentSemester() + "\n";
        for(Course c: recommendedCourses){
            formattedList += c.toString();
        }
        return formattedList;
    }
 
    private static ArrayList<Course> csSpecialCoursesL2(){
        ArrayList<Course> csLevel2 = new CourseService().getCS();
        return csLevel2;
    }

    private static ArrayList<Course> csSpecialCoursesL1(){
        ArrayList<Course> csLevel1 = new CourseService().getLevel1();
        return csLevel1;
    }
}