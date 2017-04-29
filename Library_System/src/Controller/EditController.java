package Controller;

import java.util.ArrayList;

import BusinessObjects.Book;
import BusinessObjects.Laptop;
import BusinessObjects.LibraryItem;
import Persistence.DBMgr;

public class EditController {
	
	public void saveBookItem(String book,String author,String ISBNString,int copy)
	{
		DBMgr dbMgr=new DBMgr();
		
		Book b=new Book();
		b.setAuthor(author);
		b.setCount(copy);
		b.setISBN(ISBNString);
		b.setName(book);
		
		dbMgr.saveBookItem(b);
		
		
		
	}

	public void saveLaptopItem(String company1, int ram1, int storage1, int count1) {

		DBMgr dbMgr=new DBMgr();
		
		Laptop l=new Laptop();
	
		l.setCompany(company1);
		l.setCount(count1);
		l.setRAM(ram1);
		l.setStorage(storage1);
		
		dbMgr.saveLaptopItem(l);
		
		
	}
	

	public void updateBookItem(ArrayList<String> oldBookData,ArrayList<String> newBookData)
	{
		String book=oldBookData.get(0);
		String author=oldBookData.get(1);
		String ISBNString=oldBookData.get(2);
		int copy=Integer.parseInt(oldBookData.get(3));
		int id=Integer.parseInt(oldBookData.get(4));
		
		
		String nbook=newBookData.get(0);
		String nauthor=newBookData.get(1);
		String nISBNString=newBookData.get(2);
		int ncopy=Integer.parseInt(newBookData.get(3));
		int nid=Integer.parseInt(newBookData.get(4));
		
		
		DBMgr dbMgr=new DBMgr();
		
		Book oldBook=new Book();
		Book newBook=new Book();
		oldBook.setID(id);
		oldBook.setAuthor(author);
		oldBook.setCount(copy);
		oldBook.setISBN(ISBNString);
		oldBook.setName(book);

		newBook.setID(nid);
		newBook.setAuthor(nauthor);
		newBook.setCount(ncopy);
		newBook.setISBN(nISBNString);
		newBook.setName(nbook);
		
		
		dbMgr.updateBookItem(oldBook,newBook);
		
		
		
	}

	public void updateLaptopItem(ArrayList<String> oldLaptopData,ArrayList<String> newLaptopData) {

		String company1=oldLaptopData.get(0); 
		int ram1=Integer.parseInt(oldLaptopData.get(1));
		int storage1=Integer.parseInt(oldLaptopData.get(2)); 
		int count1=Integer.parseInt(oldLaptopData.get(3));
		int id1=Integer.parseInt(oldLaptopData.get(4));
		
		String company2=newLaptopData.get(0); 
		int ram2=Integer.parseInt(newLaptopData.get(1));
		int storage2=Integer.parseInt(newLaptopData.get(2)); 
		int count2=Integer.parseInt(newLaptopData.get(3));
		int id2=Integer.parseInt(newLaptopData.get(4));
		
		
				
		DBMgr dbMgr=new DBMgr();
		
		Laptop oldLaptop=new Laptop();
		Laptop newLaptop=new Laptop();

		oldLaptop.setID(id1);
		oldLaptop.setCompany(company1);
		oldLaptop.setCount(count1);
		oldLaptop.setRAM(ram1);
		oldLaptop.setStorage(storage1);
		
		
		newLaptop.setID(id2);
		newLaptop.setCompany(company2);
		newLaptop.setCount(count2);
		newLaptop.setRAM(ram2);
		newLaptop.setStorage(storage2);
		
		dbMgr.updateLaptopItem(oldLaptop,newLaptop);
		
		
	}
	
	public void removeLaptopItem(LibraryItem item)
	{
		
		DBMgr dbMgr=new DBMgr();
		dbMgr.removeLaptopItem( item);
		
	}
	
	public void removeBookItem(LibraryItem item)
	{
		DBMgr dbMgr=new DBMgr();
		
		dbMgr.removeBookItem(item);
		
	}
	public void undo() {
		
		DBMgr dbMgr=new DBMgr();
		dbMgr.undo();
		
	

		
	}
	public void redo() {

		DBMgr dbMgr=new DBMgr();
		dbMgr.redo();
		
		
	}
	
}
