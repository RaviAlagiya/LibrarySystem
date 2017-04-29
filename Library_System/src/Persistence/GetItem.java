package Persistence;

import java.sql.SQLException;

import BusinessObjects.LibraryItem;

public abstract class GetItem extends MySQLImplCmd{

	public GetItem(int id) {
		super(id);
		
	}
	
	public void queryDBUndo() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

	


}
