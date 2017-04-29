package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessObjects.Book;
import BusinessObjects.Laptop;
import BusinessObjects.LibraryItem;

public class RemoveLaptopItem extends RemoveItem  {

	public RemoveLaptopItem(LibraryItem item) {
		super(item);
		
	}

	@Override
	public void queryDB() throws SQLException {
		
		 Statement stmt = getConnection().createStatement();
	      stmt.executeUpdate("DELETE FROM Laptop WHERE id="+this.getId());
	    
	     stmt.close();
		
		
	}

	
	public void queryDBUndo() throws SQLException {
		
		Laptop l=(Laptop) this.getDeletedItem() ;
		
		 Statement stmt = getConnection().createStatement();
		 if(l!= null)
		 {
			 stmt.executeUpdate("INSERT INTO Laptop (RAM,Company,Storage,Count,ID) VALUES("+l.getRAM()+",'"+
					 l.getCompany() +"',"+l.getStorage()+","+ l.getCount()+","+this.getId()+")");
		 }
		
		 else
		 {
			 System.out.println("item is null");
		 }
	     stmt.close();
		
		
				
	}



}
