package Persistence;

import java.sql.SQLException;
import java.sql.Statement;

import BusinessObjects.Laptop;
import BusinessObjects.LibraryItem;

public class UpdateLaptopItem extends UpdateItem  {
	
	Laptop oldLaptop;
	Laptop newLaptop;


	public UpdateLaptopItem(LibraryItem oLaptop,LibraryItem nLaptop)
	{
		 this.oldLaptop=(Laptop) oLaptop;
		 this.newLaptop=(Laptop) nLaptop;

		
	}
	
	
	public void queryDB() throws SQLException {
		

		 Statement stmt = getConnection().createStatement();
		 //UPDATE Laptop SET Company='testedit', RAM = 10,Storage=123,Count=12 where ID=19;
		stmt.executeUpdate("UPDATE  Laptop SET Company='"+newLaptop.getCompany() +"' ,RAM ="+newLaptop.getRAM() +",Storage ="+newLaptop.getStorage() +",count="+newLaptop.getCount() +" where ID="+newLaptop.getID());
  
		

		
		
	}


	@Override
	public void queryDBUndo() throws SQLException {

		 Statement stmt = getConnection().createStatement();
		stmt.executeUpdate("UPDATE  Laptop SET Company='"+oldLaptop.getCompany() +"' ,RAM ="+oldLaptop.getRAM() +",Storage ="+oldLaptop.getStorage() +",count="+oldLaptop.getCount() +" where ID="+newLaptop.getID());
 
	}

	

}
