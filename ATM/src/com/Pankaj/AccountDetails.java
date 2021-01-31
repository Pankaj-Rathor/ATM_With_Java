package com.Pankaj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDetails
{
	int Uaccount;
    String Uname;
    int Upass;
    float Ubalance;
	//Register Driver
	static 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Build Connection with Driver
	public Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sbi", "root", "");
	}
	
	//Search Account
	public void searchAccount(int accNo, String accType) throws NumberFormatException, IOException, SQLException
	{
		int AccountNo = accNo;
		String AccountType = accType;
		//getConnection 
		Connection con = getConnection();
		//Create Statement
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from "+AccountType+" where Uaccount="+AccountNo+"");
		
		while (rs.next()) {
           Uaccount = rs.getInt("Uaccount");
           Uname = rs.getString("Uname");
           Upass = rs.getInt("Upass");
           Ubalance = rs.getFloat("Ubalance");
	     }
		//Close st rs con
		st.close();
		rs.close();
		con.close();
	}
	
	public void updateBalance(int accNo, float Ubalance, String accType)throws IOException, SQLException
    {
        float balance = Ubalance;
        Connection con=getConnection();
        Statement st=con.createStatement();
        st.executeUpdate("UPDATE "+accType+" SET Ubalance='"+balance+"' WHERE Uaccount='"+accNo+"'");
        st.close();
        con.close();
    }
	
	public int getAccount()
	{
		return Uaccount;
	}
	public int getPass()
	{
		return Upass;
	}
	public String getName()
	{
		return Uname;
	}
	public float getBalance()
	{
		return Ubalance;
	}
}