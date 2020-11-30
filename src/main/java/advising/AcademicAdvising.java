//interface for Strategy pattern
package advising;

public interface AcademicAdvising {

    final double gpaLowerLimit = 2;

    public int getNumberOfCoursesBasedOnGPA(Student student);

    public boolean checkPrerequisitesForCoreCourses(Course course);
    
    public String getAdvisedListOfCourses();

}
