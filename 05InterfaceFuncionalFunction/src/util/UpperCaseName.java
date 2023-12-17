/*-------------------- packages section --------------------*/
package util;

/*-------------------- imports section --------------------*/
import java.util.function.Function;
import entites.Product;

/*-------------------- class ProductPredicate --------------------*/
public class UpperCaseName implements Function<Product, String> {

	/*-------------------- methods section --------------------*/
	@Override
	public String apply(Product product) {
		return product.getName().toUpperCase();
	}	
}
