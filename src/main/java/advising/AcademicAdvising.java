package advising;

/**Strategy Interface */
public interface AcademicAdvising {

    final double gpaLowerLimit = 2;

    /**@param Student 
     * @return the maximum number of courses a student can do */
    public int getNumberOfCoursesBasedOnGPA(Student student);

    /**@param Course
     * @return true if the student has completed the prereqisiute */
    public boolean checkPrerequisitesForCoreCourses(Course course);
    
    /**@return a recommended list of courses for a student */
    public String getAdvisedListOfCourses();

}
