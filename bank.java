package bankingapplication;
import java.util.Scanner;
public class bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

		bankaccount obj1 = new bankaccount(customerName, customerId);
		obj1.showMenu();
		
		scanner.close();
	}

}

class bankaccount
{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	bankaccount(String cname,String cid)
	{
		customerName=cname;
		customerId=cid;
	}
	
	void deposit(int amount)
	{
		if(amount!=0)
		{
			balance=balance+amount;
			previousTransaction=amount;
		}
	}
	
	void withdraw(int amount)
	{
		if(amount!=0)
		{
			balance=balance-amount;
			previousTransaction=-amount;
		}
	}
	
	void getPreviousTransaction()
	{
		if(previousTransaction > 0)
		{
			System.out.println("Deposited: "+previousTransaction);
		}
		else if(previousTransaction < 0)
		{
			System.out.println("Withdrawn: "+Math.abs(previousTransaction));//if there is negative sign it will convert to +ve
		}
		else
		{
			System.out.println("No transaction occured");
		}
	}
	
	void showMenu() 
	{
		char option='\0';
		Scanner scanner =new Scanner(System.in);
		
		System.out.println("Welcome "+customerName);
		System.out.println("Your id is "+customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous transaction");
		System.out.println("E. Exit");
		
		do
		{
			System.out.println("=========================================================");
			System.out.println("Enter your option");
			System.out.println("=========================================================");
			option=scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
				case 'A':
					System.out.println("-----------------------------------------------------");
					System.out.println("Balance = "+balance);
					System.out.println("------------------------------------------------------");
					System.out.println("\n");
					break;
					
				case 'B':
					System.out.println("-----------------------------------------------------");
					System.out.println("Enter an amount to deposit");
					System.out.println("------------------------------------------------------");
					int amount=scanner.nextInt();
					deposit(amount);
					System.out.println("\n");
					break;
					
				case 'C':
					System.out.println("-----------------------------------------------------");
					System.out.println("Enter an amount to deposit");
					System.out.println("------------------------------------------------------");
					int amount2=scanner.nextInt();
					withdraw(amount2);
					System.out.println("\n");
					break;
					
				case 'D':
					System.out.println("-----------------------------------------------------");
					getPreviousTransaction();
					System.out.println("------------------------------------------------------");
					System.out.println("\n");
					break;
				
				case 'E':
					System.out.println("*********************************************************");
					break;
					
				default:
					System.out.println("Invalid option!! Please enter again");
					break;
			
			}
		}while(option !='E');
		System.out.println("Thankyou for using our services ");
		scanner.close();
	}
	
}
