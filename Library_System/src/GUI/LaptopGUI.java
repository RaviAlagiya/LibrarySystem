package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessObjects.Book;
import BusinessObjects.Laptop;
import Controller.EditController;
import Controller.GetController;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LaptopGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField company;
	private JTextField ram;
	private JTextField storage;
	private JTextField laptopID;
	private JTextField count;
	private Laptop laptop;

	/**
	 * Create the dialog.
	 * @param id 
	 */
	public LaptopGUI(int id) {
		setTitle("Laptop");
		setBounds(100, 100, 489, 315);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLaptopId = new JLabel("Laptop ID");
		lblLaptopId.setBounds(117, 34, 61, 16);
		contentPanel.add(lblLaptopId);
		
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setBounds(113, 72, 76, 16);
		contentPanel.add(lblCompany);
		
		JLabel lblRam = new JLabel("RAM (GB)");
		lblRam.setBounds(117, 115, 61, 16);
		contentPanel.add(lblRam);
		
		JLabel lblStoragegb = new JLabel("Storage (GB)");
		lblStoragegb.setBounds(102, 158, 76, 16);
		contentPanel.add(lblStoragegb);
		
		company = new JTextField();
		company.setBounds(214, 67, 130, 26);
		contentPanel.add(company);
		company.setColumns(10);
		
		ram = new JTextField();
		ram.setBounds(214, 110, 130, 26);
		contentPanel.add(ram);
		ram.setColumns(10);
		
		storage = new JTextField();
		storage.setBounds(214, 153, 130, 26);
		contentPanel.add(storage);
		storage.setColumns(10);
		
		laptopID = new JTextField();
		laptopID.setEnabled(false);
		laptopID.setEditable(false);
		laptopID.setBounds(214, 29, 130, 26);
		contentPanel.add(laptopID);
		laptopID.setColumns(10);
		
		count = new JTextField();
		count.setBounds(214, 191, 130, 26);
		contentPanel.add(count);
		count.setColumns(10);
		
		JLabel lblCount = new JLabel("Count");
		lblCount.setBounds(117, 196, 61, 16);
		contentPanel.add(lblCount);
		
					JPanel buttonPane = new JPanel();
					buttonPane.setBounds(0, 242, 489, 33);
					contentPanel.add(buttonPane);
					
				JButton btnUpdate = new JButton("Update");
				btnUpdate.setBounds(215, 5, 88, 29);
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EditController controller=new EditController();
					
						ArrayList<String> oldLaptopData=new ArrayList<String>();
						oldLaptopData.add(laptop.getCompany());
						oldLaptopData.add(laptop.getRAM()+"");
						oldLaptopData.add(laptop.getStorage()+"");
						oldLaptopData.add(laptop.getCount()+"");
						oldLaptopData.add(laptop.getID()+"");
						
						ArrayList<String> newLaptopData=new ArrayList<String>();
						newLaptopData.add(company.getText());
						newLaptopData.add(ram.getText()+"");
						newLaptopData.add(storage.getText()+"");
						newLaptopData.add(count.getText()+"");
						newLaptopData.add(laptopID.getText()+"");
						
						controller.updateLaptopItem(oldLaptopData,newLaptopData);
						
						dispose();
						
					}
				});
				buttonPane.setLayout(null);
				
				JButton btnRemove = new JButton("Remove");
				btnRemove.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EditController controller= new EditController();
						
						
						controller.removeLaptopItem(laptop);
						
						dispose();
						
					}
				});
				btnRemove.setBounds(110, 5, 93, 29);
				buttonPane.add(btnRemove);
				
				buttonPane.add(btnUpdate);
			
			
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setBounds(315, 5, 75, 29);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
				

				GetController getController=new GetController();
				 laptop=(Laptop)getController.getLaptopItem(id);
				

				 company.setText(laptop.getCompany() + "");
				 ram.setText(laptop.getRAM()+"");
				storage.setText(laptop.getStorage() + "");
				laptopID.setText(laptop.getID() + "");
				 count.setText(laptop.getCount() + "");
			
				
				
				
	}
}
