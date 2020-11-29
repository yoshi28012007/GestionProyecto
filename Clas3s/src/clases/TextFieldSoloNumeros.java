//------------------------------------------------------------
// Clase    : 	StTextFieldSoloNumeros.java
// Objetivo : 	Campo de texto para el ingreso de fechas.
// Autor    : 	Jorge Luis Lavalle Díaz
// Fecha	:	Domingo,20 de enero del 2008
//------------------------------------------------------------
package clases;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class TextFieldSoloNumeros extends JTextField {
	
    private static Dimension Size = new Dimension(70,20);
    private ManejadorFocus manejador0 = new ManejadorFocus();    
    private ManejadorKey manejador1 = new ManejadorKey();
    private int Longitud = 10;
    private String Valor = "";
    private boolean LlenarCeros= false;

    public TextFieldSoloNumeros(String Valor, int Longitud) {
        super(Valor);
        this.setForeground(Color.BLUE);
        this.setColumns(Longitud);
        this.addFocusListener(manejador0);
        this.addKeyListener(manejador1);
//        this.setText("");
    }//Fin del primer constructor StTextfieldDate()
    
    public void setValue(String Valor){
    	this.setText(Valor);
    }
    
    public String getValue(){
    	
    	return this.getText();
    	
//    	return this.Valor;
    }
    
    private class ManejadorFocus implements FocusListener{
        public void focusGained(FocusEvent e) {
            setBackground(Color.YELLOW);
        }
        public void focusLost(FocusEvent e) {
            setBackground(Color.WHITE);
        }
    }//Fin del método ManejadorFocus()
    
    private class ManejadorKey implements KeyListener{
        public void keyTyped(KeyEvent e) {
            char caracter = e.getKeyChar();
            // Verificar si la tecla pulsada no es un digito
            if(((caracter < '0') ||
               (caracter > '9')) &&
               (caracter != KeyEvent.VK_BACK_SPACE))
            {
               e.consume();  // ignorar el evento de teclado
            }
        }
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_ENTER){
                Robot Pulsar = null;
                try {
                    Pulsar = new Robot();
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }
                Pulsar.keyPress(KeyEvent.VK_TAB);
                Pulsar.keyRelease(KeyEvent.VK_TAB);
                Pulsar = null;
            }            
        }//Fin del método keyPressed(KeyEvent)
        public void keyReleased(KeyEvent e) {}
    }   
}
