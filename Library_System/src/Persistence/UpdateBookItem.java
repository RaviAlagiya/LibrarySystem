package Persistence;

import java.sql.SQLException;
import java.sql.Statement;

import BusinessObjects.Book;
import BusinessObjects.LibraryItem;

public class UpdateBookItem extends UpdateItem {
	Book oldBook;
	Book newBook;
	
	 public UpdateBookItem(LibraryItem oBook,LibraryItem nBook) {
	
		
		this.oldBook=(Book) oBook;
		this.newBook=(Book) nBook;
		
	}

	
	public void queryDB() throws SQLException {
		

		 Statement stmt = getConnection().createStatement();

		stmt.executeUpdate("UPDATE  Book SET Name='"+newBook.getName() +"' ,Author ='"+newBook.getAuthor() +"',ISBN ='"+newBook.getISBN() +"',count="+newBook.getCount() +" where ID="+newBook.getID());
   
		
		
	}


	public void queryDBUndo() throws SQLException {
		

		 Statement stmt = getConnection().createStatement();

		stmt.executeUpdate("UPDATE  Book SET Name='"+oldBook.getName() +"' ,Author ='"+oldBook.getAuthor() +"',ISBN ='"+oldBook.getISBN() +"',count="+oldBook.getCount() +" where ID="+oldBook.getID());
  
		
	}


	

	

}
