package advising;

/**Strategy Interface */
public interface AcademicAdvising {

    final double gpaLowerLimit = 2;

    /**returns the maximum number of courses a student can do */
    public int getNumberOfCoursesBasedOnGPA(Student student);

    /**returns true if the student has completed the prereqisiute */
    public boolean checkPrerequisitesForCoreCourses(Course course);
    
    /**returns a recommended list of courses for a student */
    public String getAdvisedListOfCourses();

}
