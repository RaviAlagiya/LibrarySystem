package Persistence;

import java.sql.SQLException;
import java.sql.Statement;

import BusinessObjects.Book;
import BusinessObjects.Laptop;
import BusinessObjects.LibraryItem;

public class SaveBookItem extends SaveItem {

	
	Book oldBook;
	
	public SaveBookItem(LibraryItem item) {
		super(item);
		oldBook=(Book) (item);
		
	}

	
	public void queryDB() throws SQLException {
		super.setItem(oldBook);
		
		 Statement stmt = getConnection().createStatement();
		 
		stmt.executeUpdate("INSERT INTO Book (Name,Author,ISBN,count) VALUES('"+((Book)(super.getItem())).getName()+"','"+
			 ((Book)(super.getItem())).getAuthor() +"','"+((Book)(super.getItem())).getISBN()+"',"+ ((Book)(super.getItem())).getCount()+")");
    }


	
	public void queryDBUndo() throws SQLException {
		Book b=oldBook;
		
		 Statement stmt = getConnection().createStatement();
		 

		 //DELETE FROM Book WHERE Name = '2' and Author='suthor' and count=4 
		   stmt.executeUpdate("DELETE FROM Book WHERE Name='"+b.getName()+"' and Author='"+b.getAuthor()+"' and count="+b.getCount() +" and ISBN='"+b.getISBN()+"'");
		
   }


	

	

}
