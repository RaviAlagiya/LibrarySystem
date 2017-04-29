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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewLaptopGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField company;
	private JTextField ram;
	private JTextField storage;
	private JTextField count;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			LaptopGUI dialog = new LaptopGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 * @param id 
	 */
	public NewLaptopGUI() {
		setTitle("Laptop");
		setBounds(100, 100, 489, 315);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
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
				buttonPane.setLayout(null);
			
			
				JButton okButton = new JButton("Add Laptop");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int id = 0;
						try{
							
							String company1=company.getText();
							System.out.println(company1);
							int ram1=Integer.parseInt(ram.getText());
							int count1=Integer.parseInt(count.getText());
							int storage1=Integer.parseInt(storage.getText());
	
							EditController editController=new EditController();
							editController.saveLaptopItem(company1, ram1, storage1, count1);
							
							dispose();
						}
						catch(Exception exception)
						{
							exception.printStackTrace();
						}
						
						
						
					}
				});
				okButton.setBounds(178, 6, 116, 29);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
				

				GetController getController=new GetController();
//				Laptop laptop=(Laptop)getController.getLaptopItem();
//				
//
//				 company.setText(laptop.getCompany() + "");
//				 ram.setText(laptop.getRAM()+"");
//				storage.setText(laptop.getStorage() + "");
//				laptopID.setText(laptop.getID() + "");
//				 count.setText(laptop.getCount() + "");
//			
				
				
				
	}
}
