/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import entites.Product;
import util.ProductPredicate;

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
		list.add(generateInstanceProduct("HD Case", 80.00));
	}
	
	private static void displayListOfProducts(List<Product> list) {
		System.out.println("----- Produtos -----");
		list.forEach(product -> {
			product.printProduct();
		});
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("----- fim do programa -----");
	}

	private static void exampleInterfaceImplementation(List<Product> list_of_products) {
		list_of_products.removeIf(new ProductPredicate());		
	}
	
	private static void exampleReferenceMethodWithStaticMethod(List<Product> list) {
		list.removeIf(Product::staticProductPredicate);
	}
	
	private static void exampleReferenceMethodWithNonStaticMethod(List<Product> list) {
		list.removeIf(Product::nonStaticProductPredicate);
	}
	
	private static void exampleDeclaredLambdaExpression(List<Product> list, double price) {
		Predicate<Product> predicate = (product -> product.getPrice() >= price);
		list.removeIf(predicate);
	}
	
	private static void exampleInlineLambdaExpression(List<Product> list, double price) {
		list.removeIf(product -> product.getPrice() >= price);
	}
	
	private static void runProgram() {
		Locale.setDefault(Locale.US);
		List<Product> list_of_products = generateInstanceProductList();
		addProduct(list_of_products);
		double price = 100.00;
		
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
