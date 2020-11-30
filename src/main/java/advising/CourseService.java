package advising;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Test 
 */

public class CourseService {

    public static void main(String[] args) throws IOException {
        
        String contents = new String((Files.readAllBytes(Paths.get("courses.json"))));
        JSONObject obj = new JSONObject(contents);

        JSONArray arr = obj.getJSONArray("courses");
        for (int i = 0; i < arr.length(); i++) {
            String courseCode = arr.getJSONObject(i).getString("Course Code");
            String semester = Integer.toString(arr.getJSONObject(i).getInt("Semester"));
            String courseName = arr.getJSONObject(i).getString("Course Name");
            System.out.println("Course Code: " + courseCode + " Semester: " + semester + " Course Name: " + courseName);
        }
    }
}