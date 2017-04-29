package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;

import BusinessObjects.LibraryItem;

public abstract class MySQLImplCmd {
	private static Stack<MySQLImplCmd> executedStack=new Stack<MySQLImplCmd>();
	private static Stack<MySQLImplCmd> undoneStack=new Stack<MySQLImplCmd>();
	private int id;
	private LibraryItem item;
	private ResultSet resultSet; 
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/SDP_Assignment1_library";
	private String username = "root";
	private String password = "";
	
	public MySQLImplCmd(int id)
	{
		this.setId(id);
		
		
	}
	

	public static Stack<MySQLImplCmd> getExecutedStack() {
		return executedStack;
	}


	public static void setExecutedStack(Stack<MySQLImplCmd> executedStack) {
		MySQLImplCmd.executedStack = executedStack;
	}


	public static Stack<MySQLImplCmd> getUndoneStack() {
		return undoneStack;
	}


	public static void setUndoneStack(Stack<MySQLImplCmd> undoneStack) {
		MySQLImplCmd.undoneStack = undoneStack;
	}
	
	public abstract void queryDBUndo() throws SQLException;
	
	public void redo()
	{
		execute();
	}

	public void undo()
	{
		try{
			connectDB();
			queryDBUndo();
			
			disconnectDB();
			
			
			}
			catch(Exception e)
			{
				disconnectDB();

				e.printStackTrace();
			}
		
		
	}


	
	public void execute()
	{
	
		try{
		connectDB();
		queryDB();
		item=processResult();
		disconnectDB();
		
		
		}
		catch(Exception e)
		{
			disconnectDB();

			e.printStackTrace();
		}
		
	}
		
	//public abstract 
	
	public abstract void queryDB() throws SQLException;
	public abstract LibraryItem processResult() throws SQLException;
	
	//public abstract void redo();
	
	
	public void connectDB() throws SQLException
	{
		
	
			this.setConnection(DriverManager.getConnection(url, username, password));

		
	}
	public void disconnectDB() 
	{
		
	
			if(getConnection() != null)
				try {
					getConnection().close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		
		
	
	}

	
	public LibraryItem getItem() {
		return item;
	}
	public void setItem(LibraryItem item) {
		this.item = item;
	}



	public Connection getConnection() {
		return connection;
	}



	public void setConnection(Connection connection) {
		this.connection = connection;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	public ResultSet getResultSet() {
		return resultSet;
	}



	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
}
