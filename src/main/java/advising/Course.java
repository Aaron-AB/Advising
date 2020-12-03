package advising;
public class Course {

    private String courseCode;
    private String courseTitle;
    private int credits;
    private String prerequisites;
    private String semesterOffered; 
 
    public Course(String courseCode, String courseTitle, String prerequisites, int credits, String semOffered){
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.semesterOffered = semOffered;
    }
    
    public String getCourseCode() {
        return formatCourseCode(this.courseCode);
    }

    public String getPrerequisites() {
        return formatCourseCode(this.prerequisites);
    }

    public String formatCourseCode(String cCode) {
        return cCode.toUpperCase().replaceAll("\\s","");
    }

    public String getSemesterOffered(){
        return semesterOffered;
    }

    public String displayCourseInformation(){
        String details = "Course Code: " + courseCode;
        details += "\n Course Title: " + courseTitle;
        details += "\n Semester Offered: " + semesterOffered;
        details += "\n Prerequisites: " + prerequisites;
        details += "\n Credits: " + credits + "\n";
        return details;
    }

    public String toString(){
        String details = "Course Code: " + courseCode;
        details += "\tCourse Title: " + courseTitle;
        details += "\tCredits: " + credits + "\n";
        return details;
    }
}
