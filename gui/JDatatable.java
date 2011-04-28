
/* JDatatable
 * simple gui for viewing non-editable tables
 *
 * @author kyle shay april 25, 2011
 */ 
 package gui;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;

public class JDatatable extends JPanel {
    public JDatatable(String[] columnNames, Object[][] data) {
        super(new GridLayout(1,0));
        
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		final JTable table = new JTable(model) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;   //Disallow the editing of any cell
			}
		};
        
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }
}