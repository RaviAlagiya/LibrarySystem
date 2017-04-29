package Persistence;

import java.awt.Label;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessObjects.Laptop;
import BusinessObjects.LibraryItem;

public class GetLaptopItem extends GetItem{

	public GetLaptopItem(int id) {
		super(id);
		
	}

	@Override
	public void queryDB() throws SQLException {

	
	     Statement stmt = getConnection().createStatement();
	     ResultSet rs= stmt.executeQuery("SELECT * FROM Laptop where id="+this.getId());
	     setResultSet(rs);
	    // stmt.close();
	

		
	}

	@Override
	public LibraryItem processResult() throws SQLException {
		ResultSet rs=getResultSet();
		Laptop laptop=new Laptop();
		
		 while (rs.next()) {  
			 laptop.setCount(rs.getInt(5));
			 laptop.setID(rs.getInt(1));
			 laptop.setRAM(rs.getInt(2));
			 laptop.setStorage(rs.getInt(4));
			 laptop.setCompany(rs.getString(3));
		     
		       
		       
		}
		 if (rs != null) {
			 //rs.close();
		}
		// TODO Auto-generated method stub
		return laptop;
	}

}
