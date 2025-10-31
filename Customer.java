import java.util.Scanner;

public class Customer extends User{
    private CheckingAccount checking;
    private SavingsAccount savings;
    private Scanner input  = new Scanner(System.in);

    public Customer(){
        this("Alice", "0000");
    }


    public Customer(String userName, String PIN){
        this.userName = userName;
        this.PIN = PIN;
        this.checking = new CheckingAccount(100.00);
        this.savings = new SavingsAccount(100.00, 0.03);
    }

    public void changePin(){
        System.out.print("Enter new PIN: ");
        this.PIN = scanner.nextLine();
        System.out.println("PIN successfully changed!");
    }

    public String menu(){
        System.out.println("Customer Menu\n0)Exit 1) Checking Account\n2)Savings Account\n3)Change PIN");
	String menuChoice = input.nextLine();
	if (menuChoice.equals("0"){
		keepGoing = false;
	}else if(menuChoice.equals("1")){
		checking.start();
	}else if(menuChoice.equals("2")){
		savings.start();
	}else if(menuChoice.equals("3")){
		changePin();
	}else{
		System.out.println("Invalid input");
	}
    }

    public void start() {
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println(menu());
            }
        }
    }

    public String getReport() {
        System.out.println("Customer: " + userName + "\nChecking: " + checking.getBalanceString() + "\nSavings: " + savings.getBalanceString());
    }

    public static void main(String[] args) {
        Customer testCustomer = new Customer("Alice", "0000");
    }
}
