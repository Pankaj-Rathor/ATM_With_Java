/*
 *
 * @author PANKAJ-RATHOR
 *
 */
import java.util.*;
import java.io.*;
import java.sql.SQLException;
public class Atm
{
		//Account Detail
	static String userName;
	static int userAcc;
	static int userPass;
	static float balance;
	static int select;
	static String accType;
	static int withdrawAmount;
	static Scanner s;
	
	public static void main(String args[]) throws IOException, NumberFormatException, SQLException
	{
		System.out.println("Enter ATM Card .....");
		System.out.println("Validation .....");
		System.out.println("Card is Valid..");
		accountType();
	}
	
	public static void accountType()
	{	
		System.out.println("Select Account Type. \n 1.Saving Account \n 2.CurrentAccount \n 3.Cancel");
		select = input();
		if(select==1)
		{
			accType = "savingaccount";
			try {
				Authentications();
			} catch (NumberFormatException | IOException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(select==2)
		{
			accType = "currentaccount";
			try {
				Authentications();
			} catch (NumberFormatException | IOException | SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			s.close();
			System.exit(0);
		}
	}
	
	public static void Authentications() throws NumberFormatException, IOException, SQLException
	{
		AccountDetails Ad = new AccountDetails();
		int Try=0;
		while(Try<3)
		{
			System.out.print("Enter Account Number  : ");
			int accNO = input();
			System.out.print("Enter Account Password : ");
			int accPass = input();
			
			Ad.searchAccount(accNO, accType );
			userName=Ad.getName();
			userAcc=Ad.getAccount();
			userPass=Ad.getPass();
			balance=Ad.getBalance();
			if(accNO==userAcc && accPass==userPass)
			{
				System.out.println("correct");
				operations();
			}
			else
			{
				System.out.println("Wrong");
				Try++;
			}
		}
	}
	
	public static void operations() throws IOException, SQLException
	{
		System.out.println("Select Option. \n 1.Check \n 2.Withdraw \n 3.Cancel");
		select = input();
		if(select==1)
		{
			checkBalance();				
		}
		else if(select==2)
		{
			withDraw();
		}
		else
		{
			s.close();
			System.exit(0);
		}
	}
	
	public static void checkBalance() throws IOException, SQLException
	{
		System.out.println("Your Account Balance is : "+balance+"");
		operations();
	}

	public static void withDraw() throws IOException, SQLException
	{
		AccountDetails ub = new AccountDetails();
		System.out.print("Enter Withdraw amount : ");
		withdrawAmount = input();
		if(withdrawAmount<=balance)
		{
			balance=balance-withdrawAmount;
			ub.updateBalance(userAcc, balance, accType);
			System.out.println("Left Balance is : "+balance+"");
			System.out.println("Do You Want Reciept? \n 1.Yes \n 2.No");
			select = input();
			if(select==1)
			{
				try {
					printReciept();
				} catch (Exception e) {}
			}
			else if(select==2)
			{
				moreTransaction();
			}
		}
		else
		{
			System.out.println("Insufficient Balance");
			moreTransaction();
		}
	}
	
	public static void printReciept() throws IOException
	{
		FileWriter reciept = new FileWriter("PrintReciept"+userAcc+".txt");
		BufferedWriter buffer = new BufferedWriter(reciept);
		String recieptInfo = "Account Number : "+userAcc+"\nUser Name : "+userName+"\nWithdraw Amount : "+withdrawAmount+"\nLeft Balance : "+balance+"\n";
		buffer.write(recieptInfo);
		buffer.close();
		System.out.println("Print Reciept Successfully");
		moreTransaction();
	}

	public static void moreTransaction()
	{
		System.out.println("Do You Want More Transaction \n 1.Yes 2.No");
		select = input();
		if(select==1)
		{
			try {
				withDraw();
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(select==2)
		{
			s.close();
			System.exit(0);
		}
		else
		{
			s.close();
			System.exit(0);
		}
	}
	public static int input()
	{
		s = new Scanner(System.in);
		int inputNo = s.nextInt();
		return inputNo;
	}
}
