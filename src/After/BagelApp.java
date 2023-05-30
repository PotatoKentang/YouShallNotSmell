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
	
	private int width = 800;
	private int height = 600;
	private JPanel parent;
	private JPanel productCategoryPanel;
	private JPanel productCoffeeDetailPanel;
	private JPanel productBagelDetailPanel;
	private JPanel productPastryDetailPanel;
	private JPanel toolbarParentPanel;
	private JLabel title;
	private JPanel buttons;
	
	private JRadioButton product1;	
	private JRadioButton product2;
	private JRadioButton product3;
	private ButtonGroup productgroup;
	
	private JPanel coffeeSizePanel;
	private JPanel coffeeTypePanel;
	private JPanel coffeeExtrasPanel;
	private JPanel bagelTypePanel;
	private JPanel bagelSpreadsPanel;
	private JPanel bagelToppingsPanel;
	private JPanel pastryPastriesPanel;
	private JPanel toolbarGroup;
	private JPanel orderDisplay;
	
	private JTextArea text;

	private JScrollPane scroll;
	
	//	PANEL 2A
	
	private JButton buttonEnterItem;
	private JButton buttonTotalItem;
	private JButton buttonNewOrderItem;
	
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
	
	// PANEL 2B
	
	private JRadioButton white;
	private JRadioButton wheat;
	private JRadioButton salt;
	private JRadioButton sesame;
	private JRadioButton popy;
	private ButtonGroup bagelTypeRadioGroup;
	
	private JRadioButton cc;
	private JRadioButton lcc;
	private JRadioButton gc;
	private JRadioButton butter;
	private JRadioButton jam;
	private ButtonGroup bagelSpreadsRadioGroup;
	
	private JCheckBox lox;
	private JCheckBox novalox;
	
	// PANEL 2C
	
	private String[] pastrylist = {"Apricot Danish", "Prune Danish", "Croissant", "English Muffin", "Blueberry Muffin"};
	private JList list;
	private int[] indices = {};
	
	// OTHERS
	
	private JLabel quantitylabel;
	private JTextField quantity;
	private JRadioButton membery;
	private JRadioButton membern;
	private ButtonGroup membergroup;
	private JButton delete;
	private int q = 1;
	
	private BorderLayout layout;
	
	private boolean isMember;

	private Order order;
	private Coffee coffee;
	private Bagel bagel;
	private Pastry pastry;
	
	//before
//	private BagelApp()
//	{
//		setTitle("Bagel Order Application");
//		setSize(width, height);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new BorderLayout(10,10));
//		setBackground(Color.LIGHT_GRAY);
//		
//		buildPanel();
//		add(toolbarParentPanel, BorderLayout.CENTER);
//		add(title, BorderLayout.NORTH);
//		add(buttons, BorderLayout.SOUTH);
//		add(parent, BorderLayout.WEST);
//		
//		setVisible(true);
//		
//		// CALL CLASSES
//		order = new Order();
//		coffee = new Coffee();
//		bagel = new Bagel();
//		pastry = new Pastry();
//	}
	
	//after
	private BagelApp() {
	    initializeFrame();
		buildPanel();
	    addComponentsToFrame();
	    setVisible(true);
	    initializeClasses();
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

	
	//before
//	private void buildPanel()
//	{
//		/* A very big build method because
//		 * all the panels are pre-made
//		 */
//		
//		// PARENT PANEL
//		
//		parent = new JPanel();
//		parent.setLayout(new BorderLayout(10,10));
//		
//		title = new JLabel("Order Entry Screen");
//		title.setHorizontalAlignment(SwingConstants.CENTER);
//		
//		productCategoryPanel = new JPanel();
//		productCategoryPanel.setBorder(BorderFactory.createTitledBorder("Products"));
//		productCategoryPanel.setLayout(new GridLayout(3,1));
//		
//		
//		productCoffeeDetailPanel = new JPanel();
//		productBagelDetailPanel = new JPanel();
//		productPastryDetailPanel = new JPanel();
//		toolbarParentPanel = new JPanel();
//		
//		// PANEL1
//		
//		
//		product1 = new JRadioButton("Coffee");
//		product2 = new JRadioButton("Bagel");
//		product3 = new JRadioButton("Pastry");
//		productgroup = new ButtonGroup();
//		
//		productgroup.add(product1);
//		productgroup.add(product2);
//		productgroup.add(product3);
//		
//		product1.addActionListener(new ButtonListener());
//		product2.addActionListener(new ButtonListener());
//		product3.addActionListener(new ButtonListener());
//		
//		productCategoryPanel.add(product1);
//		productCategoryPanel.add(product2);
//		productCategoryPanel.add(product3);
//		
//		productCoffeeDetailPanel.setLayout(new GridLayout(3,1));
//		productCoffeeDetailPanel.setPreferredSize(new Dimension(180, 650));
//		productBagelDetailPanel.setLayout(new GridLayout(3,1));
//		productBagelDetailPanel.setPreferredSize(new Dimension(180, 650));
//		productPastryDetailPanel.setLayout(new GridLayout(2,1));
//		productPastryDetailPanel.setPreferredSize(new Dimension(180, 650));
//		
//		coffeeSizePanel = new JPanel();
//		coffeeTypePanel = new JPanel();
//		coffeeExtrasPanel = new JPanel();
//		
//		// PANEL3
//		
//		toolbarParentPanel.setLayout(new BorderLayout());
//		
//		toolbarGroup = new JPanel();
//		orderDisplay = new JPanel();
//		orderDisplay.setLayout(new BorderLayout());
//		
//		quantitylabel = new JLabel("Quantity: ");
//		quantity = new JTextField(5);
//		membery = new JRadioButton("Member");
//		membern = new JRadioButton("Not Member");
//		membergroup = new ButtonGroup();
//		delete = new JButton("Delete Previous");
//		
//		membery.setActionCommand("Member");
//		membern.setActionCommand("Not Member");
//		
//		delete.addActionListener(new ButtonListener());
//		quantity.addActionListener(new ButtonListener());
//		membern.addActionListener(new ButtonListener());
//		membery.addActionListener(new ButtonListener());
//		
//		membergroup.add(membery);
//		membergroup.add(membern);
//		
//		text = new JTextArea();
//		scroll = new JScrollPane(text);
//		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        text.setLineWrap(true);
//        text.setWrapStyleWord(true);
//        text.setEditable(false);
//        
//        toolbarGroup.add(quantitylabel);
//        toolbarGroup.add(quantity);
//        toolbarGroup.add(membery);
//        toolbarGroup.add(membern);
//        toolbarGroup.add(delete);
//        orderDisplay.add(scroll, BorderLayout.CENTER);
//        
//        toolbarParentPanel.add(toolbarGroup, BorderLayout.SOUTH);
//		toolbarParentPanel.add(orderDisplay, BorderLayout.CENTER);
//		
//		// BUTTON PANEL
//		
//		buttons = new JPanel();
//		buttonEnterItem = new JButton("Enter Item");
//		buttonTotalItem = new JButton("Total");
//		buttonNewOrderItem = new JButton("New Order");
//		buttons.setBackground(Color.black);
//		
//		buttonEnterItem.addActionListener(new ButtonListener());
//		buttonTotalItem.addActionListener(new ButtonListener());
//		buttonNewOrderItem.addActionListener(new ButtonListener());
//		
//		buttons.add(buttonEnterItem);
//		buttons.add(buttonTotalItem);
//		buttons.add(buttonNewOrderItem);
//		
//		//productCoffeeDetailPanel
//		
//		coffeeSizePanel.setLayout(new GridLayout(3,1));
//		coffeeTypePanel.setLayout(new GridLayout(3,1));
//		coffeeExtrasPanel.setLayout(new GridLayout(2,1));
//		
//		coffeeSizePanel.setBorder(BorderFactory.createTitledBorder("Size"));
//		
//		small = new JRadioButton("Small");
//		medium = new JRadioButton("Medium");
//		large = new JRadioButton("Large");
//		coffeeSizeRadioGroup = new ButtonGroup();
//		
//		small.setActionCommand("Small");
//		medium.setActionCommand("Medium");
//		large.setActionCommand("Large");
//		
//		small.addActionListener(new ButtonListener());
//		medium.addActionListener(new ButtonListener());
//		large.addActionListener(new ButtonListener());
//		
//		coffeeSizeRadioGroup.add(small);
//		coffeeSizeRadioGroup.add(medium);
//		coffeeSizeRadioGroup.add(large);
//		
//		coffeeSizePanel.add(small);
//		coffeeSizePanel.add(medium);
//		coffeeSizePanel.add(large);
//		
//		coffeeTypePanel.setBorder(BorderFactory.createTitledBorder("Type"));
//		
//		regular = new JRadioButton("Regular");
//		decafe = new JRadioButton("DeCafe");
//		roast = new JRadioButton("French Roast");
//		coffeeTypeRadioGroup = new ButtonGroup();
//		
//		regular.setActionCommand("Regular");
//		decafe.setActionCommand("DeCafe");
//		roast.setActionCommand("French Roast");
//		
//		regular.addActionListener(new ButtonListener());
//		decafe.addActionListener(new ButtonListener());
//		roast.addActionListener(new ButtonListener());
//		
//		coffeeTypeRadioGroup.add(regular);
//		coffeeTypeRadioGroup.add(decafe);
//		coffeeTypeRadioGroup.add(roast);
//		
//		coffeeTypePanel.add(regular);
//		coffeeTypePanel.add(decafe);
//		coffeeTypePanel.add(roast);
//		
//		coffeeExtrasPanel.setBorder(BorderFactory.createTitledBorder("Extras"));
//		
//		cream = new JCheckBox("Cream");
//		sugar = new JCheckBox("Sugar");
//		
//		cream.addActionListener(new ButtonListener());
//		sugar.addActionListener(new ButtonListener());
//		
//		coffeeExtrasPanel.add(cream);
//		coffeeExtrasPanel.add(sugar);
//		
//		productCoffeeDetailPanel.add(coffeeSizePanel);
//		productCoffeeDetailPanel.add(coffeeTypePanel);
//		productCoffeeDetailPanel.add(coffeeExtrasPanel);
//		
//		//productBagelDetailPanel
//		
//		bagelTypePanel = new JPanel();
//		bagelSpreadsPanel = new JPanel();
//		bagelToppingsPanel = new JPanel();
//		
//		bagelTypePanel.setLayout(new GridLayout(5,1));
//		bagelSpreadsPanel.setLayout(new GridLayout(5,1));
//		bagelToppingsPanel.setLayout(new GridLayout(2,1));
//		
//		bagelTypePanel.setBorder(BorderFactory.createTitledBorder("Bagel"));
//		
//		white = new JRadioButton("White");
//		wheat = new JRadioButton("Wheat");
//		salt = new JRadioButton("Salt");
//		sesame = new JRadioButton("sesame");
//		popy = new JRadioButton("Popy");
//		bagelTypeRadioGroup = new ButtonGroup();
//		
//		white.setActionCommand("White");
//		wheat.setActionCommand("Wheat");
//		salt.setActionCommand("Salt");
//		sesame.setActionCommand("sesame");
//		popy.setActionCommand("Popy");
//		
//		white.addActionListener(new ButtonListener());
//		wheat.addActionListener(new ButtonListener());
//		salt.addActionListener(new ButtonListener());
//		sesame.addActionListener(new ButtonListener());
//		popy.addActionListener(new ButtonListener());
//		
//		bagelTypeRadioGroup.add(white);
//		bagelTypeRadioGroup.add(wheat);
//		bagelTypeRadioGroup.add(salt);
//		bagelTypeRadioGroup.add(sesame);
//		bagelTypeRadioGroup.add(popy);
//		
//		bagelTypePanel.add(white);
//		bagelTypePanel.add(wheat);
//		bagelTypePanel.add(salt);
//		bagelTypePanel.add(sesame);
//		bagelTypePanel.add(popy);
//		
//		bagelSpreadsPanel.setBorder(BorderFactory.createTitledBorder("Spreads"));
//		
//		cc = new JRadioButton("Cream Cheese");
//		lcc = new JRadioButton("Lowfat Cream Cheese");
//		gc = new JRadioButton("Garlic Cream");
//		butter = new JRadioButton("Butter");
//		jam = new JRadioButton("Jam");
//		bagelSpreadsRadioGroup = new ButtonGroup();
//		
//		cc.setActionCommand("Cream Cheese");
//		lcc.setActionCommand("Lowfat Cream Cheese");
//		gc.setActionCommand("Garlic Cream");
//		butter.setActionCommand("Butter");
//		jam.setActionCommand("Jam ");
//		
//		cc.addActionListener(new ButtonListener());
//		lcc.addActionListener(new ButtonListener());
//		gc.addActionListener(new ButtonListener());
//		butter.addActionListener(new ButtonListener());
//		jam.addActionListener(new ButtonListener());
//		
//		bagelSpreadsRadioGroup.add(cc);
//		bagelSpreadsRadioGroup.add(lcc);
//		bagelSpreadsRadioGroup.add(gc);
//		bagelSpreadsRadioGroup.add(butter);
//		bagelSpreadsRadioGroup.add(jam);
//		
//		bagelSpreadsPanel.add(cc);
//		bagelSpreadsPanel.add(lcc);
//		bagelSpreadsPanel.add(gc);
//		bagelSpreadsPanel.add(butter);
//		bagelSpreadsPanel.add(jam);
//		
//		bagelToppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));
//		
//		lox = new JCheckBox("Lox");
//		novalox = new JCheckBox("Nova Lox");
//		
//		lox.addActionListener(new ButtonListener());
//		novalox.addActionListener(new ButtonListener());
//		
//		bagelToppingsPanel.add(lox);
//		bagelToppingsPanel.add(novalox);
//		
//		productBagelDetailPanel.add(bagelTypePanel);
//		productBagelDetailPanel.add(bagelSpreadsPanel);
//		productBagelDetailPanel.add(bagelToppingsPanel);
//		
//		//productPastryDetailPanel
//		
//		pastryPastriesPanel = new JPanel();
//		
//		pastryPastriesPanel.setLayout(new GridLayout());
//		pastryPastriesPanel.setBorder(BorderFactory.createTitledBorder("Pastries"));
//		
//		list = new JList(pastrylist);
//		
//		list.addListSelectionListener(new ListListener());
//		
//		pastryPastriesPanel.add(list);
//		productPastryDetailPanel.add(pastryPastriesPanel);
//		
//		parent.add(productCategoryPanel, BorderLayout.WEST);
//		parent.add(productCoffeeDetailPanel, BorderLayout.CENTER);
//		layout = (BorderLayout)parent.getLayout();
//		
//		product1.doClick();
//		membern.doClick();
//	}
	
	//after
	private void createParentPanel() {
	    parent = new JPanel();
	    parent.setLayout(new BorderLayout(10, 10));

	    title = new JLabel("Order Entry Screen");
	    title.setHorizontalAlignment(SwingConstants.CENTER);
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
	
	private void createProductCoffeeDetailPanel() {
		productCoffeeDetailPanel = new JPanel();
		productCoffeeDetailPanel.setLayout(new GridLayout(3,1));
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
	}
	
	
	
	private void createProductBagelDetailPanel() {
		productBagelDetailPanel = new JPanel();
		productBagelDetailPanel.setLayout(new GridLayout(3,1));
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
	}
	
	private void createProductPastryDetailPanel() {
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
	
	private void createToolbarParentPanel() {
	    toolbarParentPanel = new JPanel();
	    toolbarParentPanel.setLayout(new BorderLayout());

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

	    toolbarParentPanel.add(toolbarGroup, BorderLayout.SOUTH);
	    toolbarParentPanel.add(orderDisplay, BorderLayout.CENTER);
	}
	private void createButtonsPanel() {
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
	}
	private void buildPanel() {
		createParentPanel();
	    createProductCategoryPanel();
	    createProductCoffeeDetailPanel();
	    createProductBagelDetailPanel();
	    createProductPastryDetailPanel();
	    createToolbarParentPanel();
	    createButtonsPanel();
	    parent.add(productCategoryPanel, BorderLayout.WEST);
	    parent.add(productCoffeeDetailPanel, BorderLayout.CENTER);
	    parent.add(toolbarParentPanel, BorderLayout.EAST);
	    parent.add(buttons, BorderLayout.SOUTH);
	    layout = (BorderLayout) parent.getLayout();
	    product1.doClick();
	    membern.doClick();
	}

	
	
	
	
	//before
	private class ButtonListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if(product1.isSelected())
			{					
				renderCategoryDetailPanel(productCoffeeDetailPanel);
				
				if(coffeeSizeRadioGroup.getSelection() == null)
				{
					small.doClick();
				}
				if(coffeeTypeRadioGroup.getSelection() == null)
				{
					regular.doClick();
				}
			}
			else if(product2.isSelected())
			{				
				renderCategoryDetailPanel(productBagelDetailPanel);
				if(bagelTypeRadioGroup.getSelection() == null)
				{
					white.doClick();
				}
			}
			else if(product3.isSelected())
			{				
				renderCategoryDetailPanel(productPastryDetailPanel);
			}
			if(arg0.getActionCommand() == "Enter Item")
			{
				if(!quantity.getText().isEmpty())
				{
					try
					{
						q = Integer.parseInt(quantity.getText());
					}
					catch(NumberFormatException e)
					{
						q = 1;
					}
				}
				else
				{
					q = 1;
				}
				
				if(product1.isSelected())
				{
					coffee.getSelectedButton(coffeeSizeRadioGroup, coffeeTypeRadioGroup);
					if(sugar.isSelected())
					{
						coffee.getProduct().add("Extra Sugar");
						sugar.doClick();
					}
					if(cream.isSelected())
					{
						coffee.getProduct().add("Extra Cream");
						cream.doClick();
					}
					coffee.pricing();
					for(int x = 0; x < q; x++)
					{
						order.getOrder(coffee.getPrice(), coffee.getProduct());
					}
					q = 1;
					coffee.clear();
					small.doClick();
					regular.doClick();
				}
				else if(product2.isSelected())
				{
					bagel.getSelectedButton(bagelTypeRadioGroup, bagelSpreadsRadioGroup);
					if(lox.isSelected())
					{
						bagel.getProduct().add("Lox Topping");
						lox.doClick();
					}
					if(novalox.isSelected())
					{
						bagel.getProduct().add("Nova Lox Topping");
						novalox.doClick();
					}
					bagel.pricing();
					for(int x = 0; x < q; x++)
					{
						order.getOrder(bagel.getPrice(), bagel.getProduct());
						
					}
					q = 1;
					bagel.clear();
					white.doClick();
					bagelSpreadsRadioGroup.clearSelection();
				}
				else if(product3.isSelected())
				{
					pastry.getSelectedButton(indices, pastrylist);
					pastry.pricing();
					for(int x = 0; x < q; x++)
					{
						order.getOrder(pastry.getPrice(), pastry.getProduct());
					}
					q = 1;
					pastry.clear();
				}
				
				printOrder(order.getOrder(), order.getOrderprice());
				quantity.setText("");
				
			}
			else if(arg0.getActionCommand() == "New Order")
			{
				order.clear();
				product1.doClick();
				small.doClick();
				regular.doClick();
				white.doClick();
				bagelSpreadsRadioGroup.clearSelection();
				text.setText("");
			}
			else if(arg0.getActionCommand() == "Total")
			{
				text.append(String.format("%n%100s%2s%.2f", "Subtotal: ","$", (float)order.calculateSubtotal()/100));
				text.append(String.format("%n%102s%2s%.2f", "Total: ","$", (float)order.calculateTotal(isMember)/100));
			}
			if(arg0.getActionCommand() == "Delete Previous")
			{
				int i = order.getOrder().size()-1;
				int k = order.getOrderprice().size()-1;
				boolean yes = false;
				int y = i;
				int x = k;
				
				while(!yes && !(i == -1 && k == -1))
				{
					if(order.getOrder().get(y).equals("Coffee")||order.getOrder().get(y).equals("Bagel")||order.getOrder().get(y).equals("Pastry"))
					{
						order.getOrder().remove(y);
						yes = true;
					}
					else
					{
						order.getOrder().remove(y);
						order.getOrderprice().remove(x);
						y--;
						x--;
					}
				}
				printOrder(order.getOrder(), order.getOrderprice());
				
			}
			if(membern.isSelected())
			{
				isMember = false;
			}
			else if(membery.isSelected())
			{
				isMember = true;
			}
		}

		private void renderCategoryDetailPanel(JPanel panel) {
			parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
			parent.add(panel, BorderLayout.CENTER);
			parent.revalidate();
			parent.repaint();
		}
	}
	//after


	
	
	private class ListListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent arg0) 
		{
			JList source;
			if (!arg0.getValueIsAdjusting())
			{
	            source = (JList)arg0.getSource();
	            indices = source.getSelectedIndices();
	        }
		}
	}
	
	//before
//	private void printOrder(ArrayList<String> list, ArrayList<Integer> list2)
//	{
//		int y = 0;
//		text.setText("");
//		for(int x = 0; x < list.size(); x++)
//		{
//			if(list.get(x).equals("Coffee")||list.get(x).equals("Bagel")||list.get(x).equals("Pastry"))
//			{
//				text.append(list.get(x)+"\n");
//			}
//			else
//			{
//				text.append("           "+list.get(x)+"\n");
//				text.append(String.format("%107s%.2f\n","$", (float)list2.get(y)/100));
//				y++;
//			}
//		}
//	}
	
	
	float formatDecimalToDollar(int value)
	{
		return (float) value / 100;
	}
	//after
	private void printOrder(ArrayList<String> list, ArrayList<Integer> list2) {
	    text.setText("");	  
	    int index = 0;
	    for(int i=0;i<list.size();i++) {
	        if (isProduct(list.get(i))) {
	            text.append(list.get(i) + "\n");
	        } else {
	            String formattedPrice = String.format("%107s%.2f\n", "$", formatDecimalToDollar(list2.get(index)));
	            text.append("           " + list.get(i) + "\n" + formattedPrice);
	            index++;
	        }
	    }
	}

	private boolean isProduct(String item) {
	    return item.equals("Coffee") || item.equals("Bagel") || item.equals("Pastry");
	}

	
	
	public static void main(String[] args)
	{
		BagelApp app = new BagelApp();
	}
	
	//Getters and Setters
	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}
	
	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
}