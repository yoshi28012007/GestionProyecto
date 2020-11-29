package clases;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelBlack extends JLabel {
	
	private String Texto = "NO HAS PUESTO TEXTO x_x";
	
	//Constructor sin par�metros
	public LabelBlack() {
		this.setText(this.Texto);
		this.setFont(new Font("arial",Font.BOLD,14));
		this.setForeground(Color.BLACK);	
	}
	
	//Constructor con un par�metro de tipo string
	public LabelBlack(String pCadena) {
		this.setText(pCadena);
		this.setFont(new Font("arial",Font.BOLD,14));
		this.setForeground(Color.BLACK);	
	}
	
	public void pintarTexto(String pCadena) {
		this.setText(pCadena);
	}


}
