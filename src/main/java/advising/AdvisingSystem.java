package advising;

public class AdvisingSystem {
    
    public static void main(String[] args) {
        AdvisingAgent  advisingAgent = new AdvisingAgent();
        HomePage gui = new HomePage(advisingAgent);
        gui.setVisible(true); 
   }

}