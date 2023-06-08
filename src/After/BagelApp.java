package After;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class BagelApp extends JFrame{

	/* 
	 *	  Declarations
	 */
	CoffeePanel coffeePanel;
	BagelPanel bagelPanel;
	PastryPanel pastryPanel;
	
	private int width = 800;
	private int height = 600;
	private JPanel parent;
	private JPanel productCategoryPanel;
	private JLabel title;
	private JPanel buttons;
	
	private JRadioButton product1;	
	private JRadioButton product2;
	private JRadioButton product3;
	private ButtonGroup productgroup;

	private ToolbarParentPanel toolbarParentPanel;
	private OrderPanel orderPanel;
	private BorderLayout layout;
	private Order order;
	private Coffee coffee;
	private Bagel bagel;
	private Pastry pastry;
	
	private BagelApp() {
		initializeClasses();
	    initializeFrame();
		buildPanel();
	    addComponentsToFrame();
	    setVisible(true);
	}

	private void initializeFrame() {
	    setTitle("Bagel Order Application");
	    setSize(width, height);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout(10, 10));
	    setBackground(Color.LIGHT_GRAY);
	}


	private void addComponentsToFrame() {
	    add(toolbarParentPanel, BorderLayout.CENTER);
	    add(title, BorderLayout.NORTH);
	    add(buttons, BorderLayout.SOUTH);
	    add(parent, BorderLayout.WEST);
	}

	private void initializeClasses() {
	    order = new Order();
	    coffee = new Coffee();
	    bagel = new Bagel();
	    pastry = new Pastry();
	}

	
	//after
	private void createParentPanel() {
	    parent = new JPanel();
	    parent.setLayout(new BorderLayout(10, 10));

	    title = new JLabel("Order Entry Screen");
	    title.setHorizontalAlignment(SwingConstants.CENTER);
	    coffeePanel = new CoffeePanel(parent);
	    bagelPanel = new BagelPanel(parent);
	    pastryPanel = new PastryPanel(parent);
	    toolbarParentPanel = new ToolbarParentPanel();
	    orderPanel = new OrderPanel();
	}
	
	private void createProductCategoryPanel() {
	 	productCategoryPanel = new JPanel();
	    productCategoryPanel.setBorder(BorderFactory.createTitledBorder("Products"));
	    productCategoryPanel.setLayout(new GridLayout(3, 1));

	    product1 = new JRadioButton("Coffee");
	    product2 = new JRadioButton("Bagel");
	    product3 = new JRadioButton("Pastry");
	    productgroup = new ButtonGroup();

	    productgroup.add(product1);
	    productgroup.add(product2);
	    productgroup.add(product3);

	    product1.addActionListener(new ButtonListener());
	    product2.addActionListener(new ButtonListener());
	    product3.addActionListener(new ButtonListener());

	    productCategoryPanel.add(product1);
	    productCategoryPanel.add(product2);
	    productCategoryPanel.add(product3);
	}

	private void defaultPanelSelection() {
		order.clear();
		product1.doClick();
		coffeePanel.small.doClick();
		coffeePanel.regular.doClick();
		bagelPanel.white.doClick();
		bagelPanel.bagelSpreadsRadioGroup.clearSelection();
		toolbarParentPanel.text.setText("");
	}
	private void buildPanel() {
		createParentPanel();
	    createProductCategoryPanel();
	    panelSetup();
	    defaultPanelSelection();
	}
	
	private void panelSetup() {
		parent.add(productCategoryPanel, BorderLayout.WEST);
	    parent.add(toolbarParentPanel, BorderLayout.EAST);
	    parent.add(buttons, BorderLayout.SOUTH);
	    layout = (BorderLayout) parent.getLayout();
	    product1.doClick();
	    toolbarParentPanel.membern.doClick();
	}

	private class ToolbarParentPanel extends JPanel {
	     JPanel toolbarGroup;
	     JPanel orderDisplay;
	     JLabel quantitylabel;
	     JTextField quantity;
	     JRadioButton membery;
	     JRadioButton membern;
	     ButtonGroup membergroup;
	 	 JTextArea text;
	 	 JScrollPane scroll;
	     JButton delete;
	     int q = 1;
	     boolean isMember;

	    public ToolbarParentPanel() {
	        createAndSetupPanel();
	    }

	    private void createAndSetupPanel() {
	        setLayout(new BorderLayout());

	        toolbarGroup = new JPanel();
	        orderDisplay = new JPanel();
	        orderDisplay.setLayout(new BorderLayout());

	        quantitylabel = new JLabel("Quantity: ");
	        quantity = new JTextField(5);
	        membery = new JRadioButton("Member");
	        membern = new JRadioButton("Not Member");
	        membergroup = new ButtonGroup();
	        delete = new JButton("Delete Previous");

	        membery.setActionCommand("Member");
	        membern.setActionCommand("Not Member");

	        delete.addActionListener(new ButtonListener());
	        quantity.addActionListener(new ButtonListener());
	        membern.addActionListener(new ButtonListener());
	        membery.addActionListener(new ButtonListener());

	        membergroup.add(membery);
	        membergroup.add(membern);

	        text = new JTextArea();
	        scroll = new JScrollPane(text);
	        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        text.setLineWrap(true);
	        text.setWrapStyleWord(true);
	        text.setEditable(false);

	        toolbarGroup.add(quantitylabel);
	        toolbarGroup.add(quantity);
	        toolbarGroup.add(membery);
	        toolbarGroup.add(membern);
	        toolbarGroup.add(delete);
	        orderDisplay.add(scroll, BorderLayout.CENTER);

	        add(toolbarGroup, BorderLayout.SOUTH);
	        add(orderDisplay, BorderLayout.CENTER);
	        
	    }
	    
		public JTextArea getText() {
			return toolbarParentPanel.text;
		}

		public void setText(JTextArea text) {

			toolbarParentPanel.text = text;
		}
		public boolean isMember() {

			return isMember;
		}

		public void setMember(boolean isMember) {
			this.isMember = isMember;
		}
	}

	private class OrderPanel extends JPanel {
	    private JButton buttonEnterItem;
	    private JButton buttonTotalItem;
	    private JButton buttonNewOrderItem;

	    public OrderPanel() {
	        createAndSetupPanel();
	    }
	    
	    float formatDecimalToDollar(int value)
		{
			return (float) value / 100;
		}
	    
		private void printOrder(ArrayList<String> list, ArrayList<Integer> list2) {
			toolbarParentPanel.text.setText("");	  
		    int index = 0;
		    for(int i=0;i<list.size();i++) {
		        if (isProduct(list.get(i))) {
		        	toolbarParentPanel.text.append(list.get(i) + "\n");
		        } else {
		            String formattedPrice = String.format("%107s%.2f\n", "$", formatDecimalToDollar(list2.get(index)));
		            toolbarParentPanel.text.append("           " + list.get(i) + "\n" + formattedPrice);
		            index++;
		        }
		    }
		}

		private boolean isProduct(String item) {
		    return item.equals("Coffee") || item.equals("Bagel") || item.equals("Pastry");
		}
	    private void createAndSetupPanel() {
	        buttons = new JPanel();
	        buttons.setBackground(Color.black);

	        buttonEnterItem = new JButton("Enter Item");
	        buttonTotalItem = new JButton("Total");
	        buttonNewOrderItem = new JButton("New Order");

	        buttonEnterItem.addActionListener(new ButtonListener());
	        buttonTotalItem.addActionListener(new ButtonListener());
	        buttonNewOrderItem.addActionListener(new ButtonListener());

	        buttons.add(buttonEnterItem);
	        buttons.add(buttonTotalItem);
	        buttons.add(buttonNewOrderItem);

	        add(buttons);
	    }
	}

	private class CoffeePanel extends JPanel {
	    private JPanel parent;
	    public JPanel productCoffeeDetailPanel;
	    private JPanel coffeeSizePanel;
	    private JPanel coffeeTypePanel;
	    private JPanel coffeeExtrasPanel;
	    private JRadioButton small;
	    private JRadioButton medium;
	    private JRadioButton large;
	    private ButtonGroup coffeeSizeRadioGroup;
	    private JRadioButton decafe;
	    private JRadioButton regular;
	    private JRadioButton roast;
	    private ButtonGroup coffeeTypeRadioGroup;
	    private JCheckBox cream;
	    private JCheckBox sugar;

	    public CoffeePanel(JPanel parent) {
	        this.parent = parent;
	        createAndSetupPanel();
	    }

	    private void createAndSetupPanel() {
	        productCoffeeDetailPanel = new JPanel();
	        productCoffeeDetailPanel.setLayout(new GridLayout(3, 1));
	        productCoffeeDetailPanel.setPreferredSize(new Dimension(180, 650));
	        coffeeSizePanel = new JPanel();
	        coffeeTypePanel = new JPanel();
	        coffeeExtrasPanel = new JPanel();

	        coffeeSizePanel.setLayout(new GridLayout(3, 1));
	        coffeeTypePanel.setLayout(new GridLayout(3, 1));
	        coffeeExtrasPanel.setLayout(new GridLayout(2, 1));

	        coffeeSizePanel.setBorder(BorderFactory.createTitledBorder("Size"));

	        small = new JRadioButton("Small");
	        medium = new JRadioButton("Medium");
	        large = new JRadioButton("Large");
	        coffeeSizeRadioGroup = new ButtonGroup();

	        small.setActionCommand("Small");
	        medium.setActionCommand("Medium");
	        large.setActionCommand("Large");

	        small.addActionListener(new ButtonListener());
	        medium.addActionListener(new ButtonListener());
	        large.addActionListener(new ButtonListener());

	        coffeeSizeRadioGroup.add(small);
	        coffeeSizeRadioGroup.add(medium);
	        coffeeSizeRadioGroup.add(large);

	        coffeeSizePanel.add(small);
	        coffeeSizePanel.add(medium);
	        coffeeSizePanel.add(large);

	        coffeeTypePanel.setBorder(BorderFactory.createTitledBorder("Type"));

	        regular = new JRadioButton("Regular");
	        decafe = new JRadioButton("Decaf");
	        roast = new JRadioButton("French Roast");
	        coffeeTypeRadioGroup = new ButtonGroup();

	        regular.setActionCommand("Regular");
	        decafe.setActionCommand("Decaf");
	        roast.setActionCommand("French Roast");

	        regular.addActionListener(new ButtonListener());
	        decafe.addActionListener(new ButtonListener());
	        roast.addActionListener(new ButtonListener());

	        coffeeTypeRadioGroup.add(regular);
	        coffeeTypeRadioGroup.add(decafe);
	        coffeeTypeRadioGroup.add(roast);

	        coffeeTypePanel.add(regular);
	        coffeeTypePanel.add(decafe);
	        coffeeTypePanel.add(roast);

	        coffeeExtrasPanel.setBorder(BorderFactory.createTitledBorder("Extras"));

	        cream = new JCheckBox("Cream");
	        sugar = new JCheckBox("Sugar");

	        cream.addActionListener(new ButtonListener());
	        sugar.addActionListener(new ButtonListener());

	        coffeeExtrasPanel.add(cream);
	        coffeeExtrasPanel.add(sugar);

	        productCoffeeDetailPanel.add(coffeeSizePanel);
	        productCoffeeDetailPanel.add(coffeeTypePanel);
	        productCoffeeDetailPanel.add(coffeeExtrasPanel);

	        parent.add(productCoffeeDetailPanel, BorderLayout.CENTER);
	    }
	}

//	private class 
	private class BagelPanel extends JPanel{
		 JPanel parent;
		 JPanel productBagelDetailPanel;
		 JPanel bagelTypePanel;
		 JPanel bagelSpreadsPanel;
		 JPanel bagelToppingsPanel;
		 JRadioButton white;
		 JRadioButton wheat;
		 JRadioButton salt;
		 JRadioButton sesame;
		 JRadioButton popy;
		 ButtonGroup bagelTypeRadioGroup;
		 JRadioButton cc;
		 JRadioButton lcc;
		 JRadioButton gc;
		 JRadioButton butter;
		 JRadioButton jam;
		 ButtonGroup bagelSpreadsRadioGroup;

		
		 JCheckBox lox;
		 JCheckBox novalox;
		
		BagelPanel(JPanel parent){
			this.parent = parent;
			createAndSetupPanel();
		}
		
		void createAndSetupPanel() {
	        productBagelDetailPanel = new JPanel();
	        productBagelDetailPanel.setLayout(new GridLayout(3, 1));
	        productBagelDetailPanel.setPreferredSize(new Dimension(180, 650));
	        bagelTypePanel = new JPanel();
	        bagelSpreadsPanel = new JPanel();
	        bagelToppingsPanel = new JPanel();

	        bagelTypePanel.setLayout(new GridLayout(5, 1));
	        bagelSpreadsPanel.setLayout(new GridLayout(5, 1));
	        bagelToppingsPanel.setLayout(new GridLayout(2, 1));

	        bagelTypePanel.setBorder(BorderFactory.createTitledBorder("Bagel"));

	        white = new JRadioButton("White");
	        wheat = new JRadioButton("Wheat");
	        salt = new JRadioButton("Salt");
	        sesame = new JRadioButton("Sesame");
	        popy = new JRadioButton("Popy");
	        bagelTypeRadioGroup = new ButtonGroup();

	        white.setActionCommand("White");
	        wheat.setActionCommand("Wheat");
	        salt.setActionCommand("Salt");
	        sesame.setActionCommand("Sesame");
	        popy.setActionCommand("Popy");

	        white.addActionListener(new ButtonListener());
	        wheat.addActionListener(new ButtonListener());
	        salt.addActionListener(new ButtonListener());
	        sesame.addActionListener(new ButtonListener());
	        popy.addActionListener(new ButtonListener());

	        bagelTypeRadioGroup.add(white);
	        bagelTypeRadioGroup.add(wheat);
	        bagelTypeRadioGroup.add(salt);
	        bagelTypeRadioGroup.add(sesame);
	        bagelTypeRadioGroup.add(popy);

	        bagelTypePanel.add(white);
	        bagelTypePanel.add(wheat);
	        bagelTypePanel.add(salt);
	        bagelTypePanel.add(sesame);
	        bagelTypePanel.add(popy);

	        bagelSpreadsPanel.setBorder(BorderFactory.createTitledBorder("Spreads"));

	        cc = new JRadioButton("Cream Cheese");
	        lcc = new JRadioButton("Lowfat Cream Cheese");
	        gc = new JRadioButton("Garlic Cream");
	        butter = new JRadioButton("Butter");
	        jam = new JRadioButton("Jam");
	        bagelSpreadsRadioGroup = new ButtonGroup();

	        cc.setActionCommand("Cream Cheese");
	        lcc.setActionCommand("Lowfat Cream Cheese");
	        gc.setActionCommand("Garlic Cream");
	        butter.setActionCommand("Butter");
	        jam.setActionCommand("Jam");

	        cc.addActionListener(new ButtonListener());
	        lcc.addActionListener(new ButtonListener());
	        gc.addActionListener(new ButtonListener());
	        butter.addActionListener(new ButtonListener());
	        jam.addActionListener(new ButtonListener());

	        bagelSpreadsRadioGroup.add(cc);
	        bagelSpreadsRadioGroup.add(lcc);
	        bagelSpreadsRadioGroup.add(gc);
	        bagelSpreadsRadioGroup.add(butter);
	        bagelSpreadsRadioGroup.add(jam);

	        bagelSpreadsPanel.add(cc);
	        bagelSpreadsPanel.add(lcc);
	        bagelSpreadsPanel.add(gc);
	        bagelSpreadsPanel.add(butter);
	        bagelSpreadsPanel.add(jam);

	        bagelToppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));

	        lox = new JCheckBox("Lox");
	        novalox = new JCheckBox("Nova Lox");

	        lox.addActionListener(new ButtonListener());
	        novalox.addActionListener(new ButtonListener());

	        bagelToppingsPanel.add(lox);
	        bagelToppingsPanel.add(novalox);

	        productBagelDetailPanel.add(bagelTypePanel);
	        productBagelDetailPanel.add(bagelSpreadsPanel);
	        productBagelDetailPanel.add(bagelToppingsPanel);
	        
	        parent.add(productBagelDetailPanel, BorderLayout.CENTER);
	    }
		
		
		
	}

	private class PastryPanel extends JPanel{
		JPanel parent;
		JPanel productPastryDetailPanel;
		JPanel pastryPastriesPanel;
		private String[] pastrylist = {"Apricot Danish", "Prune Danish", "Croissant", "English Muffin", "Blueberry Muffin"};
		private JList list;
		private int[] indices = {};

		
		PastryPanel(JPanel parent){
			this.parent = parent;
			createAndSetupPanel();
		}
		
		void createAndSetupPanel() {
			productPastryDetailPanel = new JPanel();
			productPastryDetailPanel.setLayout(new GridLayout(2,1));
			productPastryDetailPanel.setPreferredSize(new Dimension(180, 650));
		    productPastryDetailPanel = new JPanel();
		    productPastryDetailPanel.setLayout(new GridLayout(1, 1));
		    productPastryDetailPanel.setBorder(BorderFactory.createTitledBorder("Pastries"));

		    list = new JList(pastrylist);
		    list.addListSelectionListener(new ListListener());

		    productPastryDetailPanel.add(list);
	    }
		
	}
	//before
	private class ButtonListener implements ActionListener
	{
		public void renderProductCategoryDetail() {
			if(product1.isSelected())
			{					
				renderCategoryDetailPanel(coffeePanel.productCoffeeDetailPanel);
			}
			
			else if(product2.isSelected())
			{				
				renderCategoryDetailPanel(bagelPanel.productBagelDetailPanel);
			}
			
			else if(product3.isSelected())
			{				
				renderCategoryDetailPanel(pastryPanel.productPastryDetailPanel);
			}
		}
		public void setItemQuantity()
		{
			if(!toolbarParentPanel.quantity.getText().isEmpty())
			{
				try
				{
					toolbarParentPanel.q = Integer.parseInt(toolbarParentPanel.quantity.getText());
				}
				catch(NumberFormatException e)
				{
					toolbarParentPanel.q = 1;
				}
			}
			else
			{
				toolbarParentPanel.q = 1;
			}
		}
		public void coffeeOrder ()
		{
			if(product1.isSelected())
			{
				coffee.getSelectedButton(coffeePanel.coffeeSizeRadioGroup, coffeePanel.coffeeTypeRadioGroup);
				if(coffeePanel.sugar.isSelected())
				{
					coffee.getProduct().add("Extra Sugar");
					coffeePanel.sugar.doClick();
				}
				if(coffeePanel.cream.isSelected())
				{
					coffee.getProduct().add("Extra Cream");
					coffeePanel.cream.doClick();
				}
				coffee.pricing();
				for(int x = 0; x < toolbarParentPanel.q; x++)
				{
					order.getOrder(coffee.getPrice(), coffee.getProduct());
				}
				toolbarParentPanel.q = 1;
				coffee.clear();
				coffeePanel.small.doClick();
				coffeePanel.regular.doClick();
			}
		}
		public void bagelOrder()
		{
			if(product2.isSelected())
			{
				bagel.getSelectedButton(bagelPanel.bagelTypeRadioGroup, bagelPanel.bagelSpreadsRadioGroup);
				if(bagelPanel.lox.isSelected())
				{
					bagel.getProduct().add("Lox Topping");
					bagelPanel.lox.doClick();
				}
				if(bagelPanel.novalox.isSelected())
				{
					bagel.getProduct().add("Nova Lox Topping");
					bagelPanel.novalox.doClick();
				}
				bagel.pricing();
				for(int x = 0; x < toolbarParentPanel.q; x++)
				{
					order.getOrder(bagel.getPrice(), bagel.getProduct());
					
				}
				toolbarParentPanel.q = 1;
				bagel.clear();
				bagelPanel.white.doClick();
				bagelPanel.bagelSpreadsRadioGroup.clearSelection();
			}
		}
		void pastryOrder()
		{
			if(product3.isSelected())
			{
				pastry.getSelectedButton(pastryPanel.indices, pastryPanel.pastrylist);
				pastry.pricing();
				for(int x = 0; x < toolbarParentPanel.q; x++)
				{
					order.getOrder(pastry.getPrice(), pastry.getProduct());
				}
				toolbarParentPanel.q = 1;
				pastry.clear();
			}
		}
		public void printTotalOrder()
		{
			toolbarParentPanel.text.append(String.format("%n%100s%2s%.2f", "Subtotal: ","$", (float)order.calculateSubtotal()/100));
			toolbarParentPanel.text.append(String.format("%n%102s%2s%.2f", "Total: ","$", (float)order.calculateTotal(toolbarParentPanel.isMember)/100));
		}
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			renderProductCategoryDetail();
			if(arg0.getActionCommand() == "Enter Item")
			{
				setItemQuantity();
				coffeeOrder();
				bagelOrder();
				pastryOrder();
				orderPanel.printOrder(order.getOrder(), order.getOrderprice());
				toolbarParentPanel.quantity.setText("");
			}
			
			else if(arg0.getActionCommand() == "New Order")
			{
				defaultPanelSelection();
			}
			
			else if(arg0.getActionCommand() == "Total")
			{
				printTotalOrder();
			}
			
			if(arg0.getActionCommand() == "Delete Previous")
			{
				order.deletePreviousOrder();
				orderPanel.printOrder(order.getOrder(), order.getOrderprice());	
			}
			toolbarParentPanel.isMember = toolbarParentPanel.membery.isSelected();
		}

		private void renderCategoryDetailPanel(JPanel panel) {
			parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
			parent.add(panel, BorderLayout.CENTER);
			parent.revalidate();
			parent.repaint();
		}
	}

	
	private class ListListener implements ListSelectionListener

	{
		public void valueChanged(ListSelectionEvent arg0) 
		{
			JList source;
			if (!arg0.getValueIsAdjusting())
			{
	            source = (JList)arg0.getSource();
	            pastryPanel.indices = source.getSelectedIndices();
	        }
		}
	}
	

	public static void main(String[] args)
	{
		BagelApp app = new BagelApp();
	}
	


}