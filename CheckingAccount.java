import java.util.Scanner;

public class CheckingAccount implements Hasmenu{
	private double balance;
	Scanner input = new scanner(System.in);

	public CheckingAccount(){
		this.balance = 0.0;
	}

	public CheckingAccount(double balance){
		this.balance = balance;
	}

    	public String menu(){
		System.out.println("Checking Account\nWhat do you want to do?\n0)quit\n1)check balance\n2)make a deposit\n3)make a withdrawl");
		String option = input.nextLine();
	}

    	public double getBalance(){
		return balance;
	}

    	public String getBalanceString(){
		return String.format("$%.2f", balance);
	}

    	public void setBalance(double balance){
		this.balance = balance;
	}
		
    	public void checkBalance(){
		System.out.println("Your balance is" + balance);
	}

    	private double getDouble(){
		try{
			Double.parseDouble(input.nextLine());
		}catch(Execption e){
			System.out.println("invalid input!");
			return 0;
		}
	}

    	public void makeDeposit(){
		System.out.println("Enter your deposit amount");
		double depositAmount = input.getDouble();
		if (depositAmount > 0){
			balance = depositAmount + balance;
			System.out.println("New Balance: " + balance);
		}else{
			System.out.println("invalid deposit amount heh")
		}
	}

    	public void makeWithdrawal(){
		System.out.println("How much would you like to withdrawl");
		double withdrawlAmount = input.getDouble();
		if (withdrawlAmount > 0 || withdrawlAmount < balance){
		       balance = balance - withdrawlAmount;
		       System.out.println("New balance: " + balance");
		}else{
			System.out.println("Invalid withdrawl amount :p"
		}
	}

	public String start(){
		boolean keepGoing = true;
		while(keepGoing){
			menuOption = input.menu();
			if menuOption.equals("0"){
				keepGoing = false;
			}else if(menuOption.equals("1"){
				checkBalance();
			}else if(menuOption.equals("2"){
				makeDeposit();
			}else if(menuOption.equals("3"){
				makeWithdrawl();
			}else{
				System.out.println("Invalid Option");
			}
		}
	}
	
	public static void main(String[] args){
		new CheckingAccount();
	}

}
