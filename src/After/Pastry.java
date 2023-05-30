package After;
import java.util.Hashtable;


public class Pastry extends Product
{

	Pastry()
	{
		super();
	}

//	after belom yakin
	public void getSelectedButton(int[] indices, String[] options) {
	    for (int index : indices) {
	        if (index >= 0 && index < options.length) {
	        	products.add("Pastry");
	        	products.add(options[index]);
	        }
	    }
	}


	//after
	public void pricing() {
	    Hashtable<String, Integer> variants = new Hashtable<String, Integer>();
	    variants.put("Apricot Danish", 400);
	    variants.put("Prune Danish", 350);
	    variants.put("Croissant", 250);
	    variants.put("English Muffin", 300);
	    variants.put("Blueberry Muffin", 300);
	    
	    for(String variantName:variants.keySet())
        {
        	for(String product:products)
        	{
        		if(product.startsWith(variantName))
        		{
        			price.add(variants.get(variantName));
        		}
        	}
        }
	}


}
