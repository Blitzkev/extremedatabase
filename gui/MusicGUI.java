
/* MusicGUI
 *
 * file for initalizing the GUI frame and creates implementations for 
 * simple developer interaction.
 *
 * @author kyle shay april 25, 2011
 */ 
 package gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MusicGUI extends JFrame {

    TabbedDataPane tab = null;
	public MusicGUI() {
        //Create and set up the window.
        super("Music Manager");
		
		// Set close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add content to the window.
        tab = new TabbedDataPane();
        add(tab, BorderLayout.CENTER);
        
        //Display the window.
        pack();
		setVisible(true);
    }

	/* creates new tab with datatable as contents */
	public void addResultTable(String tabName, String query, String[] columnNames, Object[][] data) {  
		tab.createDataTab(tabName, query, columnNames, data);	
		pack();
	}

	public static MusicGUI addResultTab(String p, MusicGUI gui) {
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
		return gui;
		
	}
}
