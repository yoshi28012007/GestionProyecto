package clases;

import java.awt.Color;	
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class FormBase extends JFrame {

	private String Titulo = "Hola soy una ventana";
	private int Alto = 250;
	private int Ancho = 550;
	private ManejadorKey manejador0 = new ManejadorKey();
	
	//Metodo constructor
	public FormBase () {
		//inicializamos los atributos
		this.setBackground(Color.YELLOW);
		this.setSize(this.Ancho, this.Alto);
		this.setTitle(this.Titulo);
		this.setLocationRelativeTo(null);
		this.addKeyListener(manejador0);
	
	}
	
	public ManejadorKey getManejadorKey() {
		return manejador0;
	}
	
	public void CambiarTamanio(int pAncho, int pAlto) {
		this.setAlto(pAlto);
		this.setAncho(pAncho);
	}
	
	public void setAlto(int pAlto) {
		this.Alto = pAlto;
		this.setSize(this.Ancho, this.Alto);
	}
	
	public void setAncho(int pAncho) {
		this.Ancho = pAncho;
		this.setSize(this.Ancho, this.Alto);		
	}
	
	//Metodo para mostrar la ventana
	public void Mostrar() {
		this.setVisible(true);
	}
	
	//Metodo para ocultar la ventana
	public void Cerrar() {
		dispose();
	}
	
	//Metodo para cambiar el titulo
	public void CambiarTitulo(String pTitulo) {
		this.setTitle(pTitulo);
	}
	
	private class ManejadorKey implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {}


		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==e.VK_ESCAPE) {
				Cerrar();
			}
			
		}

		
	}
	
}
