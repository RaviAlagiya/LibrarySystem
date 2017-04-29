package Persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessObjects.Book;
import BusinessObjects.Laptop;
import BusinessObjects.LibraryItem;

public class SaveLaptopItem extends SaveItem {

	
	Laptop oldlaptop;
	public SaveLaptopItem(LibraryItem item) {
		super(item);
		oldlaptop=(Laptop) item;
		
		
	}

	@Override
	public void queryDB() throws SQLException {
	super.setItem(oldlaptop);
		 Statement stmt = getConnection().createStatement();
		 stmt.executeUpdate("INSERT INTO Laptop (RAM,Company,Storage,Count) VALUES("+((Laptop)(this.getItem())).getRAM()+",'"+
		 ((Laptop)(this.getItem())).getCompany() +"',"+((Laptop)(this.getItem())).getStorage()+","+ ((Laptop)(this.getItem())).getCount()+")");
	     stmt.close();
		
		
	}

	@Override
	public void queryDBUndo() throws SQLException {
		Laptop l=oldlaptop;
		
		 Statement stmt = getConnection().createStatement();
		 					// DELETE FROM Laptop WHERE Company = '' and Storage=21 and count=21 and RAM=21;
		   stmt.executeUpdate("DELETE FROM Laptop WHERE Company='"+l.getCompany()+"' and Storage="+l.getStorage()+" and count="+l.getCount() +" and RAM="+l.getRAM());
		
  }



}
