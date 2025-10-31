import java.util.Scanner;

public class SavingsAccount extends CheckingAccount{
	
	private double interestRate;
	Scanner input = new scanner(System.in);
	
	public SavingsAccount(){
		super();
		this.interestRate = 0.1;
	}

	public SavingsAccount(double balance, double interestRate){
		super(balance);
		this.interestRate = intrestRate;
	}

	public void calcInterest(){
	        double interest = getBalance() * interestRate;
        	setBalance(getBalance() + interest);
	}

	public void setInterestRate(double intRate){
		this.interestRate = intRate;
	}

	public void getInterestRate(){
		return interestRate;
	}
}
