package Persistence;

import javax.swing.table.DefaultTableModel;

import BusinessObjects.Book;
import BusinessObjects.Laptop;
import BusinessObjects.LibraryItem;

public class DBMgr {
	// if in Future the database changes then only below implementation object will change
	DBImplInterface imp=new MySQLImpl();
	
	
	public LibraryItem getBookItem(int ID)
	{
		return imp.getBookItem(ID);
		
	}
	
	public LibraryItem getLaptopItem(int ID)
	{
		return imp.getLaptopItem(ID);
		
	}
	
	public void saveBookItem(LibraryItem item)
	{
		imp.saveBookItem(item);
		
	}
	
	public void saveLaptopItem(LibraryItem item)
	{
		imp.saveLaptopItem(item);
		
	}
	
	public void removeLaptopItem(LibraryItem item)
	{
		imp.removeLaptopItem( item);
	}
	
	public void removeBookItem(LibraryItem item)
	{
		System.out.println(item+"in DBmgr");
		imp.removeBookItem( item);
	}

	public void updateBookItem(LibraryItem oldBook,LibraryItem newBook) {
		imp.updateBookItem(oldBook,newBook);
		
	}

	public void updateLaptopItem(LibraryItem oldLaptop,LibraryItem newLaptop) {
		imp.updateLaptopItem(oldLaptop,newLaptop);
		
	}

	public DefaultTableModel getAllItem(String type) {
		
		return imp.getAllItem(type);
	}

	public void undo() {
		imp.undo();
		
	}	
	public void redo() {
		imp.redo();
		
	}
	
	
	
	

}
