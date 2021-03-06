package advising;
/**Strategy used for advsing Information Technology (Special) students. */
import java.util.ArrayList;
 
public class ITAdvising implements AcademicAdvising {
    final double gpaLowerLimit = 2;
    private Student student;
    private ArrayList<Course> recommendedCourses;
    private ArrayList<Course> coreCourses;

    public ITAdvising(Student student){
        this.student = student;
        this.coreCourses = itSpecialCoursesL2();
        recommendedCourses = new ArrayList<Course>();
    }

    public boolean checkPrerequisitesForCoreCourses(Course course){
        String prereq = course.getPrerequisites();
        for (String c: student.getCoursesCompleted()){
            if((course.getPrerequisites().equals("COMP1600") || course.getPrerequisites().equals("INFO1600")) && (c.equals("COMP1600") || c.equals("INFO1600")))
                return true;
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
                if ((c.getSemesterOffered().equals(currSem)) && checkPrerequisitesForCoreCourses(c) 
                && (recommendedCourses.size()< getNumberOfCoursesBasedOnGPA(this.student))){
                    recommendedCourses.add(c);
                }  
        }
        addLevel1Courses();
        return formattedRecommendations();
    } 

    /**adds level one courses that are not completed  */
    public void addLevel1Courses(){
        ArrayList<Course> l1 = itSpecialCoursesL1();
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

    /**returns a String that contains course recommendations */
    public String formattedRecommendations(){
        String formattedList = "Hello Information Technology (Special) student.";
        formattedList += "\nHere are your recommended courses for Semester " + student.getCurrentSemester() + "\n";
        for(Course c: recommendedCourses){
            formattedList += c.toString();
        }
        return formattedList;
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

    /**returns the maximum number of courses a student can do */
    public int getNumberOfCoursesBasedOnGPA(Student student) {
        if (student.getGPA()>4.3 || student.getGPA()<0)
            return 0;
        if (student.getGPA() >= gpaLowerLimit)
            return 5;
        return 3;
    }
 
    /**returns an ArrayList containing the courses offered for Information Technology (Special) level 2 */
    public static ArrayList<Course> itSpecialCoursesL2(){
        ArrayList<Course> l2 = new CourseService().getIT();
        return l2; 
    }

    /**returns an ArrayList containing the courses offered for Information Technology (Special) level 2 */ 
    public static ArrayList<Course> itSpecialCoursesL1(){
        ArrayList<Course> itLevel1 = new CourseService().getLevel1();
        return itLevel1;
    }
}