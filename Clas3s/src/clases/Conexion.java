//--------------------------------------------------------------------------------------------------------------------------
//  Clase    : 	Conexion.java
//	Autor	 :	Ing. Jorge Luis Lavalle Díaz
//  Objetivo : 	Clase que realiza la conexión a la base de datos
//  Fecha	 :	Created on 13 de abril de 2007, 05:02 PM
//  Observaciones : Se implemento tres tipos de host :
//                      localhost   -	cuando se desea trabajar con la base de datos local
//                      nethost     -	cuando se desea trabajar con la base de datos en red
//                      remotehost  -	cuando se desea trabajar con la base de datos remota
//---------------------------------------------------------------------------------------------------------------------------

package clases;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    public Connection Conn = null;			
    private String Host;
    private String Hosting = "";							// Nombre del host 
    private String Bd = "";									// Nombre de base de datos
    public String Url = "";									// Direcci�n Url
    private static String Login = "";						// User login - deberia ser el nickname del usuario
    private static String Password = "";					// Password que deberia ser encriptado y diferente para cada usuario
    private String Empresa = "";
    private int Tipo = 0;
    static String Controlador = "com.mysql.jdbc.Driver";	// Controlador de Mysql
    private Funciones Metodo;
    boolean EstaConectado = false;							// Variable booleana de conexi�n a la base de datos
    private Statement Instruccion;
    private ResultSet Consulta;
    
    public Conexion(String MiHosting, String MiBd, String MiLogin, String MiPass){
        this.Metodo = new Funciones();
        this.Hosting = MiHosting;
        this.Bd = MiBd;
        this.Login = MiLogin;
        this.Password = MiPass;
        this.SetTipo(0);
        if (ValidarPropiedades(this.Hosting,this.Bd,this.Login,this.Password,this.Tipo)==true) {
          Url = "jdbc:mysql://" + Hosting + "/" + Bd + "?autoReconnect=true";
        }
    }
    public Conexion(String MiHosting, String MiBd, String MiLogin, String MiPass, int MiTipo){
        this.Metodo = new Funciones();
        this.Hosting = MiHosting;
        this.Bd = MiBd;
        this.Login = MiLogin;
        this.Password = MiPass;
        this.SetTipo(MiTipo);        
//        System.out.println("Hosting=> "+ this.GetHosting());
//        System.out.println("BD=> " + this.GetBd());
//        System.out.println("LOgin=> " + this.GetLogin());
//        System.out.println("Passw=> " + this.GetPass());
//        System.out.println("Tipo=> " +this.GetTipo());
        if (ValidarPropiedades(MiHosting,MiBd,MiLogin,MiPass,this.GetTipo())==true) {
          Url = "jdbc:mysql://" + Hosting + "/" + Bd + "?autoReconnect=true";
        }        
    }
    public void AbrirConexion() throws InstantiationException, IllegalAccessException{
        try {
            Class.forName(Controlador).newInstance();
            Conn = DriverManager.getConnection(Url,Login,Password);		
            if (Conn != null){
                EstaConectado=true;
            }else{
                System.out.println("No se inicializó la conexión");
            }
        }catch(SQLException ex){
            EstaConectado=false;
            String Msg = "Hubo un problema al intentar conectarse a la base de datos \n" + Url + "\n" + ex;
            JOptionPane.showMessageDialog(null,Msg,"Error de Conexión" + "\n",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
	}catch(ClassNotFoundException ex){
            EstaConectado=false;
            String Msg = "No se pudo instanciar la clase \n" + ex;
            JOptionPane.showMessageDialog(null, Msg, "Error de conexión" + "\n" + ex , JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public void Reconectar(){
        //StWindowMessage Mensaje = new StWindowMessage("Reconexión en curso ....espere","ATENCION","information.png",true);
        //Mensaje.Mostrar();
        //Mensaje = null;
        try {
            this.AbrirConexion();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public void CerrarConexion(){
        try {
            Conn.close();
        } catch (SQLException ex) {
            String Msg = "Hubo un problema al intentar desconectarse de la base de datos \n" +  Url;
            JOptionPane.showMessageDialog(null, Msg,"Error de Conexión",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public Connection GetConexion() {
    	return this.Conn;
    }
    
    public boolean ValidarConexion(){
        boolean llPase = false;        
        try {
            String CadValida = "SELECT 1+1";
            Instruccion = this.Conn.createStatement();
            Consulta = Instruccion.executeQuery(CadValida);
            if(Consulta.next()==true){
                llPase = true;
            }
        } catch (SQLException ex) {
//            Logger.getLogger(StTestConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return llPase;        
    }
    public boolean EstaConectadoALaBD(){
        return EstaConectado;
    }
    private boolean ValidarPropiedades(String MiHosting, String MiBd, String MiLogin, String MiPass,int MiTipo){
        boolean llPase=true;
        if(MiHosting.isEmpty()==true){
            this.Host = "localhost";
            this.Hosting = Host;
        } else if(MiHosting.equals("nethost")==true){
            this.Host = MiHosting;
            //this.Hosting = this.Metodo.GetIpLan()+":3306";
            this.Hosting = ":3306";
        } else if(MiHosting.equals("remotehost")==true){
           this.Host = MiHosting;
            String Dominio = "";
            switch(this.GetTipo()){
                case 0:{
                    Dominio = "localhost";
                    //System.out.println(Dominio);                    
                    break;
                }
                case 1:{
                    Dominio = "";
                    break;
                }
                case 2:{
                    Dominio = "";
                    break;
                }
                case 3:{
                    Dominio = "";
                    break;
                }
                case 4:{
                    Dominio = "";
                    break;
                }
            }
            this.Hosting = ObtenerIP(Dominio) + ":3306";
        }
        if(MiBd.isEmpty()==true){
            switch(this.GetTipo()){
                case 0:{
                    this.Bd = "bd_cueto";
                    break;
                }
                case 1:{
                    this.Bd = "apreciow_ebo";                    
                    break;
                }
                case 2:{
                    this.Bd = "stinfosa_lima32";                    
                    break;
                }
                case 3:{
                    this.Bd = "stinfosa_pernifesa";
                }
                case 4:{
                    this.Bd = "pernifes_pernifesa";
                }
            }
        }
        if(MiLogin.isEmpty()==true){
            JOptionPane.showMessageDialog(null, "Usuario no válido","Error de Conexión",JOptionPane.ERROR_MESSAGE);
            llPase = false;
        } else {
            this.Login = MiLogin;
        }
        if(MiPass.isEmpty()==true){
            llPase = false;
        } else {
            this.Password = MiPass;
        }
        return llPase;
    }
    private static String ObtenerIP(String sHostName) {
        try {
        // Obtenemos la InetAddress de dicha URL
        InetAddress address = InetAddress.getByName(sHostName);
        // Cogemos la IP 
        byte[] bIPAddress = address.getAddress();	    
        return Ip2String(bIPAddress);
        //return ip2string_v2(bIPAddress);
        } catch (UnknownHostException e) {
        // Volcamos la excepcion e indicamos que no se ha podido resolver
        // e.printStackTrace();
        return "No se ha podido resolver";
        } 
    }
    private static String Ip2String(byte[] bIPAddress){
        String sIPAddress = "";
        for (int x=0; x<bIPAddress.length; x++) {
            if (x > 0) {
                // A todos los numeros les anteponemos
                // un punto menos al primero    
                sIPAddress += ".";
            }		
            // Jugamos con los bytes y cambiamos el bit del signo
            sIPAddress += bIPAddress[x] & 255;
        }
        return sIPAddress;
    }
    private static String Ip2String_v2(byte[] bIPAddress){
        String sIPAddress = "";
        for (int x=0; x < bIPAddress.length; x++) {
            if (x > 0) {
                sIPAddress += ".";
            } 
                sIPAddress += (bIPAddress[x]<0)?Integer.toString(bIPAddress[x]+256):Integer.toString(bIPAddress[x]);
        }
        return sIPAddress;
    }
    public String GetHost(){
        return this.Hosting;
    }	
    public String GetHosting(){
        return this.Host;
    }
    public String GetBd(){
        return this.Bd;
    }
    public String GetLogin(){
        return this.Login;
    }
    public String GetPass(){
        return this.Password;
    }
    public void SetTipo(int Valor){
        this.Tipo = Valor;
    }
    public int GetTipo(){
        return this.Tipo;
    }
	
//	public void SetModoTransaccion(boolean Flag){
//		try {
//			Conn.setAutoCommit(Flag);
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "No se pudo cambiar el modo de auto entrega", "setAutoCommit",JOptionPane.ERROR_MESSAGE);
//		}
//	}
}


