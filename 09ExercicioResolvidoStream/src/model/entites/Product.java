/*-------------------- packages --------------------*/
package model.entites;

/*-------------------- class Product --------------------*/
public class Product {
	
	/*-------------------- attributes --------------------*/
	private String name;
	private Double price;

	/*-------------------- constructors --------------------*/
	// default
	public Product() {
		//
	}

	// overload
	public Product(String name, Double price) {
		this.setName(name);
		this.setPrice(price);
	}

	/*-------------------- getters and setters --------------------*/
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

	/*-------------------- methods --------------------*/
	@Override
	public String toString() {
		return "\nProduto\n" +
			   String.format(" Nome ...: %s%n", this.getName()) +
			   String.format(" Preço ..: R$ %.2f%n", this.getPrice());
	}
	
	public void printProduct() {
		System.out.println(toString());
	}
}

