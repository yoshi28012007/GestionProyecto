package clases;

public class Funciones {
	
	public String ConvertirMayusculas(String Cad){
        String Valor="";
        Valor = Cad.toUpperCase();
        return Valor;
    }
    public String ConvertirMinusculas(String Cad){
        String Valor="";
        Valor = Cad.toLowerCase();
        return Valor;
    }
    public String ConvertirPrimeraEnMayuscula(String Cad){
    	String Valor = "";
    	if(!Cad.equals("")) {
	        String CadAux = ConvertirMinusculas(Cad);
	        String Aux = ConvertirMayusculas(String.valueOf(CadAux.charAt(0)));
	        Valor = Aux;
	        for(int i=1; i<CadAux.length(); i++ ){
	            Aux = String.valueOf(CadAux.charAt(i));
	            if(Aux.equals(" ")){
	            if(i<CadAux.length()-1) {
	                i++;
	            }
	                Valor = Valor + Aux + ConvertirMayusculas(String.valueOf(CadAux.charAt(i)));;
	            }else{
	                Valor = Valor + Aux;
	            }
	        }
    	}
        return Valor;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Funciones MisFunciones = new Funciones();
		
		
		String cadenaOriginal = "hola mundo desde Cuet�lica, estamos programando en Java";
		System.out.println("Cadena original: " + cadenaOriginal);

		// Obtener primera letra y convertirla a may�scula
		String cadenafinal = MisFunciones.ConvertirPrimeraEnMayuscula(cadenaOriginal);
		System.out.println(cadenafinal);
		
		
		
		

	}

}
