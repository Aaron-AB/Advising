package advising;

public class AdvisingSystem {
    
    public static void main(String[] args) {
        Facade  facade = new Facade();
        HomePage gui = new HomePage(facade);
        gui.setVisible(true); 
   }

}