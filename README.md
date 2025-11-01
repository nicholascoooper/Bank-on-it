```mermaid

classDiagram

	class CheckingAccount{
	    -balance: double
		+CheckingAccount()
		+CheckingAccount(balance)
		+main(): void
		+menu(): String
		+start(): String
		+getBalance() double
		+getBalanceString() String
		+setBalance(balance): void
		-getDouble(): double
		+makeDeposit(): void
		+makeWithdrawl(): void
	}

    class HasMenu{
        <<interface>>
        +menu(): String
        +start(): void
    }
    
    class SavingsAccount{
        -interestRate: double
        +main(*)
        +calcInterest: void
        +setInterestRate: void
        +getInterestRate: void
    }    
    
	class Customer{
        -checking: CheckingAccount
        -savings: SavingsAccount
        +main(): void
        +Customer()
        +start(): void
        +menu(): void
        +changePIN(): string
        +getReport(): String
    }

    class User{
        <<abstract>>
        -userName: String
        -PIN: String
        +login(): boolean 
        +login(userName, PIN): booleon
        +setUserName(userName): void
        +getUserName(): String
        +setPIN(PIN): void
        +getPIN(): String
        +getReport(): (abstract)String
    }
    
    CheckingAccount <|-- SavingsAccount
    User <|-- Customer
    HasMenu <.. User
    HasMenu <.. CheckingAccount
    
```

HasMenu
interface HasMenu 
  ====================
  ====================
  string menu()
  void start()


CheckingAccount
class CheckingAccount implements HasMenu
  ====================
    double balance
  ====================
    CheckingAccount(){
    balance = 0.0

    CheckingAccount(double balance){
    balance = balance

    main(){
    new CheckingAccount

    string menu(){
    print options 
    input option

    void start(){
    while bool keepgoing
    if 0
        false
    else 1
        checkBalaance
    else 2
        makedeposit
    else 3
        makewithdrawl
    else
        print invalid        
   
    double getBalance(){
        return balance

    string getBalanceString(){
        return string format balance

    void setBalance(double balance){
        balnace = balance

    void checkBalance(){
        print balance

    private double getDouble(){
        try double parsedouble input
        exception print invalid return 0

    void makeDeposit(){
        print enter deposit amount
        double  input
        if input > 0
            balance + depo amount
        else
            print invalid
        
    void makeWithdrawal(){
        print enter withdrawl amount
        double input
        if input > 0 and < balance
            balance - input
        else
            print invalid
            
  ====================


SavingsAccount
class SavingsAccount extends CheckingAccount
  ====================
    double interestRate
  ====================
    main()
    calcInterest(){
        double interest =getBalance * intrestrate
        setbalnce (getbalnce + interest)

    void setInterestRate(intrate){
        interestrate = intrate

    double getInterestRate(){
        return intrestRate
  ====================


User
abstract class User implements HasMenu, Serializable
  ====================
    string userName
    string PIN
  ====================
    boolean login(){
        print enter username
        input username
        print enter pin
        input pin
        return username, pin

    boolean login(userName, PIN){
        return this,equals username and this = pin

    void setUserName(userName){
        this.unsername - username

    string getUserName(){
        return username
    
    void setPIN(PIN)[
        this.pin = pin

    string getPIN(){
        return pin
    
    abstract string getReport(){
        

  ====================


Customer
class Customer extends User
  ====================
    CheckingAccount checking 
    SavingsAccount savings 
  ====================
    void main(){
        customer testciustomer = new customer alice 0000

    Customer(){
        alice, 0000
    
    Customer(usernName, PIN)[
    this username = useraname
    this.pin = pin
    this.checking=new checkingaccount
    this.savings=new savingsaccount

    void start(){
        while keepgoing
            menu()
        
    string menu()
        print menu options 
            if 0
                keepgoing false
            else if 1
                checking.start
            else if 2
                savings.start
            else if 3
                changepin()
            else
                print invalid 

    void changePin(){
        print enter new pin
        input PIN
        print pin successfully changes
        

    string getReport(){
        print customer username
        print checking balance
        print savings balance:

  ====================

