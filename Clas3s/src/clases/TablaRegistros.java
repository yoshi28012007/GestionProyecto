package clases;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaRegistros extends JTable {
	
	private DefaultTableModel Modelo;
	private List<String> Titulos; 
		
	public TablaRegistros(List<String> pListaTitulos, ResultSet pRegistros ) {
		this.Titulos = pListaTitulos;
		this.Modelo = new DefaultTableModel();
		this.setModel(this.Modelo);
		this.LlenarModelo(pRegistros);
		this.SetAtributos();
	}
	
	private void SetAtributos() {
		this.getTableHeader().setReorderingAllowed(false);
		this.getTableHeader().setResizingAllowed(false);
//		this.setCellSelectionEnabled(true);
		
	    this.setShowHorizontalLines(true);
	    this.setRowSelectionAllowed(true);
	    this.setColumnSelectionAllowed( false );
	    // Cambiamos el color de la zona seleccionada (azul/amarillo)
	    this.setSelectionForeground(Color.BLUE);
	    this.setSelectionBackground(Color.YELLOW);
	    
	   // this.getColumn("Descripci�n").setMinWidth(200);
	   // this.getColumn("Descripci�n").setMaxWidth(200);
	    
	    
	}

	public void ImprimirRegistros() {
		
	}
	
	public void ExportarToExcel() {
		
	}
	
	public void ExportToPDF() {
		
	}
	
	
	public void LlenarModelo(ResultSet Registros) {
		
		this.Modelo.setRowCount(0);
		this.Modelo.setColumnCount(0);
		
		for (String nombre : this.Titulos) {
			this.Modelo.addColumn(nombre);
		}
		
		int NroColumnas = this.Modelo.getColumnCount();

		try {
			Registros.beforeFirst();
			while (Registros.next())
			{
			   // Se crea un array que ser� una de las filas de la tabla.
			   Object [] fila = new Object[NroColumnas]; // Hay 6 columnas en la tabla

			   // Se rellena cada posici�n del array con una de las columnas de la tabla en base de datos.
			   for (int i=0;i<NroColumnas;i++)
			      fila[i] = Registros.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

			      // Se a�ade al modelo la fila completa.
			   this.Modelo.addRow(fila);		   
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	

}
