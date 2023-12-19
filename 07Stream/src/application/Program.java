/*-------------------- packages --------------------*/
package application;

/*-------------------- libraries --------------------*/
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions --------------------*/
	private static List<Integer> generateListInteger() {
		return Arrays.asList(3, 4, 5, 10, 7);
	}
	
	private static void exampleOfIntermediateOperation(List<Integer> list_of_integers) {
		Stream<Integer> stream_of_integers_1 = list_of_integers.stream().map(x -> x * 10); // map
		System.out.println(Arrays.toString(stream_of_integers_1.toArray()));
	}
	
	private static void exampleCreateStream01() {
		Stream<String> stream_of_strings = Stream.of("Joao", "Ana", "Mara"); // Stream.of
		System.out.println(Arrays.toString(stream_of_strings.toArray()));
	}
	
	private static void exampleCreateStream02() {
		Stream<Integer> stream_of_integers_2 = Stream.iterate(0, x -> x + 2); 			// geracao de valores infinitos - Stream.iterate
		System.out.println(Arrays.toString(stream_of_integers_2.limit(10).toArray())); 	// operacao intermediaria - limit()
	}
	
	private static void exampleCreateStream03() {
		// Fibonacci
		Stream<Long> stream_of_longs = Stream.iterate(new long[] {0L, 1L}, p -> new long[] {p[1], p[0] + p[1]}).map(p -> p[0]); // map
		System.out.println(Arrays.toString(stream_of_longs.limit(10).toArray())); 												// operacao intermediaria - limit()
	}
	
	private static void runProgram() {
		List<Integer> list_of_integers = generateListInteger();
		exampleOfIntermediateOperation(list_of_integers);
		exampleCreateStream01();
		exampleCreateStream02();
		exampleCreateStream03();		
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
