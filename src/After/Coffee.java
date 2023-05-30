package After;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.ButtonGroup;


public class Coffee extends Product
{

	
	Coffee()
	{
		super();
		products.add("Coffee");
	}

	//after
	public void getSelectedButton(ButtonGroup group, ButtonGroup group2) {
	    StringBuilder product = new StringBuilder();
	    
	    if (group.getSelection() != null) {
	        product.append(group.getSelection().getActionCommand());
	    }
	    
	    if (group2.getSelection() != null) {
	        product.append(" ").append(group2.getSelection().getActionCommand());
	    }
	    
	    products.add(product.toString());
	}

	
	//after
	public void pricing() {
		Hashtable<String, Integer> variants = new Hashtable<String, Integer>();
		variants.put("Small", 300);
		variants.put("Medium", 400);
		variants.put("Large", 700);
		variants.put("Extra Sugar", 20);
		variants.put("Extra Cream", 20);


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
