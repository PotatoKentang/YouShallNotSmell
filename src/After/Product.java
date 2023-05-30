package After;

import java.util.ArrayList;

public abstract class Product {
	protected ArrayList<String> products;
	protected ArrayList<Integer> price;
	
	public Product() {
		products = new ArrayList<String>();
		price = new ArrayList<Integer>();
	}
	public abstract void pricing();

	public void clear()
	{
		products.clear();
		price.clear();
	}

	public ArrayList<String> getProduct() {
		return products;
	}
	public void setProduct(ArrayList<String> products) {
		this.products = products;
	}
	public ArrayList<Integer> getPrice() {
		return price;
	}
	public void setPrice(ArrayList<Integer> price) {
		this.price = price;
	}
	
}
