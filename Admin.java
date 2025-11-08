import java.io.Serializable;

public class Admin extends User implements HasMenu, Serializable {

    public Admin() {
        super("admin", "0000");
    }

    public void start() {
    }

    public void menu() {
        System.out.println("\nAdmin Menu");
        System.out.println("0) Exit this menu\n1) Full Customer Support\n2) Add User\n3) Apply intertest to savings accounts");
    }

    public String getReport() {
        return "Admin: " + getUserName() + ", PIN: " + getPIN();
    }
}
