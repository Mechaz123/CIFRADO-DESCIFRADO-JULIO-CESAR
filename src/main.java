import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("main.in"));
			String linea;
			
			//Crear el abecedario
			char abecedario [] = new char [27];
			abecedario = crearAbecedario();
			
			while((linea = br.readLine())!=null){
				
				int array[] = new int [linea.length()];
				char resultado[] = new char[linea.length()];
				
				//Convierte el mensaje a los valores del alfabeto
				array = convertirValores(linea, array);
				
				//Encuentra todos los posibles casos de descifrado
				for(int i=0;i<abecedario.length;i++) {
					array = restarArray(array);
					for(int j=0;j<array.length;j++){
						resultado[j] = abecedario[array[j]];
					}
					System.out.print("CASO" + (i+1) + ": ");
					System.out.println(resultado);
				}	
			}
		}catch (Exception ex) {
			Logger.getLogger(main.class.getName()).log(Level.SEVERE,null,ex);
		}

	}
	
	
	public static char[] crearAbecedario() {
		char abecedario [] = new char [27];
		abecedario[0] = ' ';
		int letra = 97;
		for(int i=1;i<27;i++) {
			abecedario[i] = (char)letra;
			letra++;
		}
		return abecedario;
	}
	
	public static int[] convertirValores(String linea, int array[]) {
	
		for(int i=0;i<linea.length();i++) {
			array[i] = linea.charAt(i);
			if((array[i] - 96) == -64) {
				array[i] = 0;
			}else {
				array[i] = array[i] - 96;
			}
		}
		return array;
	}
	
	public static int[] restarArray(int array[]){
		int resta = 0;
		for(int i=0;i<39;i++) {
			resta = array[i] -1;
			if(resta < 0) {
				array[i] = 26;
			}else {
				array[i] = resta;
			}
		}
		return array;
	}
}