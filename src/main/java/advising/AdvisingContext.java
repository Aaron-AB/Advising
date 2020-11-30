package advising;

/**
 * This is  needed for the Strategy design pattern. Not Sure how to use it yet.
 * 
 * @author David Deonarine
 */

public class AdvisingContext {
    private AcademicAdvising strat;

    public void setAdvisingStrategy(AcademicAdvising strat){
        this.strat = strat;
    }
    
    public String adviseStudent(){
        return strat.getAdvisedListOfCourses();
    }
}

