package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessObjects.Book;
import BusinessObjects.LibraryItem;

public class RemoveBookItem extends RemoveItem {

	public RemoveBookItem(LibraryItem item) {
		super(item);
		
		
	}

	public void queryDB() throws SQLException {
		
		 Statement stmt = getConnection().createStatement();
	      stmt.executeUpdate("DELETE FROM Book WHERE id="+this.getId());
	    
	     stmt.close();
		
		
	}

	@Override
	public void queryDBUndo() throws SQLException {

		Book b=(Book) this.getDeletedItem() ;
		
		 Statement stmt = getConnection().createStatement();
		 if(b!= null)
		 {
			 stmt.executeUpdate("INSERT INTO Book (Name,Author,ISBN,count,ID) VALUES('"+b.getName()+"','"+
					 b.getAuthor() +"','"+b.getISBN()+"',"+ b.getCount()+"," +this.getId()+")");
		 }
		
   
		 else
		 {
			 System.out.println("item is null");
		 }
		
		
		
	}





}
