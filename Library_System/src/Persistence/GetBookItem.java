package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessObjects.Book;
import BusinessObjects.Laptop;
import BusinessObjects.LibraryItem;

public class GetBookItem extends GetItem{

	public GetBookItem(int id) {
		super(id);
		
	}

	
	public void queryDB() throws SQLException {
		  Statement stmt = getConnection().createStatement();
		     ResultSet rs= stmt.executeQuery("SELECT * FROM Book where id="+this.getId());
		     this.setResultSet(rs);
		   
		
	}

	
	public LibraryItem processResult() throws SQLException {
		ResultSet rs=this.getResultSet();
		Book book=new Book();
		if(rs == null) System.out.println("null found");
		
		while (rs.next()) { 
			
			 book.setCount(rs.getInt(5));
			 book.setID(rs.getInt(1));
			 book.setName(rs.getString(2));
			 book.setISBN(rs.getString(4));
			 book.setAuthor(rs.getString(3));
		     
		       
		       
		}
		 if (rs != null) {
			// rs.close();
		}
	
		return book;
	}


	

}
