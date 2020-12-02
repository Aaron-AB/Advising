package advising;
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

    public String formattedRecommendations(){
        String formattedList = "Hello Information Technology (Special) student.";
        formattedList += "\nHere are your recommended courses for Semester " + student.getCurrentSemester() + "\n";
        for(Course c: recommendedCourses){
            formattedList += c.toString();
        }
        return formattedList;
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
 
    public static ArrayList<Course> itSpecialCoursesL2(){
        ArrayList<Course> l2 = new CourseService().getIT();
        return l2; 
    }

    public static ArrayList<Course> itSpecialCoursesL1(){
        ArrayList<Course> itLevel1 = new CourseService().getLevel1();
        return itLevel1;
    }
}