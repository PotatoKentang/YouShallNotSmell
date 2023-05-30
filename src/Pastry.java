import java.util.ArrayList;


public class Pastry 
{
	private ArrayList<String> string;
	private ArrayList<Integer> price = new ArrayList<Integer>();;
	
	Pastry()
	{
		string = new ArrayList<String>();
	}
	//befaore
	public void getSelectedButton(int[] i, String[] k)
	{
		string.add("Pastry");
		for(int x = 0; x < i.length; x++)
        {
        	string.add(k[i[x]]);
        }
	}
	//after belom yakin
//	public void getSelectedButton(int[] indices, String[] options) {
//	    string.add("Pastry");
//	    for (int index : indices) {
//	        if (index >= 0 && index < options.length) {
//	            string.add(options[index]);
//	        }
//	    }
//	}

	
	
	
	//before
	public void pricing()
	{
		for(int x = 0; x < string.size(); x++)
		{
			if(string.get(x).equals("Apricot Danish"))
			{
				price.add(400);
			}
			else if(string.get(x).equals("Prune Danish"))
			{
				price.add(350);
			}
			else if(string.get(x).equals("Crossant"))
			{
				price.add(250);
			}
			else if(string.get(x).equals("English Muffin"))
			{
				price.add(300);
			}
			else if(string.get(x).equals("Blueberry Muffin"))
			{
				price.add(300);
			}
		}
	}
	//after
//	public void pricing() {
//	    Hashtable<String, Integer> itemPrices = new Hashtable<>();
//	    itemPrices.put("Apricot Danish", 400);
//	    itemPrices.put("Prune Danish", 350);
//	    itemPrices.put("Croissant", 250);
//	    itemPrices.put("English Muffin", 300);
//	    itemPrices.put("Blueberry Muffin", 300);
//	    
//	    for (String item : string) {
//	        int itemPrice = itemPrices.getOrDefault(item, 0);
//	        price.add(itemPrice);
//	    }
//	}

	
	
	
	public void clear()
	{
		string.clear();
		price.clear();
	}

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
