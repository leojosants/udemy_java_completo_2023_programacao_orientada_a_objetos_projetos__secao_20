/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import entites.Product;

/*-------------------- class Program --------------------*/
public class Program {
	
	/*-------------------- functions section --------------------*/	
	private static List<Product> generateInstanceProductList() {
		return new ArrayList<>();
	}
	
	private static void addProduct(List<Product> list_of_products) {
		list_of_products.add(generateInstanceProduct("Tv", 900.00));
		list_of_products.add(generateInstanceProduct("Notebook", 1200.00));
		list_of_products.add(generateInstanceProduct("Tablet", 450.00));
	}
	
	private static Product generateInstanceProduct(String name, double price) {
		return new Product(name, price);
	}
	
	private static void displayData(List<Product> list) {
		System.out.println("\n----- Exibindo dados -----");
		for (Product product : list) {
			product.printProduct();
		}
	}

	private static void implementationMode01(List<Product> list_of_products) {
		Comparator<Product> comparator = new Comparator<Product>() {
			@Override
			public int compare(Product product_1, Product product_2) {
				return product_1.getName().toUpperCase().compareTo(product_2.getName().toUpperCase());
			}
		};
		list_of_products.sort(comparator);
	}

	private static void implementationMode02(List<Product> list_of_products) {
		Comparator<Product> comparator = (Product product_1, Product product_2) -> {
			return product_1.getName().toUpperCase().compareTo(product_2.getName().toUpperCase());
		};
		list_of_products.sort(comparator);
	}
	
	private static void implementationMode03(List<Product> list_of_products) {
		Comparator<Product> comparator = (Product product_1, Product product_2) -> product_1.getName().toUpperCase().compareTo(product_2.getName().toUpperCase());
		list_of_products.sort(comparator);
	}
	
	private static void implementationMode04(List<Product> list_of_products) {
		list_of_products.sort((Product product_1, Product product_2) -> product_1.getName().toUpperCase().compareTo(product_2.getName().toUpperCase()));
	}

	private static void runProgram() {
		Locale.setDefault(Locale.US);
		List<Product> list_of_products = generateInstanceProductList();
		addProduct(list_of_products);
		implementationMode01(list_of_products);
//		implementationMode02(list_of_products);
//		implementationMode03(list_of_products);
//		implementationMode04(list_of_products);
		displayData(list_of_products);
	}
	
	private static void displayMessageEndOfProgram() {
		System.out.println("----- fim do programa -----");
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
		displayMessageEndOfProgram();
	}
}
