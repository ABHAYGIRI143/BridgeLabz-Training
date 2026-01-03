
class BankAccounts{
	int accountNumber;
	int balance;
}

class CheckingAccount extends BankAccounts{
	
	final int withdrawlLimit = 10000;
	
	public CheckingAccount(int accountNumber,int balance) {
		
		this.accountNumber=accountNumber;
		this.balance = balance;

	}
	
	void displayAccountType() {
		System.out.println("Account Type : Checking Account");
	}

}


class SavingAccount extends BankAccounts{

	final int intrestRate=10;
	
public SavingAccount(int accountNumber,int balance) {
		
		this.accountNumber=accountNumber;
		this.balance = balance;

	}

	void displayAccountType() {
		System.out.println("Account Type : Saving Account");
	}
	
}

class FixedDepoistAccount extends BankAccounts{
	
public FixedDepoistAccount(int accountNumber,int balance) {
		
		this.accountNumber=accountNumber;
		this.balance = balance;

	}
	
	void displayAccountType() {
		System.out.println("Account Type : Fixed Depoist Account");
	}
	
}

public class BankAccountTypes {
	public static void main(String args[]) {
		CheckingAccount checkingAccount1= new CheckingAccount(2110723478,2500);
		FixedDepoistAccount fixedDepoistAccount1 =  new FixedDepoistAccount(236257292, 6000);
		SavingAccount savingAccount1 = new SavingAccount(32734333, 5000);
		
		checkingAccount1.displayAccountType();
		fixedDepoistAccount1.displayAccountType();
		savingAccount1.displayAccountType();
	}
}
