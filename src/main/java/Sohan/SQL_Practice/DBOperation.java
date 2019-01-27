package Sohan.SQL_Practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBOperation {
	
	public static int SQL_WildCard(String str) throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}

	public static int SQL_In(String str) throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_Between(String str) throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_InnerJoin(String str) throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_LeftJoin(String str) throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}

	public static int SQL_RightJoin(String str) throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_FullJoin(String str) throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}

	public static int SQL_SelfJoin(String str) throws SQLException {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_Union(String str) throws SQLException  {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}

	public static int SQL_GroupBy(String str) throws SQLException  {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_Having(String str) throws SQLException  {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int SQL_EXISTS(String str) throws SQLException  {
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(str);
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	
}
