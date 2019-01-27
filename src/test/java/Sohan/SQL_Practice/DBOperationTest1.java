package Sohan.SQL_Practice;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;


public class DBOperationTest1 {

	@Test
	public void testSQL_WildCard() throws SQLException { // testing from dbo.T_Employee_Details
		String str = "SELECT * FROM dbo.T_Employee_Details WHERE eID LIKE '[1-4]%'";
		int x = DBOperation.SQL_WildCard(str); // id starts with 1-4
		assertEquals(45, x);
	}

	@Test
	public void testSQL_In() throws SQLException { // testing from dbo.T_Employee_Details
		String str = "SELECT * FROM dbo.T_Employee_Details WHERE eID IN (1,2,3,4,5)";
		int x = DBOperation.SQL_In(str); // id with value 1,2,3,4,5
		assertEquals(5, x);
	}

	@Test
	public void testSQL_Between() throws SQLException { // testing from dbo.T_Employee_Details
		String str = "SELECT * FROM dbo.T_Employee_Details WHERE eID BETWEEN 10 and 20";
		int x = DBOperation.SQL_Between(str); // id with value 10 to 20
		assertEquals(11, x);
	}

	@Test
	public void testSQL_InnerJoin() throws SQLException {// testing from dbo.T_Employee_Details, dbo.T_Employee_Details_2
		String str = "SELECT dbo.T_Employee_Details.eName, dbo.T_Employee_Details_2.eCity FROM dbo.T_Employee_Details INNER JOIN dbo.T_Employee_Details_2 ON dbo.T_Employee_Details.eID=dbo.T_Employee_Details_2.eID";
		int x = DBOperation.SQL_InnerJoin(str);
		assertEquals(50, x); // there are 50 common id in both table
	}

	@Test
	public void testSQL_LeftJoin() throws SQLException { // testing from dbo.T_Employee_Details, dbo.T_Employee_Details_2
		String str = "SELECT dbo.T_Employee_Details.eName, dbo.T_Employee_Details_2.eCity FROM dbo.T_Employee_Details Left JOIN dbo.T_Employee_Details_2 ON dbo.T_Employee_Details.eID=dbo.T_Employee_Details_2.eID";
		int x = DBOperation.SQL_LeftJoin(str);
		assertEquals(100, x); // there are 50 common id in both table, and 50 more id in table dbo.T_Employee_Details
	}
	
	@Test
	public void testSQL_RightJoin() throws SQLException { // testing from dbo.T_Employee_Details, dbo.T_Employee_Details_2
		String str = "SELECT dbo.T_Employee_Details.eName, dbo.T_Employee_Details_2.eCity FROM dbo.T_Employee_Details RIGHT JOIN dbo.T_Employee_Details_2 ON dbo.T_Employee_Details.eID=dbo.T_Employee_Details_2.eID";
		int x = DBOperation.SQL_RightJoin(str);
		assertEquals(100, x); // there are 50 common id in both table, and 50 more id in table dbo.T_Employee_Details_2
	}
	
	@Test
	public void testSQL_FullJoin() throws SQLException {  // testing from dbo.T_Employee_Details, dbo.T_Employee_Details_2
		String str = "SELECT dbo.T_Employee_Details.eName, dbo.T_Employee_Details_2.eCity FROM dbo.T_Employee_Details FULL OUTER JOIN dbo.T_Employee_Details_2 ON dbo.T_Employee_Details.eID=dbo.T_Employee_Details_2.eID";
		int x = DBOperation.SQL_FullJoin(str);  
		assertEquals(150, x); // there are 50 common id in both table, and 50 more id in table dbo.T_Employee_Details, and 50 more id in table dbo.T_Employee_Details_2
	}
	
	@Test
	public void testSQL_SelfJoin() throws SQLException { // testing from dbo.T_Employee_Details_2
		String str = "SELECT A.eName AS Name1,B.eName AS Name2, A.eCity FROM dbo.T_Employee_Details_2 A, dbo.T_Employee_Details_2 B WHERE A.eID<>B.eID AND A.eCity=B.eCity";
		int x = DBOperation.SQL_SelfJoin(str); 
		assertEquals(9900, x); // Cz operation is something like,  number of iteration in (for(i=1;i<=100;i++){for(j=1;j<=100;j++){}}) - when i==j
	}

	@Test
	public void testSQL_Union() throws SQLException { // testing from dbo.T_Employee_Details, dbo.T_Employee_Details_2
		String str = "SELECT eID FROM dbo.T_Employee_Details_2 UNION SELECT eID FROM dbo.T_Employee_Details";
		int x = DBOperation.SQL_Union(str); // use union all to keep duplicate data
		assertEquals(150, x); // taking common data only one time
	}
	
	
	
	@Test
	public void testSQL_GroupBy() throws SQLException { // testing from dbo.T_Employee_Details_2
		String str = "SELECT COUNT(eID), eCity FROM dbo.T_Employee_Details_2 GROUP BY eCity";
		int x = DBOperation.SQL_GroupBy(str); 
		assertEquals(1, x); // I have only one city name in my database
	}
	
	@Test
	public void testSQL_Having() throws SQLException { // testing from dbo.T_Employee_Details_2
		String str = "SELECT COUNT(eID), eCity FROM dbo.T_Employee_Details_2 GROUP BY eCity HAVING COUNT(eID)>10";
		int x = DBOperation.SQL_Having(str); 
		assertEquals(1, x); // I have only one city name in my database which have more than 10 count
	}
	
	@Test
	public void testSQL_EXISTS() throws SQLException { // testing from dbo.T_Employee_Details
		String str = "SELECT eID FROM dbo.T_Employee_Details WHERE EXISTS(SELECT eID WHERE eID = dbo.T_Employee_Details.eID AND EsALARY>50)";
		int x = DBOperation.SQL_EXISTS(str); 
		assertEquals(50, x); // I have 50 ID where salary is greater than 50
	}
	
	
	

}
