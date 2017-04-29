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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BookGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField bookName;
	private JTextField authorName;
	private JTextField ISBN;
	private JTextField bookCopy;
	private JTextField bookID;
	private Book book;



	/**
	 * Create the dialog.
	 * @param i 
	 */
	public BookGUI(int id) {
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
		
			JLabel lblBookId = new JLabel("Book ID");
			lblBookId.setBounds(119, 43, 61, 16);
			contentPanel.add(lblBookId);
		
			bookID = new JTextField();
			bookID.setEnabled(false);
			bookID.setEditable(false);
			bookID.setBounds(215, 38, 130, 26);
			contentPanel.add(bookID);
			bookID.setColumns(10);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				JButton updateButton = new JButton("Update");
				updateButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EditController controller=new EditController();
					
						ArrayList<String> oldBookData=new ArrayList<String>();
						oldBookData.add(book.getName());
						oldBookData.add(book.getAuthor());
						oldBookData.add(book.getISBN());
						oldBookData.add(book.getCount()+"");
						oldBookData.add(book.getID()+"");
						ArrayList<String> newBookData=new ArrayList<String>();
						
						newBookData.add(bookName.getText());
						newBookData.add(authorName.getText());
						newBookData.add(ISBN.getText());
						newBookData.add(bookCopy.getText());
						newBookData.add(bookID.getText());
						
						controller.updateBookItem(oldBookData,newBookData);
						
						dispose();
						
					}
				});
				
					JButton btnRemove = new JButton("Remove");
					btnRemove.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							EditController controller= new EditController();
							//System.out.println(book + "in Book GUI");
							controller.removeBookItem(book);
							
							

							dispose();
						}
					});
					buttonPane.add(btnRemove);
				
				
				buttonPane.add(updateButton);
			
			
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				

				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg) {
						dispose();
					}
					
					});
				
				GetController getController=new GetController();
				 book=(Book)getController.getBookItem(id);
				
				bookID.setText(book.getID() + "");
				bookName.setText(book.getName());
				ISBN.setText(book.getISBN());
				bookCopy.setText(book.getCount()+"");
				authorName.setText(book.getAuthor());
				
				
				
				
			}
		
	

}
