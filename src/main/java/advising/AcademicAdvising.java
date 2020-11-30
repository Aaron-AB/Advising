//interface for Strategy pattern
package advising;
import java.util.ArrayList;
public interface AcademicAdvising {

    final double gpaLowerLimit = 2;

    public int getNumberOfCoursesBasedOnGPA(Student student);

    public boolean checkPrerequisitesForCoreCourses(Course course);
    
    public ArrayList<Course> getAdvisedListOfCourses();

}
