/*-------------------- packages section --------------------*/
package exampleFirstOrderOrFirstClassObjects.application;

/*-------------------- imports section --------------------*/
import java.util.ArrayList;
import java.util.List;
import exampleFirstOrderOrFirstClassObjects.model.entites.Product;

/*-------------------- class Program --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	private static List<Product> generateInstanceProductList() {
		return new ArrayList<>();
	}
	
	private static Product generateInstanceProduc(String name, double price) {
		return new Product(name, price);
	}

	private static void addProduct(List<Product> list) {
		list.add(generateInstanceProduc("TV", 900.00));
		list.add(generateInstanceProduc("Notebook", 1200.00));
		list.add(generateInstanceProduc("Tablet", 450.00));
	}

	private static int compareProducts(Product product_1, Product product_2) {
		return product_1.getPrice().compareTo(product_2.getPrice());
	}
	
	private static void displayMessageEndOfProgram() {
		System.out.println("\n----- fim do programa -----");
	}

	private static void runProgram() {
		List<Product> list_of_product = generateInstanceProductList();
		addProduct(list_of_product);
		list_of_product.sort(Program::compareProducts);
		list_of_product.forEach(System.out::println);
		displayMessageEndOfProgram();
	}

	/*-------------------- main method --------------------*/
	public static void main(String[] args) {
		runProgram();
	}
}
