/*-------------------- packages section --------------------*/
package exampleFirstOrderOrFirstClassObjects.model.entites;

/*-------------------- class Product --------------------*/
public class Product {
	
	/*-------------------- attributes section --------------------*/
	private String name;
	private Double price;

	/*-------------------- constructors section --------------------*/
	// default
	public Product() {
		//
	}

	// overload
	public Product(String name, Double price) {
		this.setName(name);
		this.setPrice(price);
	}

	/*-------------------- getters and setters section --------------------*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	/*-------------------- methods section --------------------*/
	@Override
	public String toString() {
		return "Produto\n" +
			   String.format(" Nome ...: %s%n", this.getName()) +
			   String.format(" Preço ..: R$ %.2f%n", this.getPrice());
	}
	
	public void printProduct() {
		System.out.println(toString());
	}
}
