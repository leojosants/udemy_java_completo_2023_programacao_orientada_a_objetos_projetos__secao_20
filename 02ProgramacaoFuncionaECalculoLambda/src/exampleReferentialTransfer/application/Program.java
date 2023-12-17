/*-------------------- packages section --------------------*/
package exampleReferentialTransfer.application;

/*-------------------- imports section --------------------*/
import java.util.Arrays;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- globals section --------------------*/
	public static int globalValue = 3;

	/*-------------------- functions section --------------------*/
	public static void changeOddValues(int[] vector) { // exemplo de função que não é referencialmente transparente
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] % 2 != 0) {
				vector[i] += globalValue;
			}
		}
	}
	
	private static void displayData(int[] vector) {
		System.out.println("\n----- Exibindo dados -----");
		System.out.println(Arrays.toString(vector));		
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("\n----- fim do programa -----");
	}

	private static void runProgram() {
		int[] vector_of_int = new int[] { 3, 4, 5 };
		changeOddValues(vector_of_int);
		displayData(vector_of_int);
		displayMessageEndOfProgram();
	}
	
	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
	}

}
