package Persistence;

import BusinessObjects.LibraryItem;

public abstract class RemoveItem extends MySQLImplCmd{
private	LibraryItem deletedItem;




	public RemoveItem(LibraryItem item) {
		super(item.getID());
		this.deletedItem=item;
		
	}
	
	public LibraryItem getDeletedItem() {
	return deletedItem;
}


public void setDeletedItem(LibraryItem deletedItem) {
	this.deletedItem = deletedItem;
}
	
	
	public LibraryItem processResult() {
		
		return null;
	}


}
