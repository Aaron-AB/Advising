package advising;
/**Strategy used for advising Computer Science (Special) students */
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

    public boolean checkPrerequisitesForCoreCourses(Course course){
        String prereq = course.getPrerequisites();
        for (String c: student.getCoursesCompleted()){
            if ((c.equals(course.getPrerequisites())) || prereq.equals("NONE"))
                return true;
        }
        return false;
    }

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
        addLevel1Courses(); 
        
        return formattedRecommendations();
    } 

    public int getNumberOfCoursesBasedOnGPA(Student student) {
        if (student.getGPA()>4.3 || student.getGPA()<0)
            return 0;
        if (student.getGPA() >= gpaLowerLimit)
            return 5;
        return 3;
    }

    /**adds level one courses that are not completed */
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
    
    /**returns true if the student completed the prereqisite */
    public boolean isCompleted(Course course){
        boolean completed = false; 
        for (String c: student.getCoursesCompleted()){
                if (c.equals(course.getCourseCode()))
                    completed = true;
        }
        return completed;

    }

    /** returns a String that contains course recommendations */
    public String formattedRecommendations(){
        String formattedList = "Hello Computer Science (Special) student.";
        formattedList += "\nHere are your recommended courses for Semester " + student.getCurrentSemester() + "\n";
        for(Course c: recommendedCourses){
            formattedList += c.toString();
        }
        return formattedList;
    }
 
    /**returns an ArrayList containing the courses offered for Computer Science (Special) level 2 */
    private static ArrayList<Course> csSpecialCoursesL2(){
        ArrayList<Course> csLevel2 = new CourseService().getCS();
        return csLevel2;
    }

    /**returns an ArrayList containing the courses offered for Computer Science (Special) level 1 */
    private static ArrayList<Course> csSpecialCoursesL1(){
        ArrayList<Course> csLevel1 = new CourseService().getLevel1();
        return csLevel1;
    }
}