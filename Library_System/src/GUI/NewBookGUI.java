package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessObjects.Book;
import Controller.EditController;
import Controller.GetController;
import Persistence.DBMgr;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewBookGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField bookName;
	private JTextField authorName;
	private JTextField ISBN;
	private JTextField bookCopy;



	public NewBookGUI() {
		setTitle("Book");
		setBounds(100, 100, 528, 358);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(119, 81, 61, 16);
			contentPanel.add(lblName);
		
			JLabel lblAuthor = new JLabel("Author");
			lblAuthor.setBounds(119, 119, 61, 16);
			contentPanel.add(lblAuthor);
		
			JLabel lblIsbn = new JLabel("ISBN");
			lblIsbn.setBounds(119, 152, 61, 16);
			contentPanel.add(lblIsbn);
		
			JLabel lblNoOfCopies = new JLabel("No. of copies");
			lblNoOfCopies.setBounds(119, 189, 97, 16);
			contentPanel.add(lblNoOfCopies);
		
			bookName = new JTextField();
			bookName.setBounds(215, 76, 130, 26);
			contentPanel.add(bookName);
			bookName.setColumns(10);
		
			authorName = new JTextField();
			authorName.setBounds(215, 114, 130, 26);
			contentPanel.add(authorName);
			authorName.setColumns(10);
		
			ISBN = new JTextField();
			ISBN.setBounds(215, 147, 130, 26);
			contentPanel.add(ISBN);
			ISBN.setColumns(10);
		
			bookCopy = new JTextField();
			bookCopy.setBounds(215, 184, 130, 26);
			contentPanel.add(bookCopy);
			bookCopy.setColumns(10);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(6, 287, 528, 43);
			contentPanel.add(buttonPane);
				buttonPane.setLayout(null);
			
			
				JButton create = new JButton("Create");
				create.setBounds(193, 6, 124, 29);
				create.setActionCommand("OK");
				buttonPane.add(create);
				getRootPane().setDefaultButton(create);
				
				//EditController editController=new EditController();
		
				create.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int id = 0;
						try{
						//	id=Integer.parseInt(textField_1.getText());	
							String book =bookName.getText();
							String author =authorName.getText();
							String ISBNString =ISBN.getText();
							int copy= Integer.parseInt(bookCopy.getText());
							
							EditController editController=new EditController();
							editController.saveBookItem(book, author, ISBNString, copy);
							
							dispose();
						}
						catch(Exception exception)
						{
							exception.printStackTrace();
						}
						
						
						
					}
				});
				
				
			}
		
	

}
