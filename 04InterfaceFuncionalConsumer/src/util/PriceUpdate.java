/*-------------------- packages section --------------------*/
package util;

/*-------------------- imports section --------------------*/
import java.util.function.Consumer;
import entites.Product;

/*-------------------- class ProductPredicate --------------------*/
public class PriceUpdate implements Consumer<Product> {

	/*-------------------- methods section --------------------*/
	@Override
	public void accept(Product product) {
		product.setPrice(product.getPrice() * 1.1);
	}
}
