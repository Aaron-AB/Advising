package advising;
// I think class should read the course info from the file. To add some form of reusablity to the solution
//Not Used cur rently 
import java.util.ArrayList; 
public class CoursesOffered {

private ArrayList<Course> coursesOffered;

public CoursesOffered(ArrayList<Course> courses){
    this.coursesOffered = new ArrayList<>(courses);
}

public ArrayList<Course> getCoursesOffered(){ 
    return coursesOffered;
}

public void addCourse(Course course){
    coursesOffered.add(course);
}

public void removeCourse(Course course){
    //Use iterator maybe?
}

}
