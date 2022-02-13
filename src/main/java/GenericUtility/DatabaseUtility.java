package GenericUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


public class DatabaseUtility 
{
	Connection con=null;
	//Step 1: register the database--1
	//Step 2: get connecton with DB--1
	//Step 3: issue create statement--2
	//Step 4: execute Querry--2
	//Step 5: close connection--3
	/**
	 * This method will establish connecton wth database 
	 */
	public void connectToDB() throws Throwable
	{
		 Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(IConstants.dbURL, IConstants.dbUserName, IConstants.dbPassword);
	}
	
	/**
	 * this method will execute query and return the data present in data base
	 * @return 
	 * @throws Throwable 
	 */
	public String executeQueryAndGetData(String query, int columnIndex,String expData) throws Throwable
	{
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String value = result.getString(columnIndex);
			if(value.equalsIgnoreCase(expData))
			{
				flag=true;//risng flag
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+"===> Data Verified ");
			return expData;
		}
			else {
					System.out.println("dta not present");
					return "";
			  	  }
		
	}
	
	public void closeDB() throws Throwable
	{
		con.close();
	}
}






