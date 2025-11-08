import java.util.*;
import java.io.*;

public class Bank implements HasMenu {

    private Admin admin;
    private CustomerList customers;
    private Scanner input = new Scanner(System.in);
    private Customer currentCustomer;

    private static final String DATA_FILE = "customers.dat";
}

public Bank() {
    admin = new Admin();
    loadSampleCustomers();
    saveCustomers();
    loadCustomers();  
    start();    
    saveCustomers(); 
}

public void menu() {
    System.out.println("\nBank Menu");
    System.out.println("0) Exit system\n1) Login as admin\n2) Login as customer");
}

public void start() {
    String choice;
    boolean keepGoing;
    while(keepGoing = true){
        menu();
        choice = input.nextLine();

        if(choice.equals("0"){
                System.out.println("Exiting system");
                keepGoing = false;
	}else if(choice.equals("1"){
                if (admin.login()) startAdmin();
                keepGoing = false;
	}else if(choice.equals("2"){
                loginCustomer();
                keepGoing =false;
        }else{:
                System.out.println("Invalid selection");
        }
    }
}

public void startAdmin() {
    String choice;
    keepGoing = true;
    while keepGoing = true{
        admin.menu();
        choice = input.nextLine();

        if(choice.equals("0"){
                keepGoing = false;
        }else if(choice.equals("1"){
                fullCustomerReport();
        	keepGoing = false;
        }else if(choice.equals("2"){
                addUser();
                keepGoing = false;
        }else if(choice.equals("3"){
                applyInterest();
                keepGoing = false;
        }else{
                System.out.println("Invalid selection.");
        }
    } 
}

public void fullCustomerReport() {
    System.out.println("Full customer report: ");
    for (Customer c : customers) {
        System.out.println(c.getReport());
    }
}

public void addUser() {
    System.out.print("Name: ");
    String name = input.nextLine();
    System.out.print("PIN: ");
    String pin = input.nextLine();

    Customer newCustomer = new Customer(name, pin);
    customers.add(newCustomer);
    System.out.println("User added: " + name);
}

public void applyInterest() {
    System.out.println("Applying interest:");
    for (Customer c : customers) {
        c.getSavings().calcInterest();
        System.out.println("New balance for " + c.getUserName() + ": " + c.getSavings().getBalance());
    }
}

public void loginCustomer() {
    System.out.print("enter username: ");
    String name = input.nextLine();
    System.out.print("enter PIN: ");
    String pin = input.nextLine();

    currentCustomer = null;
    for (Customer c : customers) {
        if (c.getUserName().equals(name) && c.checkPIN(pin)) {
            currentCustomer = c;
        }
    }

    if (currentCustomer != null) {
        currentCustomer.start();
    } else {
        System.out.println("Login failed.");
    }
}

public void saveCustomers() {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
        out.writeObject(customers);
    } catch (IOException e) {
        System.out.println("Error saving customer data: " + e.getMessage());
    }
}

public void loadCustomers() {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
        customers = (CustomerList) in.readObject();
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("No existing data found loading sample customers");
        loadSampleCustomers();
    }
}
