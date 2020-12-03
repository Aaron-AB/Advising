package advising;
/**
 * 
 */

public class AdvisingContext {
    private AcademicAdvising strategy;

    public void setAdvisingStrategy(AcademicAdvising strategy){
        this.strategy = strategy;
    }
    
    public String adviseStudent(){
        return strategy.getAdvisedListOfCourses();
    }
}

