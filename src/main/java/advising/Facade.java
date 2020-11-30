package advising;

// Not sure what to name this class
// This class functions as the client for the stratgey design pattern 
public class Facade {

    public Student student;
    public AdvisingContext advisingC = new AdvisingContext();

    public Facade(Student student){
        this.student = student;
    }
    
    /**This method sets the advising strategy  for a student based on there Degree and advises them accordingly*/
    public String adviseStudent(){
        if(student.getDegree().equals("BSc. Computer Science (Special)"))
            advisingC.setAdvisingStrategy(new CSAdvising(student));

        if(student.getDegree().equals("BSc. Information Technology (Special)"))
            advisingC.setAdvisingStrategy(new ITAdvising(student));
        
        return advisingC.adviseStudent();
    }
    
       //The gui would create an instance of Student, then create an instance of Facade using the student object
       //The Facade instance would call adviseStudent which would return a string to the gui
       // The gui would then print this String 

}
