package Persistence;

import BusinessObjects.LibraryItem;

public abstract class SaveItem extends MySQLImplCmd{
	

	public SaveItem(LibraryItem item) {
		super(-1);
		super.setItem(item);
		
		
		
	}
	
	public LibraryItem processResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
