package Before;
import java.util.ArrayList;

import javax.swing.ButtonGroup;


public class Bagel 
{
	private ArrayList<String> string;
	private ArrayList<Integer> price;
	
	Bagel()
	{
		string = new ArrayList<String>();
		price = new ArrayList<Integer>();
	}
	//before
	public void getSelectedButton(ButtonGroup group, ButtonGroup group2)
	{
		string.add("Bagel");
		String product = group.getSelection().getActionCommand();
		string.add(product);
		if(group2.getSelection() != null)
		{
			product = group2.getSelection().getActionCommand();
			string.add(product);
		}
	}
	
	//after
//	public void getSelectedButton(ButtonGroup group, ButtonGroup group2) {
//	    string.add("Bagel");
//
//	    if (group.getSelection() != null) {
//	        String product = group.getSelection().getActionCommand();
//	        string.add(product);
//	    }
//
//	    if (group2.getSelection() != null) {
//	        String product = group2.getSelection().getActionCommand();
//	        string.add(product);
//	    }
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
			if(string.get(x).startsWith("White"))
			{
				price.add(300);
			}
			else if(string.get(x).equals("Wheat"))
			{
				price.add(350);
			}
			else if(string.get(x).equals("Salt"))
			{
				price.add(350);
			}
			else if(string.get(x).equals("Seseme"))
			{
				price.add(400);
			}
			else if(string.get(x).equals("Popy"))
			{
				price.add(350);
			}
			else if(string.get(x).endsWith(" "))
			{
				price.add(50);
			}
			else if(string.get(x).equals("Lox Topping")||string.get(x).equals("Nova Lox Topping"))
			{
				price.add(100);
			}
		}
	}
	//after
//	public void pricing() {
//	    Map<String, Integer> prices = new HashMap<>();
//	    prices.put("White", 300);
//	    prices.put("Wheat", 350);
//	    prices.put("Salt", 350);
//	    prices.put("Seseme", 400);
//	    prices.put("Popy", 350);
//	    prices.put(" ", 50);
//	    prices.put("Lox Topping", 100);
//	    prices.put("Nova Lox Topping", 100);
//
//	    for (String item : string) {
//	        if (prices.containsKey(item)) {
//	            price.add(prices.get(item));
//	        }
//	    }
//	}

	
	//before 
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
}
