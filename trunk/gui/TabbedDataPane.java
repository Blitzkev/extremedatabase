
/* TabbedDataPane
 * simple gui for viewing tables
 *
 * @author kyle shay april 25, 2011
 */

 package gui;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.GridLayout;

public class TabbedDataPane extends JPanel {

	JTabbedPane tabbedPane = null;
	
    public TabbedDataPane() {
        super(new GridLayout(1, 1));
        
        tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
        
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    
    /* creates new tab with datatable as contents */
    public void createDataTab(String tabName, String query, String[] columnNames, Object[][] data) {        
        JDatatable newContentPane = new JDatatable(columnNames, data);
		newContentPane.setOpaque(true); //content panes must be opaque
		
		if(tabbedPane != null) {
			tabbedPane.addTab(tabName, null, newContentPane, query);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
			
			tabbedPane.setTabComponentAt(tabbedPane.getTabCount()-1,
                 new ButtonTabComponent(tabbedPane));
			
		}
    } 
}
