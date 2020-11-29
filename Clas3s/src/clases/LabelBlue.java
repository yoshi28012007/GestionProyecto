package clases;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelBlue extends JLabel {

	private String Texto = "NO HAS PUESTO TEXTO x_x";
	
	public LabelBlue() {
		this.setText(this.Texto);
		this.setFont(new Font("arial",Font.BOLD,12));
		this.setForeground(Color.BLUE);
	}
	
	public LabelBlue(String pCadena) {
		this.setText(pCadena);
		this.setFont(new Font("arial",Font.BOLD,12));
		this.setForeground(Color.BLUE);	
	}

	public void pintarTexto(String pCadena) {
		this.setText(pCadena);
	}
}
