import java.util.Scanner;

public abstract class User implements HasMenu, Serializable{
	protected String userName;
	protected String PIN;

	public boolean login(){
		Scanner input = new Scanner(System.in);
        	System.out.print("Enter username: ");
        	String userN = input.nextLine();
        	System.out.print("Enter PIN: ");
        	String userP = input.nextLine();
        	return login(userN, userP);
	}

	public boolean login(String userName, String PIN){
		return this.equals(userName) && this.equals(PIN);
	}

    	public void setUserName(String userName){
	       	this.userName = userName;
       	}

   	public String getUserName(){
	       	return userName;
       }

    	public void setPIN(String PIN){
		this.PIN = PIN;
       	}
    	public String getPIN(){
	       return PIN;
       	}

    	public abstract String getReport();

}
