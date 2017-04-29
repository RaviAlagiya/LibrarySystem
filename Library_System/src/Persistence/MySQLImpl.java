package Persistence;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import BusinessObjects.LibraryItem;

public class MySQLImpl implements DBImplInterface{

	@Override
	public LibraryItem getBookItem(int ID) {
		
		MySQLImplCmd getBook=new GetBookItem(ID);
		getBook.execute();
		return getBook.getItem();
	}

	@Override
	public LibraryItem getLaptopItem(int ID) {
		MySQLImplCmd getLaptop=new GetLaptopItem(ID);
		getLaptop.execute();
		return getLaptop.getItem();
	}

	@Override
	public void saveBookItem(LibraryItem item) {
		MySQLImplCmd saveBook=new SaveBookItem(item);
		saveBook.execute();
		MySQLImplCmd.getExecutedStack().add(saveBook);
		
	}

	@Override
	public void saveLaptopItem(LibraryItem item) {
		MySQLImplCmd saveLaptop=new SaveLaptopItem(item);
		saveLaptop.execute();
		MySQLImplCmd.getExecutedStack().add(saveLaptop);
		
	}
	
	public void removeLaptopItem(LibraryItem item) {
		MySQLImplCmd removeLaptop=new RemoveLaptopItem(item);
		removeLaptop.execute();
		MySQLImplCmd.getExecutedStack().add(removeLaptop);
		
	}
	
	public void removeBookItem(LibraryItem item) {
		MySQLImplCmd removeBook=new RemoveBookItem(item);
		removeBook.execute();
		MySQLImplCmd.getExecutedStack().add(removeBook);
		
		
	}

	public void updateBookItem(LibraryItem oldBook, LibraryItem newBook) {
		MySQLImplCmd updateBook=new UpdateBookItem(oldBook,  newBook);
		updateBook.execute();
		MySQLImplCmd.getExecutedStack().add(updateBook);
		
	}

	public void updateLaptopItem(LibraryItem oldLaptop, LibraryItem newLaptop) {
		MySQLImplCmd updateLaptop=new UpdateLaptopItem(oldLaptop,  newLaptop);
		updateLaptop.execute();
		MySQLImplCmd.getExecutedStack().add(updateLaptop);
		
	}

	
	public DefaultTableModel getAllItem(String Type) {
		MySQLImplCmd getAllItem=new GetAllItem(Type);
		getAllItem.execute();
		return ((GetAllItem)getAllItem).getTableModel();
	}

	public void undo() {
		try
		{
			MySQLImplCmd temp=MySQLImplCmd.getExecutedStack().pop();
			MySQLImplCmd.getUndoneStack().push(temp);
			temp.undo();
		}
		catch(java.util.EmptyStackException e)
		{
			//Nothing to undo
		}
		
		
		
	}

	public void redo() {
		try
		{
			MySQLImplCmd temp=MySQLImplCmd.getUndoneStack().pop();
			MySQLImplCmd.getExecutedStack().push(temp);
			temp.redo();
		}
		catch(java.util.EmptyStackException e)
		{
			//Nothing to undo
		}
		
		
	}

	
	
	
}
