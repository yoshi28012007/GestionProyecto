package clases;


import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.io.Serializable;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.EventObject;
import javax.swing.tree.*;

public class StJTable extends JTable{
	public StJTable() {
		super();
		this.SetStTable();
	}
	public StJTable(int numRows, int numColumns) {
		super(numRows, numColumns);
		this.SetStTable();
	}
	public StJTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		this.SetStTable();
	}
	public StJTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
		this.SetStTable();
	}
	public StJTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		this.SetStTable();
	}
	public StJTable(TableModel dm) {
		super(dm);
		this.SetStTable();
	}
	public StJTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
		this.SetStTable();

	}
	private void SetStTable() {
		this.getTableHeader().setReorderingAllowed(false);
		this.getTableHeader().setResizingAllowed(false);
//		this.setCellSelectionEnabled(true);
		
	    this.setShowHorizontalLines(true);
	    this.setRowSelectionAllowed(true);
	    this.setColumnSelectionAllowed( false );
	    // Cambiamos el color de la zona seleccionada (rojo/blanco)
	    this.setSelectionForeground(Color.BLUE);
	    this.setSelectionBackground(Color.YELLOW);
	}
	
    public boolean getScrollableTracksViewportWidth() {
        if (autoResizeMode != AUTO_RESIZE_OFF) {
        	if (getParent() instanceof JViewport) {
        		return (((JViewport)getParent()).getWidth() > getPreferredSize().width);
        	}
        }
        return false;
    }

	
	
//	public void SetCambiaColor(boolean Valor){
//		this.CambiaColor = Valor;
//	}
//	public boolean GetCambiaColor(){
//		return this.CambiaColor;
//	}
//	public void SetColorFondo1(Color Valor){
//		this.ColorFondo1 = Valor;
//	}
//	public Color GetColorFondo1(){
//		return this.ColorFondo1;
//	}
//	public void SetColorFondo2(Color Valor){
//		this.ColorFondo2 = Valor;
//	}
//	public Color GetColorFondo2(){
//		return this.ColorFondo2;
//	}
//	public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int colIndex) {
//	    Component component = super.prepareRenderer(renderer, rowIndex, colIndex);    
//	    if(GetCambiaColor()){
//	    	if(GetColorearSI()==true){
//	    		; component.setBackground(GetColorFondo1());
//	    		; component.setForeground(Color.YELLOW);
//	    	}else{
//	    		; component.setBackground(GetColorFondo2());
//	    	}
//	    }
//	    return component;
//	}
//	public boolean GetColorearSI() {
//
//		return false;
//	}
}


