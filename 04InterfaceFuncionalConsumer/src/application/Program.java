/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import entites.Product;
import util.PriceUpdate;

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
	
	private static void displayListOfProducts(List<Product> list) {
		System.out.println("----- Produtos -----");
		list.forEach(System.out::println);
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("----- fim do programa -----");
	}
	
	private static PriceUpdate generateInstancePriceUpdate() {
		return new PriceUpdate();
	}

	private static void exampleInterfaceImplementation(List<Product> list_of_products) {
		list_of_products.forEach(generateInstancePriceUpdate());		
	}
	
	private static void exampleReferenceMethodWithStaticMethod(List<Product> list) {
		list.forEach(Product::staticPriceUpdate);
	}
	
	private static void exampleReferenceMethodWithNonStaticMethod(List<Product> list) {
		list.forEach(Product::nonStaticPriceUpdate);
	}
	
	private static void exampleDeclaredLambdaExpression(List<Product> list, double price) {
		Consumer<Product> predicate = (product -> {
			product.setPrice(product.getPrice() * price);			
		});
		list.forEach(predicate);
	}
	
	private static void exampleInlineLambdaExpression(List<Product> list, double price) {
		list.forEach(product -> product.setPrice(product.getPrice() * price));	
	}
	
	private static void runProgram() {
		Locale.setDefault(Locale.US);
		
		List<Product> list_of_products = generateInstanceProductList();
		
		addProduct(list_of_products);
		
		double price = 1.1;

		displayListOfProducts(list_of_products);
		
		exampleInterfaceImplementation(list_of_products);
		
		exampleReferenceMethodWithStaticMethod(list_of_products);

		exampleReferenceMethodWithNonStaticMethod(list_of_products);
		
		exampleDeclaredLambdaExpression(list_of_products, price);

		exampleInlineLambdaExpression(list_of_products, price);
		
		displayListOfProducts(list_of_products);

		displayMessageEndOfProgram();
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
	}
}
