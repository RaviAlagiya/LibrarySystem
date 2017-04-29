package Persistence;

import javax.swing.table.DefaultTableModel;

import BusinessObjects.LibraryItem;

public interface DBImplInterface {

	
	
	public LibraryItem getBookItem(int ID);
	
	
	
	public LibraryItem getLaptopItem(int ID);
	
	
	public void saveBookItem(LibraryItem item);
	
	
	public void saveLaptopItem(LibraryItem item);
	
	public void removeLaptopItem(LibraryItem item);
	public void removeBookItem(LibraryItem item);



	public void updateBookItem(LibraryItem oldBook,LibraryItem newBook);



	public void updateLaptopItem(LibraryItem oldLaptop,LibraryItem newLaptop);



	public DefaultTableModel getAllItem(String Type);



	public void undo();



	public void redo();




	
	

}
