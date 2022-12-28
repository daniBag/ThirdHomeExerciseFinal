import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RealEstate realEstate = new RealEstate();
        int selection;
        boolean repeatMainMenu = false;
        boolean advance = false;
        do {
            System.out.println("Please enter your selection:\n" +
                    "1- Create new account\n" +
                    "2-Login to existing account\n" +
                    "3- End session");
            selection = scanner.nextInt();
            if (selection == 1){
                realEstate.createUser();
            } else if (selection == 2) {
                User currentUser = realEstate.userLogin();
                if (currentUser != null){
                    advance = true;
                } else {
                    repeatMainMenu = true;
                    System.out.println("Incorrect username or password!");
                }
            } else if (selection == 3) {
                System.out.println("Have a nice day! :)");
            } else {
                repeatMainMenu = true;
                System.out.println("Invalid option, please choose between 1-3.");
            }
        }while (repeatMainMenu);

    }
}
