package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import clases.Funciones;

public class TextBase extends JTextField {
	
	private int Longitud;
	private ManejadorFocus manejador0 = new ManejadorFocus();
	private Funciones MisFunciones = new Funciones();
	
	public TextBase() {
		this.Longitud = 20;
		this.setColumns(this.Longitud);
		this.addFocusListener(manejador0);
	}
	
	public TextBase(int pLongitud) {
		this.Longitud = pLongitud;
		this.setColumns(this.Longitud);
		this.addFocusListener(manejador0);		
	}
	
	private class ManejadorFocus implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			setForeground(Color.BLUE);
			setFont(new Font("arial",Font.BOLD,14));
			setBackground(Color.CYAN);
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			setText(MisFunciones.ConvertirPrimeraEnMayuscula(getText()));
			//setText(MisFunciones.ConvertirMayusculas(getText()));
			setForeground(Color.BLACK);
			setFont(new Font("arial",Font.BOLD,12));
			setBackground(Color.WHITE);
		}
		
	}
	
	

}
