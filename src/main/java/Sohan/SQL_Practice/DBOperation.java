package Sohan.SQL_Practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBOperation {
	
	public static int SQL_WildCard() throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.T_Employee_Details WHERE eID LIKE '[1-4]%'");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}

	public static int SQL_In() throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.T_Employee_Details WHERE eID IN (1,2,3,4,5)");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_Between() throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.T_Employee_Details WHERE eID BETWEEN 10 and 20");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_InnerJoin() throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT dbo.T_Employee_Details.eName, dbo.T_Employee_Details_2.eCity FROM dbo.T_Employee_Details INNER JOIN dbo.T_Employee_Details_2 ON dbo.T_Employee_Details.eID=dbo.T_Employee_Details_2.eID");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_LeftJoin() throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT dbo.T_Employee_Details.eName, dbo.T_Employee_Details_2.eCity FROM dbo.T_Employee_Details Left JOIN dbo.T_Employee_Details_2 ON dbo.T_Employee_Details.eID=dbo.T_Employee_Details_2.eID");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}

	public static int SQL_RightJoin() throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT dbo.T_Employee_Details.eName, dbo.T_Employee_Details_2.eCity FROM dbo.T_Employee_Details RIGHT JOIN dbo.T_Employee_Details_2 ON dbo.T_Employee_Details.eID=dbo.T_Employee_Details_2.eID");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_FullJoin() throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT dbo.T_Employee_Details.eName, dbo.T_Employee_Details_2.eCity FROM dbo.T_Employee_Details FULL OUTER JOIN dbo.T_Employee_Details_2 ON dbo.T_Employee_Details.eID=dbo.T_Employee_Details_2.eID");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}

	public static int SQL_SelfJoin() throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT A.eName AS Name1,B.eName AS Name2, A.eCity FROM dbo.T_Employee_Details_2 A, dbo.T_Employee_Details_2 B WHERE A.eID<>B.eID AND A.eCity=B.eCity");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_Union() throws SQLException  {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT eID FROM dbo.T_Employee_Details_2 UNION SELECT eID FROM dbo.T_Employee_Details");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}

	public static int SQL_GroupBy() throws SQLException  {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT COUNT(eID), eCity FROM dbo.T_Employee_Details_2 GROUP BY eCity");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_Having() throws SQLException  {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT COUNT(eID), eCity FROM dbo.T_Employee_Details_2 GROUP BY eCity HAVING COUNT(eID)>10");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	

	
	public static int SQL_EXISTS() throws SQLException  {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT eID FROM dbo.T_Employee_Details WHERE EXISTS(SELECT eID WHERE eID = dbo.T_Employee_Details.eID AND EsALARY>50)");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	
}
