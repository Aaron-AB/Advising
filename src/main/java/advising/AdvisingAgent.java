package advising;

/** */
public class AdvisingAgent {

    public Student student;
    public AdvisingContext advisingC = new AdvisingContext();

    public AdvisingAgent (){}
    
    /**returns recommended courses for a student  */
    public String adviseStudent(Student student){
        if(student.getDegree().equals("BSc. Computer Science (Special)"))
            advisingC.setAdvisingStrategy(new CSAdvising(student));

        if(student.getDegree().equals("BSc. Information Technology (Special)"))
            advisingC.setAdvisingStrategy(new ITAdvising(student));
        
        return advisingC.adviseStudent();
    }

}
