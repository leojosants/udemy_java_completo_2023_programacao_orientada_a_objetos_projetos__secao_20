/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import entites.Product;
import util.UpperCaseName;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	private static List<Product> generateInstanceProductList() {
		return new ArrayList<>();
	}

	private static Product generateInstanceProduct(String name, double price) {
		return new Product(name, price);
	}

	private static void addProduct(List<Product> list) {
		list.add(generateInstanceProduct("Tv", 900.00));
		list.add(generateInstanceProduct("Mouse", 50.00));
		list.add(generateInstanceProduct("Tablet", 350.00));
		list.add(generateInstanceProduct("HD Case", 80.90));
	}
	
	private static Function<Product, String> generateExpression() {
		return product -> product.getName().toUpperCase();
	}
	
	private static void displayListOfNames(List<String> list, int number) {
		System.out.printf("\n----- Exemplo %d -----%n", number);
		list.forEach(System.out::println);
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("\n----- fim do programa -----");
	}
	
	private static UpperCaseName generateInstanceUpperCaseName() {
		return new UpperCaseName();
	}

	private static List<String> exampleInterfaceImplementation(List<Product> list) {
		List<String> list_of_names = list.stream().map(generateInstanceUpperCaseName()).collect(Collectors.toList());
		return list_of_names;
	}
	
	private static List<String> exampleReferenceMethodWithStaticMethod(List<Product> list) {
		List<String> list_of_names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
		return list_of_names;
	}
	
	private static List<String> exampleReferenceMethodWithNonStaticMethod(List<Product> list) {
		List<String> list_of_names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());
		return list_of_names;
	}
	
	private static List<String> exampleDeclaredLambdaExpression(List<Product> list, Function<Product, String> expression) {		
		List<String> list_of_names = list.stream().map(expression).collect(Collectors.toList());
		return list_of_names;
	}
	
	private static List<String> exampleInlineLambdaExpression(List<Product> list) {
		List<String> list_of_names = list.stream().map(product -> product.getName().toUpperCase()).collect(Collectors.toList());
		return list_of_names;
	}
	
	private static void runProgram() {
		Locale.setDefault(Locale.US);
		
		List<Product> list_of_products = generateInstanceProductList();
		
		addProduct(list_of_products);
		
		
		List<String> list_of_names_1 = exampleInterfaceImplementation(list_of_products);
		displayListOfNames(list_of_names_1, 1);
		
		List<String> list_of_names_2 =  exampleReferenceMethodWithStaticMethod(list_of_products);
		displayListOfNames(list_of_names_2, 2);
		
		List<String> list_of_names_3 =  exampleReferenceMethodWithNonStaticMethod(list_of_products);
		displayListOfNames(list_of_names_3, 3);
		
		Function<Product, String> expression = generateExpression();
		List<String> list_of_names_4 =  exampleDeclaredLambdaExpression(list_of_products, expression);
		displayListOfNames(list_of_names_4, 4);
		
		List<String> list_of_names_5 =  exampleInlineLambdaExpression(list_of_products);
		displayListOfNames(list_of_names_5, 5);

		displayMessageEndOfProgram();
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
	}
}
