
/* testMusicGUI
 *
 * simple file for testing the GUI functionality.
 *
 * @author kyle shay april 25, 2011
 */ 
import gui.*;

public class testMusicGUI {

	public static MusicGUI gui = null;
    public static void main(String[] args) {
    
		// setup and show the GUI
		gui = new MusicGUI();
	
		// add some fake tabs...
		addResultTab("people");
		addResultTab("names");
		addResultTab("people2");
    }
	
	private static void addResultTab(String p) {
        String[] columnNames = {"First Name",
                                "Last Name",
                                "Sport",
                                "# of Years",
                                "Vegetarian"};
        Object[][] data = {
			{"Kathy", "Smith",
			 "Snowboarding", new Integer(5), new Boolean(false)},
			{"John", "Doe",
			 "Rowing", new Integer(3), new Boolean(true)},
			{"Sue", "Black",
			 "Knitting", new Integer(2), new Boolean(false)},
			{"Jane", "White",
			 "Speed reading", new Integer(20), new Boolean(true)},
			{"Joe", "Brown",
			 "Pool", new Integer(10), new Boolean(false)}
        };      

        gui.addResultTable(p, "select * from " + p, columnNames, data);    
	}
}
