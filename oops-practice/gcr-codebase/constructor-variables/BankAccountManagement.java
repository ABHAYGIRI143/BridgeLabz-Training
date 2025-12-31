
class BankAccount {


    public long accountNumber;
    protected String accountHolder;
    private double balance;

  
    BankAccount(long accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public getter for balance
    public double getBalance() {
        return balance;
    }

    // Public deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Public withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }
}

class SavingsAccount extends BankAccount {

    SavingsAccount(long accountNumber, String accountHolder,
                   double balance) {
        super(accountNumber, accountHolder, balance);
     
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);   // public
        System.out.println("Account Holder: " + accountHolder);   // protected
        System.out.println("Balance: ₹" + getBalance());          // private via method
    }
}



public class BankAccountManagement {

	public static void main(String args[]) {
	SavingsAccount sa = new SavingsAccount(1234567890L,"Abhay",10000.0);
    sa.displayAccountDetails();

    sa.deposit(5000);
    sa.withdraw(3000);

    System.out.println("Updated Balance: ₹" + sa.getBalance());
}
}