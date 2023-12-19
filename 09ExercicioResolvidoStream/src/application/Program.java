/*-------------------- packages --------------------*/
package application;

/*-------------------- libraries --------------------*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

/*-------------------- modules --------------------*/
import model.entites.Product;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions --------------------*/
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}
	
	private static String requestPath(Scanner scanner) {
		String path = null;
		System.out.print("\nEntre com o caminho do arquivo [c:\\...\\file.txt] ..: ");
		path = scanner.nextLine().trim();
		
		while (path.isEmpty()) {
			System.out.print("-> campo vazio, tente novamente! Entre com o caminho do arquivo [c:\\...\\file.txt] ..: ");
			path = scanner.nextLine().trim();
		}
		
		return path;
	}
	
	private static File generateInstenceFile(String path) {
		return new File(path);
	}
	
	private static FileReader generateInstanceFileReader(File file_path) throws FileNotFoundException {
		return new FileReader(file_path);
	}
	
	private static BufferedReader generateInstanceBufferedReader(FileReader file_reader) {
		return new BufferedReader(file_reader);
	}
	
	private static String readLine(BufferedReader buffered_reader) throws IOException {
		String line = buffered_reader.readLine();
		return line;
	}
	
	private static String[] splitLine(String line) {
		return line.split(",");
	}
	
	private static double convertStringFromDouble(String value) {
		return Double.parseDouble(value);
	}
	
	private static List<Product> generateInstanceListProduct() {
		return new ArrayList<>();
	}
	
	private static Product generateInstanceProduct(String name, double price) {
		return new Product(name, price);
	}
	
	private static Comparator<String> generateComparatorExpression() {
		Comparator<String> expression = (string_1, string_2) -> {
			return string_1.toUpperCase().compareTo(string_2.toUpperCase());
		};
		return expression;
	}
	
	private static void displayData(double average, List<String> list_of_names) {
		System.out.println("\n----- Exibindo dados -----");
		System.out.printf("Preço médio dos produtos ..: R$ %.2f%n", average);
		System.out.println("\nProdutos com preço abaixo da média");
		list_of_names.forEach(System.out::println);
	}

	private static void displayMessageIOException(Throwable e) {
		System.out.printf("erro ..: ", e.getMessage());
	}
	
	private static void displayMessageException(Throwable e) {
		System.out.printf("erro ..: ", e.getMessage());
	}
	
	private static void displayMessageEndOfProgram() {
		System.out.println("\n-----> fim do programa <-----");
	}
	
	private static void runProgram() throws FileNotFoundException {
		Locale.setDefault(Locale.US);
		Scanner	scanner = generateInstanceScanner();
		String path = requestPath(scanner);
		File file_path = generateInstenceFile(path);
		FileReader file_reader = generateInstanceFileReader(file_path);
		BufferedReader buffered_reader = generateInstanceBufferedReader(file_reader);
		List<Product> list_of_products = generateInstanceListProduct();
		
		try (buffered_reader) {
			String line = readLine(buffered_reader); // leitura da primeira linha
			
			while (line != null) {
				String[] fields = splitLine(line);
				String name = fields[0];
				double price = convertStringFromDouble(fields[1]);
				list_of_products.add(generateInstanceProduct(name, price));
				line = readLine(buffered_reader); // leitura do restante de linhas
			}
			
			double average = list_of_products.stream()
					.map(product -> product.getPrice())
					.reduce(0.0, (product_1, product_2) -> product_1 + product_2) / list_of_products.size();
			
			Comparator<String> comparator = generateComparatorExpression();
			
			List<String> list_of_names = list_of_products.stream()
					.filter(product -> product.getPrice() < average)
					.map(product -> product.getName())
					.sorted(comparator.reversed())
					.collect(Collectors.toList());

			displayData(average, list_of_names);
		} 
		catch (IOException e) {
			displayMessageIOException(e);
		}
		catch (Exception e) {
			displayMessageException(e);
		}
		finally {
			scanner.close();
			displayMessageEndOfProgram();
		}
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) throws FileNotFoundException {
		runProgram();
	}
}
