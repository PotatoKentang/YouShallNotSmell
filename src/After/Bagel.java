package After;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


public class Bagel extends Product
{

	Bagel()
	{
		super();
	}

	//after
	public void getSelectedButton(ButtonGroup group, ButtonGroup group2) {
		products.add("Bagel");
	    if (group.getSelection() != null) {
	        String product = group.getSelection().getActionCommand();
	        products.add(product);
	    }

	    if (group2.getSelection() != null) {
	        String product = group2.getSelection().getActionCommand();
	        products.add(product);
	    }
	}
	
	
	//after
	public void pricing() {
	    Hashtable<String, Integer> variants = new Hashtable<String,Integer>();
	    variants.put("White", 300);
	    variants.put("Wheat", 350);
	    variants.put("Salt", 350);
	    variants.put("Sesame", 400);
	    variants.put("Popy", 350);
	    variants.put("Lox Topping", 50);
	    variants.put("Nova Lox Topping", 30);
	    variants.put("Cream Cheese", 20);
	    variants.put("Lowfat Cream Cheese", 40);
	    variants.put("Garlic Cream", 10);
	    variants.put("Butter", 20);
	    variants.put("Jam", 20);
	    
	  
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
