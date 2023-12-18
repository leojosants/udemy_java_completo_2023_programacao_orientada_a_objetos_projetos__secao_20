/*-------------------- packages section --------------------*/
package application;

/*-------------------- library import section --------------------*/
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

/*-------------------- module import section --------------------*/
import model.entites.Product;
import model.services.ProductServices;

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
		list.add(generateInstanceProduct("Tablet", 350.50));
		list.add(generateInstanceProduct("HD Case", 80.90));
	}
	
	private static void displayListOfProducts(List<Product> list) {
		System.out.println("\n----- Produtos -----");
		list.forEach(product -> {
			product.printProduct();
		});
	}
	
	private static void displaySum(double sum, char search_letter) {
		System.out.printf("-> Soma dos produtos que começam com a letra '%s' ..: R$ %.2f%n", search_letter, sum);
	}

	private static void displayMessageEndOfProgram() {
		System.out.println("\n----- fim do programa -----");
	}
	
	private static void runProgram() {
		Locale.setDefault(Locale.US);

		List<Product> list_of_products = generateInstanceProductList();
		
		addProduct(list_of_products);
		
		char search_letter = 'T';
		
		Predicate<Product> expression = product -> product.getName().charAt(0) == search_letter;
		
		double sum = ProductServices.filteredSum(list_of_products, expression);
				
		displayListOfProducts(list_of_products);
		
		displaySum(sum, search_letter);
		
		displayMessageEndOfProgram();
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
	}
}
