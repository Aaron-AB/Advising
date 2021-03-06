package advising;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

public class CourseService {
    private ArrayList<Course> itCourses;
    private ArrayList<Course> csCourses;
    private ArrayList<Course> level1Courses;

    /**@return Initializes and fetches all courses on instantiation */
    public CourseService() {
        this.itCourses = new ArrayList<Course>();
        this.csCourses = new ArrayList<Course>();
        this.level1Courses =new ArrayList<Course>();
        this.fetchCourses();
    }

    /**@return Calls the fetchDegree function with the necessary json files */
    public void fetchCourses() {
        itCourses = this.fetchDegree("itSpecialL2Courses.json", "itSpecialL2Courses");
        csCourses = this.fetchDegree("csSpecialL2Courses.json", "csSpecialL2Courses");
        level1Courses = this.fetchDegree("level1Courses.json","level1Courses");
    }
    
    /**@param pathName the path to the json file 
     * @param arrayName the name of the json array present in the json file
     * @return Arraylist of courses that the json file contains */
    public ArrayList<Course> fetchDegree(String pathName, String arrayName) {
        ArrayList<Course> courses = new ArrayList<Course>();
        String contents = null;
        try {
            contents = new String((Files.readAllBytes(Paths.get(pathName))));
        } catch (IOException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject obj = new JSONObject(contents);

        JSONArray arr = obj.getJSONArray(arrayName);
        for (int i = 0; i < arr.length(); i++) {
            String courseCode = arr.getJSONObject(i).getString("Course Code");
            String semester = Integer.toString(arr.getJSONObject(i).getInt("Semester"));
            String prereq = arr.getJSONObject(i).getString("Prerequisites");
            String courseName = arr.getJSONObject(i).getString("Course Name");
            int credits = arr.getJSONObject(i).getInt("Credits");
            Course course = new Course(courseCode, courseName, prereq, credits, semester);
            courses.add(course);
        }
        return courses;
    }

    /**@return Fetches the information technology courses*/
    public ArrayList<Course> getIT() {
        return this.itCourses;
    }
    
    /**@return Fetches the computer science courses*/
    public ArrayList<Course> getCS() {
        return this.csCourses;
    }

    /**@return Fetches all level 1 courses for both Computer Science and Information Technology*/
    public ArrayList<Course> getLevel1() {
        return this.level1Courses;
    } 
    
    /**@return Prints the level 1 courses available*/
    public static void main(String[] args) throws IOException {
        CourseService cserv = new CourseService();
        System.out.println(cserv.getLevel1());
    }
}