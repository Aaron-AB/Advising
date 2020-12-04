package advising;

/** Advises a student based on the set strategy */
public class AdvisingContext {
    private AcademicAdvising strategy;

    /**@param stategy indicates the strategy to be used when advising a student  */
    public void setAdvisingStrategy(AcademicAdvising strategy){
        this.strategy = strategy;
    }
    
    /**@return String of recommended courses */
    public String adviseStudent(){
        return strategy.getAdvisedListOfCourses();
    }
}

