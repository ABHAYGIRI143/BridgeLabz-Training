

class BankAccount{
	int accountNumber;
	double balance;
		
	
	public BankAccount(int accountNumber,double balance) {
		this.accountNumber =  accountNumber;
		this.balance = balance;
	}
	double depoist(int money) {
		balance +=  money;
		 return balance;
	}
	
	double withdraw(int money) {
		 if(balance>money) {
			 System.out.println("You dont have enough amount in your bank account");
		 }
		return (balance-money);
	}
	
	void checkBalance() {
		System.out.println("Current Balance is "+balance);
	}
	
	
}

public class BankAccountManager {
	public  static void main(String args[]) {
		BankAccount b1 =  new BankAccount(8367325,6000);
		
	}
}
