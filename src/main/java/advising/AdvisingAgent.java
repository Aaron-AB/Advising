package advising;

/** */
public class AdvisingAgent {

    //public Student student;
    public AdvisingContext advisingC = new AdvisingContext();

    public AdvisingAgent (){}
    
    /**@param Student this is the student created by the gui
     * @return recommended courses for a student  */
    public String adviseStudent(Student student){
        if(student.getDegree().equals("BSc. Computer Science (Special)"))
            advisingC.setAdvisingStrategy(new CSAdvising(student));

        if(student.getDegree().equals("BSc. Information Technology (Special)"))
            advisingC.setAdvisingStrategy(new ITAdvising(student));
        
        return advisingC.adviseStudent();
    }

}
