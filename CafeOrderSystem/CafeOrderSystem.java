/*------------------------------------------------------
My name: Subhranil Choudhury
My student number: 6848138
My course code: CSIT121
My email address: sc177@uowmail.edu.au
Assignment number: Final Project
-------------------------------------------------------*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.Serializable;
import java.util.*;
import java.io.*;
class InvalidStringException extends Exception {

	InvalidStringException(String str){
		super(str);
		super.printStackTrace();
	}
}

class CafeOrderSystem extends JPanel {
	OrderMenu menu =  new OrderMenu();
	CustomerOrder order= new CustomerOrder();
	HashMap<String,Component> components = new HashMap<String,Component>();
	JPanel panel = this;
	JFrame frame = new JFrame();
	ErrorCheck check =null;
	CafeOrderSystem(){
		check=new ErrorCheck(frame);
		loadComponents();
		loadData();
		GridBagConstraints gbc = new GridBagConstraints();
		frame.setLayout(new GridBagLayout());
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets.set(0,200,0,0);
		gbc.weighty=20;
		frame.add(components.get("labelCustomerName"),gbc);
		gbc.gridx=1;
		gbc.ipadx=100;
		gbc.insets.set(0, 50, 0, 0);
		frame.add(components.get("textFieldCustomerName"),gbc);
		gbc.gridx=2;
		gbc.ipadx=0;
		gbc.insets.set(0,300,0,0);
		frame.add(components.get("labelTableID"),gbc);
		gbc.insets.set(0, 50, 0, 0);
		gbc.gridx=3;
		gbc.ipadx=100;
		frame.add(components.get("textFieldTableID"),gbc);
		gbc=new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		panel.setLayout(new GridBagLayout());
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets.set(0,0,50,20);
		panel.add(components.get("labelCategory"),gbc);
		gbc.gridx=1;
		panel.add(components.get("labelItem"),gbc);
		gbc.gridx=2;
		panel.add(components.get("labelDescription"),gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		panel.add(components.get("listCategory"),gbc);
		gbc.gridx=1;
		panel.add(components.get("listItem"),gbc);
		gbc.gridx=2;
		panel.add(components.get("textAreaDescription"),gbc);
		gbc.gridx=3;
		panel.add(components.get("labelQuantity"),gbc);
		gbc.gridx=4;
		gbc.ipadx=50;
		gbc.ipady=0;
		panel.add(components.get("textFieldQuantity"),gbc);
		gbc.gridx=5;
		gbc.ipadx=0;
		panel.add(components.get("buttonAdd"),gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		panel.add(components.get("labelOrder"),gbc);
		gbc.insets.set(0, 200, 0, 0);
		gbc.gridy=3;
		panel.add(components.get("textAreaOrder"),gbc);
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=5;
		gbc.fill=GridBagConstraints.BOTH;
		frame.add(panel,gbc);
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.gridwidth=1;
		frame.add(components.get("buttonSubmit"),gbc);
		gbc.gridx=3;
		frame.add(components.get("buttonReset"),gbc);
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
	}

public void paintComponent(Graphics g) {
	super.paintComponent(g);
	ImageIcon img= new ImageIcon("cafe.jpg");
	Image scale = img.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);
	img.setImage(scale);
	img.paintIcon(this, g, 0, 0);
}


void loadComponents() {
	components.put("labelCustomerName", new JLabel("Customer Name:"));
	components.put("labelTableID", new JLabel("Table ID:"));
	components.put("labelCategory", new JLabel("Category:"));
	components.put("labelItem", new JLabel("Item:"));
	components.put("labelDescription", new JLabel("Description:"));
	components.put("labelOrder", new JLabel("Order:"));
	components.put("labelQuantity", new JLabel("Quantity:"));
	components.put("listCategory", new JList<String>());
	components.put("listItem", new JList<String>());
	components.put("textFieldCustomerName", new JTextField());
	components.put("textFieldTableID", new JTextField());
	components.put("textFieldQuantity", new JTextField());
	components.put("textAreaDescription", new JTextArea());
	components.put("textAreaOrder", new JTextArea());
	components.put("buttonAdd", new JButton("Add"));
	components.put("buttonSubmit", new JButton("Submit"));
	components.put("buttonReset", new JButton("Reset"));
	JTextArea textArea = (JTextArea)components.get("textAreaDescription");
	textArea.setSize(200,10);
	textArea.setLineWrap(true);
	textArea.setWrapStyleWord(true);
	textArea = (JTextArea)components.get("textAreaOrder");
	textArea.setSize(200,10);
	((JButton)components.get("buttonSubmit")).addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
			String name = ((JTextField)components.get("textFieldCustomerName")).getText();
			String ID = ((JTextField)components.get("textFieldTableID")).getText();
			check=new ErrorCheck(frame);
			check.checkCustomerName(name);
			check.checkTableID(ID);
			if(check.checkErrorFree()) {
				order.setCustomerName(name);
				order.setTableID(Integer.parseInt(ID));
				FileOutputStream file = new FileOutputStream(name+"_"+ID+".txt");
				PrintWriter pw = new PrintWriter(file);
				pw.write(order.toString());
				pw.close();
				file.close();
				JOptionPane.showMessageDialog(frame,"The order has been generated.");
			}
			}
			catch(FileNotFoundException err) {}
			catch(IOException err) {}

		}
	});
	((JButton)components.get("buttonReset")).addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new CafeOrderSystem();
			JOptionPane.showMessageDialog(frame,"The system is reset.");
	}
});
}

void loadData() {
	try {
		FileInputStream file = new FileInputStream("Menu.ser");
		ObjectInputStream in = new ObjectInputStream(file);
		menu = (OrderMenu) in.readObject();
		in.close();
		file.close();
	}
	catch(FileNotFoundException err) {
		err.printStackTrace();
	}
	catch(IOException err) {
		err.printStackTrace();
	}
	catch(ClassNotFoundException err) {
		err.printStackTrace();
	}
	JList list = (JList)components.get("listCategory");
	String[] str = new String[menu.getCategories().size()];
	for(int i =0;i<str.length;i++) 
		str[i]=menu.getCategories().get(i).getCategoryName();
	list.setListData(str);
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	list.addListSelectionListener(categorySelect());
	list.setSelectedIndex(0);
	list = (JList)components.get("listItem");
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	list.addListSelectionListener(itemSelect());
	list.setSelectedIndex(0);
	((JButton)components.get("buttonAdd")).addActionListener(addDish());
}

ListSelectionListener categorySelect() {
	return new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			JList list = (JList)components.get("listCategory");
			DishCategory selection =null;
			for(DishCategory i: menu.getCategories())
				if(i.getCategoryName().equals(list.getSelectedValue())) {
					selection = i;
					break;
				}
			Dish[] dishes= new Dish[selection.getDishes().size()];
			for(int i =0;i<dishes.length;i++)
				dishes[i]=selection.getDishes().get(i);
			((JList)components.get("listItem")).setListData(dishes);
			((JList)components.get("listItem")).addListSelectionListener(itemSelect());
			((JList)components.get("listItem")).setSelectedIndex(0);
		}
	};
}

ListSelectionListener itemSelect() {
	return new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			Dish selection =(Dish) ((JList)components.get("listItem")).getSelectedValue();
			JTextArea textArea = (JTextArea)components.get("textAreaDescription");
			textArea.setText(selection.getDescription());
	}};
}

ActionListener addDish() {
	return new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Dish selection = (Dish) ((JList)components.get("listItem")).getSelectedValue();
		String quantity = ((JTextField)components.get("textFieldQuantity")).getText();
			check=new ErrorCheck(frame);
		check.checkQuantity(quantity);
		if(check.checkErrorFree()) {
		OrderDish dish = new OrderDish();
		dish.setDish(selection);
		dish.setQuantity(Integer.parseInt(quantity));
		order.addDish(dish);
		((JTextArea)components.get("textAreaOrder")).setText(order.getDishes());
	}
	}
	};
}


public static void main(String[] args) {
	CafeOrderSystem gui = new CafeOrderSystem();
}
}

class ErrorCheck {
	Component component=null;
	boolean errorFree;
	ErrorCheck(Component component){
		this.component = component;
		errorFree=true;
	}
	void checkCustomerName(String name) {
		try
		{if(name.equals("")){
					errorFree=false;
			throw new InvalidStringException("Customer Name cannot be blank.");
		}
		}
		catch(InvalidStringException e) {
			displayDialog(e.getClass().getName(),e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void checkTableID(String ID) {
		try
		{if(ID.equals("")) {
			errorFree=false;
			throw new InvalidStringException("Table ID cannot be blank.");
		}
		boolean flag =false;
		 for(int i =0;i<ID.length();i++) 
			 if(!Character.isDigit(ID.charAt(i))) {
				 flag=true;
				 break;		
			 }
		 if(flag) {
			 errorFree = false;
			 throw new InvalidStringException("Table ID must be a Integer.");
		}
		}
		catch(InvalidStringException e) {
			displayDialog(e.getClass().getName(),e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void checkQuantity(String quantity) {
		try {
			if(quantity.equals("")) {
				errorFree=false;	
				throw new InvalidStringException("Quantity cannot be blank.");
		}
			boolean flag = false;
				for(int i =0;i<quantity.length();i++) {
					if(!Character.isDigit(quantity.charAt(i))) {
						flag=true;
						break;
					}
				}
			if(flag) {
				errorFree = false;
				throw new InvalidStringException("Quantity must be an integer.");
			}
			if(quantity.length()==1&&quantity.charAt(0)=='0') {
				errorFree = false;
				System.out.println("set");
				throw new InvalidStringException("Quantity must be greater than 0");
				}
			}
		catch(InvalidStringException e) {
			displayDialog(e.getClass().getName(),e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void displayDialog(String title, String message, int type) {
		JOptionPane.showMessageDialog(component, message, title, type);
	}
	boolean checkErrorFree() {
		return errorFree;
	}
}






