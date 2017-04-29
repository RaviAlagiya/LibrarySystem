package Persistence;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import BusinessObjects.LibraryItem;

public class GetAllItem extends GetItem{
	String type;
	DefaultTableModel tableModel;
	
	public GetAllItem(String type) {
		super(-1);
		this.type=type;
		
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}


	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}




	
	public void queryDB() throws SQLException {
		  Statement stmt = getConnection().createStatement();
		     ResultSet rs= stmt.executeQuery("SELECT * FROM "+this.type);
		    
		     this.setResultSet(rs);
		
	}

	
	public LibraryItem processResult() throws SQLException {
		
		
        Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();

        try
        {
          
            ResultSet rs =this.getResultSet();
           ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }

            //  Get row data

            while (rs.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }

                data.addElement( row );
            }

          
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }

        //  Create table with database data

       this.tableModel= new DefaultTableModel(data, columnNames)
        {
        	@Override
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
		
		
		return null;
	}


}
