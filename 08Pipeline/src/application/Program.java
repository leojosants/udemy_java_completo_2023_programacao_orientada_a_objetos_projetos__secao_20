/*-------------------- packages --------------------*/
package application;

/*-------------------- libraries --------------------*/
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions --------------------*/
	private static List<Integer> generateListInteger() {
		return Arrays.asList(3, 4, 5, 10, 7);
	}
	
	private static void example01(List<Integer> list) {
		Stream<Integer> stream_of_integers_1 = list.stream().map(x -> x * 10); // map - operacao intermediaria
		System.out.printf("Elementos multiplicados por 10 ........: %s%n", Arrays.toString(stream_of_integers_1.toArray()));
	}
	
	private static void example02(List<Integer> list) {
		int sum = list.stream().reduce(0, (x, y) -> x + y); // reduce - operacao terminal
		System.out.printf("Soma dos elementos ....................: %d%n", sum);
	}
	
	private static void example03(List<Integer> list) {
		List<Integer> list_of_integers = list.stream()
				.filter(x -> x % 2 == 0) 		// filter  - operacao intermediaria
				.map(x -> x * 10)				// map	   - operacao intermediaria 
				.collect(Collectors.toList()); 	// collect - operacao terminal
		System.out.printf("Elementos pares multiplicados por 10 ..: %s%n", Arrays.toString(list_of_integers.toArray()));
	}
	
	private static void runProgram() {
		List<Integer> list_of_integers = generateListInteger();
		System.out.printf("\nLista original ........................: %s%n", Arrays.toString(list_of_integers.toArray()));
		example01(list_of_integers);
		example02(list_of_integers);
		example03(list_of_integers);		
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("\n-----> fim do programa <-----");
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
		displayMessageEndOfProgram();
	}
}
