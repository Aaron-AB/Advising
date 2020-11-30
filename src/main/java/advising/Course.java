package advising;

//Course class 

public class Course {

    private String courseCode;
    private String courseTitle;
    private int credits;
    private String prerequisites;
    private String semesterOffered; 
    //private String courseDescription; //Can be implemented if time allows 

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
        String details = "Course Code: " + courseCode + "\n";
        details += "Course Title: " + courseTitle + "\n";
        details += "Credits: " + credits + "\n";
        return details;
    }
    
    /* 
    * This is the MAIN toString(). Needs to be properly formatted 
    public String toString(){
        String details = displayCourseInformation();
        details += "Prerequisites: " + prerequisites 
        + "\nSemester Offered: " + semesterOffered + "\n";
        //details += "Description: " + courseDescription + "\n";
        return details;
    } */

    public String toString(){ // For Testing purposes 
        return ("\nCourse Code: " + courseCode + "    " + "Course Title: " + courseTitle);
    }

}
