package Controller;

import javax.swing.table.DefaultTableModel;

import BusinessObjects.Book;
import BusinessObjects.LibraryItem;
import Persistence.DBMgr;

public class GetController {

	public LibraryItem getBookItem(int id) {
		DBMgr dbMgr=new DBMgr();
		
		return dbMgr.getBookItem(id);
	}
	

	
	public DefaultTableModel getAllItem(String type) {
		

		DBMgr dbMgr=new DBMgr();
		
		return dbMgr.getAllItem(type);
	
		
	}
	
	public LibraryItem getLaptopItem(int id) {
		DBMgr dbMgr=new DBMgr();
		
		return dbMgr.getLaptopItem(id);
	}

}
