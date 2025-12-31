
class BankAccount{
	
	String accountHolder;
	int accountNumber;
	int balance;
	
	public BankAccount(String accountHolder, int accountNumber , int balance) {
		this.accountHolder = accountHolder;
		this.accountNumber =  accountNumber;
		this.balance = balance;
		System.out.println("Current balance "+balance);
	}
	
	public void depoisitingMoney(int money) {
		balance+=money;
		System.out.println("Depoisted "+money);
		System.out.println("Current Balance "+balance);
	}
	
	public void withdrawingMoney(int money) {
		if(balance<money) {
			System.out.println("Insufficient balance");
		}
		
		else {
			balance-=money;
			System.out.println("Witdrawal amout "+money);
		}
		
		System.out.println("Current balance "+balance);
	}
	
	public void currentBalance() {
		System.out.println("Current balance "+balance);
	}
}

public class ATM {
	public static void main(String args[]) {
		BankAccount account1 = new BankAccount("Abhay Giri", 221500011, 2500);
		account1.depoisitingMoney(500);
		account1.withdrawingMoney(5000);
		account1.withdrawingMoney(3000);
	}
}
