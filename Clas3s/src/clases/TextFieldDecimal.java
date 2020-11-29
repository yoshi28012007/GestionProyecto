package clases;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
public class TextFieldDecimal extends JFormattedTextField {
	private DecimalFormat DispFormat;    // = new DecimalFormat("###,###,###.##");
//	private DecimalFormatSymbols Simbolos;
    private static Dimension Size = new Dimension(90,20);
    private ManejadorFocus manejador0 = new ManejadorFocus();    
    private ManejadorKey manejador1 = new ManejadorKey();
    //private StFunciones Metodo = new StFunciones();
//    private ManejadorChange manejador2 = new ManejadorChange();
//    private String Valor;
//    private String Moneda = "N";
    
    public TextFieldDecimal(String CodMoneda){
		MaskFormatter mf1;
		try {
			mf1 = new MaskFormatter("###.###,###");
			mf1.setPlaceholderCharacter(' ');
//			JFormattedTextField ftf1 = new JFormattedTextField(mf1
	   		this.setFormatter(mf1);
	   		this.setValue(new Double("0.00"));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	DispFormat = new DecimalFormat("###,###.###");
        setMinimumSize(Size);
        setPreferredSize(Size);
        setMaximumSize(Size);
        setForeground(Color.BLUE);
        setAlignmentX(JFormattedTextField.CENTER_ALIGNMENT);
        setHorizontalAlignment(JFormattedTextField.RIGHT);
        //Adicionamos los listeners
        addFocusListener(manejador0);
        addKeyListener(manejador1);
    }//Fin del segundo constructor StTextFieldDecimal(int)
    
    public TextFieldDecimal(){
    	this("N");
    }
    
    private class ManejadorFocus implements FocusListener{
        public void focusGained(FocusEvent e) {
            setBackground(Color.YELLOW);
//            Formatear();
        }
        public void focusLost(FocusEvent e) {
            setBackground(Color.WHITE);      
//            Formatear();
        }
    }
    private void Formatear() {
    	
//    	System.out.println("Tipo de dato => " + Metodo.GetTipoDato(getValue()));
    	
    	DispFormat.format(getValue());
    }
    private class ManejadorKey implements KeyListener{
        public void keyTyped(KeyEvent e) {}
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
        }
        public void keyReleased(KeyEvent e) {}
    }   
}

//import java.text.NumberFormat;
//public class formato 
//{
//  public static void main (String[] argv){
//    double value = 361.23456789;
//    NumberFormat nf = NumberFormat.getInstance();
//    nf.setMaximumFractionDigits(5); 
//    System.out.println(nf.format(value));   
//    nf.setMaximumFractionDigits(10); 
//    System.out.println(nf.format(value)); 
//    nf.setMaximumIntegerDigits(2); 
//    System.out.println(nf.format(value));
//    nf.setMaximumIntegerDigits(5); 
//    System.out.println(nf.format(value)); 
//
// } 
//}
