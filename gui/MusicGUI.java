
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
}
