package After;
import java.util.ArrayList;

public class Order 
{
	//note sebelumnya ada variable total yang global sekarang jdi lokal karena cmn dipake di 1 method
	private final double memberdiscount = 0.9;
	private final double tax = 0.08;
	private int subtotal;
	private ArrayList<Integer> orderprice = new ArrayList<Integer>();
	private ArrayList<String> order = new ArrayList<String>();
	
	Order()
	{
		subtotal = 0;
	}
	

//	after
	public void getOrder(ArrayList<Integer> priceList, ArrayList<String> itemList) {
	    order.addAll(itemList);
	    orderprice.addAll(priceList);
	}
	
	//after
	public int calculateSubtotal() {
	    subtotal = 0;
	    
	    for (int price : orderprice) {
	        subtotal += price;
	    }
	    
	    return subtotal;
	}
	
	public void clear()
	{
		subtotal = 0;
		orderprice.clear();
		order.clear();
	}
	
	public ArrayList<Integer> getOrderprice() {
		return orderprice;
	}
	
	public ArrayList<String> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<Integer> orderToBeAdded) {
		this.orderprice = orderToBeAdded;
	}
	
//	after
	public int calculateTotal(boolean isMember) {
	    int total = subtotal + (int) (subtotal * tax);
	    
	    if (isMember) {
	        total = (int) (total * this.memberdiscount);
	    }
	    
	    return total;
	}

}
