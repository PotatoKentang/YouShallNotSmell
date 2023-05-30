package Before;
import java.util.ArrayList;
import javax.swing.ButtonGroup;


public class Coffee 
{
	private ArrayList<String> string;
	private ArrayList<Integer> price;
	
	Coffee()
	{
		string = new ArrayList<String>();
		price = new ArrayList<Integer>();
	}
	//before
	public void getSelectedButton(ButtonGroup group, ButtonGroup group2)
	{
		String product = "";
		product = group.getSelection().getActionCommand()+" "+group2.getSelection().getActionCommand();
		
		string.add("Coffee");
		string.add(product);
	}
	//after
//	public void getSelectedButton(ButtonGroup group, ButtonGroup group2) {
//	    StringBuilder product = new StringBuilder();
//	    
//	    if (group.getSelection() != null) {
//	        product.append(group.getSelection().getActionCommand());
//	    }
//	    
//	    if (group2.getSelection() != null) {
//	        product.append(" ").append(group2.getSelection().getActionCommand());
//	    }
//	    
//	    string.add("Coffee");
//	    string.add(product.toString());
//	}

	
	public void clear()
	{
		string.clear();
		price.clear();
	}
	
	//before
	public void pricing()
	{
		for(int x = 0; x < string.size(); x++)
		{
			if(string.get(x).startsWith("Small"))
			{
				price.add(300);
			}
			else if(string.get(x).startsWith("Medium"))
			{
				price.add(400);
			}
			else if(string.get(x).startsWith("Large"))
			{
				price.add(700);
			}
			else if(string.get(x).equals("Extra Sugar"))
			{
				price.add(20);
			}
			else if(string.get(x).equals("Extra Cream"))
			{
				price.add(20);
			}
		}
	}
	//after
//	public void pricing() {
//	    Map<String, Integer> prices = new HashMap<>();
//	    prices.put("Small", 300);
//	    prices.put("Medium", 400);
//	    prices.put("Large", 700);
//	    prices.put("Extra Sugar", 20);
//	    prices.put("Extra Cream", 20);
//
//	    for (String item : string) {
//	        if (prices.containsKey(item)) {
//	            price.add(prices.get(item));
//	        }
//	    }
//	}

	
	public ArrayList<String> getString() {
		return string;
	}
	public void setString(ArrayList<String> string) {
		this.string = string;
	}
	public ArrayList<Integer> getPrice() {
		return price;
	}
	public void setPrice(ArrayList<Integer> price) {
		this.price = price;
	}
	
	//after
//	public ArrayList<String> getString() {
//	    return new ArrayList<>(string);
//	}
//
//	public void setString(ArrayList<String> string) {
//	    this.string = new ArrayList<>(string);
//	}
//
//	public ArrayList<Integer> getPrice() {
//	    return new ArrayList<>(price);
//	}
//
//	public void setPrice(ArrayList<Integer> price) {
//	    this.price = new ArrayList<>(price);
//	}
}
