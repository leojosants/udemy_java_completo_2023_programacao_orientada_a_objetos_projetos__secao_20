/*-------------------- packages section --------------------*/
package util;

/*-------------------- imports section --------------------*/
import java.util.function.Predicate;
import entites.Product;

/*-------------------- class ProductPredicate --------------------*/
public class ProductPredicate implements Predicate<Product> {

	/*-------------------- methods section --------------------*/
	@Override
	public boolean test(Product product) {
		return product.getPrice() >= 100.0;
	}
}
