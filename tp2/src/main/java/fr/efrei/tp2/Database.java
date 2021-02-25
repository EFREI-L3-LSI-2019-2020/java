package fr.efrei.tp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
	private Connection conn;

	public Database()
	{
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/efrei_tp2?serverTimezone=UTC", "root", "");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public ProgrammerList getProgrammers()
	{
		ProgrammerList list = new ProgrammerList();

		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from programmer");

			while(rs.next())
			{
				list.add(getProgrammer(rs));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return list;
	}

	public ProgrammerList getProgrammers(String name)
	{
		ProgrammerList list = new ProgrammerList();

		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from programmer where name != '" + name + "'");

			while(rs.next())
			{
				list.add(getProgrammer(rs));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return list;
	}

	private Programmer getProgrammer(ResultSet rs) throws SQLException
	{
		return new Programmer(rs.getString("name"), rs.getString("firstname"),
			Integer.parseInt(rs.getString("birth")), Float.parseFloat(rs.getString("salary")), 
			Float.parseFloat(rs.getString("salary")), rs.getString("pseudo"));
	}
}