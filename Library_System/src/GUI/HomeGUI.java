package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.EditController;
import Controller.GetController;
import Controller.UndoRedoController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class HomeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable bookTable;
	private JTable laptopTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeGUI frame = new HomeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeGUI() {
		setResizable(false);
		setTitle("Library System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearchBook = new JButton("Search Book");
		btnSearchBook.setToolTipText("Search Book");
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 0;
				try{
					id=Integer.parseInt(textField.getText());	
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
				
				if(id!=0)
				{
					BookGUI bookGUI=new BookGUI(id);
					bookGUI.setVisible(true);
				}
				
				
			}
		});
		btnSearchBook.setBounds(286, 91, 117, 29);
		contentPane.add(btnSearchBook);
		
		JButton btnCreateBook = new JButton("Add Book");
		btnCreateBook.setToolTipText("Add New Book");
		btnCreateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewBookGUI bookGUI=new NewBookGUI();
				bookGUI.setVisible(true);
			
			}
		});
		btnCreateBook.setBounds(530, 96, 168, 37);
		contentPane.add(btnCreateBook);
		
		JButton btnGetLaptop = new JButton("Search Laptop");
		btnGetLaptop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 0;
				try{
					id=Integer.parseInt(textField_1.getText());	
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
				
				if(id!=0)
				{
					LaptopGUI laptopGUI=new LaptopGUI(id);
					laptopGUI.setVisible(true);
				}
				
				
				
			}
		});
		btnGetLaptop.setBounds(286, 299, 117, 29);
		contentPane.add(btnGetLaptop);
		
		JButton btnNewLaptop = new JButton("Add Laptop");
		btnNewLaptop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NewLaptopGUI laptopGUI=new NewLaptopGUI();
				laptopGUI.setVisible(true);
			
			
				
				
			}
		});
		btnNewLaptop.setBounds(530, 295, 168, 37);
		contentPane.add(btnNewLaptop);
		
		JButton btnAllBook = new JButton("Display all Books");
		btnAllBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GetController controller=new GetController();
				//controller.getAllItem("Book");
				
				bookTable.setModel(controller.getAllItem("Book"));
				bookTable.setVisible(true);
				
				
			}
		});
		btnAllBook.setBounds(530, 145, 168, 37);
		contentPane.add(btnAllBook);
		
		JButton btnAllLaptop = new JButton("Display all Laptops");
		btnAllLaptop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GetController controller=new GetController();
				
				laptopTable.setModel(controller.getAllItem("Laptop"));
				laptopTable.setVisible(true);
				
				
			}
		});
		btnAllLaptop.setBackground(new Color(173, 216, 230));
		btnAllLaptop.setBounds(530, 344, 168, 37);
		contentPane.add(btnAllLaptop);
		
		JLabel lblNewLabel = new JLabel("Library System");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setBackground(new Color(0, 0, 128));
		lblNewLabel.setBounds(310, 37, 318, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditController controller=new EditController();
				controller.undo();
				
			}
		});
		btnUndo.setForeground(new Color(255, 69, 0));
		btnUndo.setBackground(new Color(250, 128, 114));
		btnUndo.setBounds(530, 441, 168, 37);
		contentPane.add(btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditController controller=new EditController();
				controller.redo();
				
			}
		});
		btnRedo.setForeground(new Color(0, 128, 0));
		btnRedo.setBounds(530, 490, 168, 37);
		contentPane.add(btnRedo);
		
		JLabel lblLaptop = new JLabel("Laptop ID :");
		lblLaptop.setBounds(40, 304, 76, 16);
		contentPane.add(lblLaptop);
		
		JLabel lblBooks = new JLabel("Book ID:");
		lblBooks.setBounds(40, 96, 61, 16);
		contentPane.add(lblBooks);
		
		textField = new JTextField();
		textField.setBounds(129, 91, 145, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 299, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 124, 443, 154);
		contentPane.add(scrollPane);
		
		bookTable = new JTable();
		scrollPane.setViewportView(bookTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 357, 443, 183);
		contentPane.add(scrollPane_1);
		
		laptopTable = new JTable();
		scrollPane_1.setViewportView(laptopTable);
	}
}
