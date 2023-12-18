/*-------------------- packages section --------------------*/
package model.services;

/*-------------------- libraries section --------------------*/
import java.util.List;
import java.util.function.Predicate;

/*-------------------- modules section --------------------*/
import model.entites.Product;

/*-------------------- class ProductServices --------------------*/
public class ProductServices {
	
	/*-------------------- methods section --------------------*/
	public static double filteredSum(List<Product> list, Predicate<Product> expression) {
		double sum = 0.0;
		for (Product product : list) {
			if (expression.test(product)) {
				sum += product.getPrice();
			}
		}
		return sum;
	}	
}
