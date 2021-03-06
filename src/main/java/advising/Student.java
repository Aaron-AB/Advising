package advising;
import java.util.ArrayList;
public class Student {

    private String studentID;
    private String studentName;
    private String currentSemester;
    private String currentYear; 
    private double studentGPA;
    private String degree;
    private ArrayList<String> coursesCompleted;

    public Student(){}
    
    public Student(String studentID, String studentName,String currSem, String currYear, String degree, double gpa,  ArrayList<String> courses){
        this.studentID = studentID;
        this.studentName = studentName;
        this.currentSemester = currSem;
        this.currentYear = currYear;
        this.degree = degree;
        this.studentGPA = gpa;
        coursesCompleted = courses;
    }

    public Student(String studentID, String studentName,String currSem, String currYear, String degree, String gpa,  ArrayList<String> courses){
        this.studentID = studentID;
        this.studentName = studentName;
        this.currentSemester = currSem;
        this.currentYear = currYear;
        this.degree = degree;
        this.studentGPA = getGPADouble(gpa);
        coursesCompleted = courses;
    }

    public String getDegree(){
        return degree;
    }

    public String getName(){
        return studentName;
    } 

    public ArrayList<String> getCoursesCompleted() {
        return coursesCompleted;
    }
    
    public String toString(){
        return "Student ID: " + studentID + "\nStudent Name: " + studentName 
                + "\nSemester: " + currentSemester + "\nYear: " + currentYear
                + "\nDegree: " + degree + "\nStudent GPA: " + studentGPA  ;
    }

    public double getGPA() {return studentGPA;}

    public String getCurrentSemester(){
        return currentSemester;
    }

    private double getGPADouble(String gpa){
        try{
            double GPA = Double.parseDouble(gpa);
            if (GPA <0 || GPA >4.3)
            return -1;
            return GPA;
        }
         catch(NumberFormatException ex){
           return -1;
         }
    }
    
}