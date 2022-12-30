import java.util.Scanner;

public class Main {
    public static final int CREATE_USER = 1;
    public static final int USER_LOGIN = 2;
    public static final int END_SESSION = 3;
    public static final int POST_NEW_PROPERTY = 1;
    public static final int REMOVE_PROPERTY = 2;
    public static final int PRINT_ALL_PROPERTIES = 3;
    public static final int PRINT_USER_PROPERTIES = 4;
    public static final int SEARCH_PROPERTIES = 5;
    public static final int LOG_OUT_AND_RETURN = 6;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RealEstate realEstate = new RealEstate();
        int selection;
        boolean repeatMainMenu = false;
        boolean advance = false;
        User currentUser = new User();
        do {
            System.out.println("Please enter your selection:\n" +
                    "1- Create new account\n" +
                    "2-Login to existing account\n" +
                    "3- End session");
            selection = scanner.nextInt();
            if (selection == CREATE_USER){
                realEstate.createUser();
                repeatMainMenu = true;
            } else if (selection == USER_LOGIN) {
                currentUser = realEstate.userLogin();
                if (currentUser != null){
                    do {
                        System.out.println("Enter your selection: \n" +
                                "1. Post a new property.\n" +
                                "2. Remove a property.\n" +
                                "3. Print all properties in the system.\n" +
                                "4. Print your published properties.\n" +
                                "5. Search properties by filter.\n" +
                                "6. Log out and return to main menu.");
                        selection = scanner.nextInt();
                        switch (selection){
                            case POST_NEW_PROPERTY -> realEstate.postNewProperty(currentUser);
                            case REMOVE_PROPERTY -> realEstate.removeProperty(currentUser);
                            case PRINT_ALL_PROPERTIES -> realEstate.printAllProperties();
                            case PRINT_USER_PROPERTIES -> realEstate.printProperties(currentUser);
                            case SEARCH_PROPERTIES -> realEstate.search();
                            case LOG_OUT_AND_RETURN -> {
                                currentUser = new User();
                                advance = true;
                            }
                        }
                    }while (!advance);
                } else {
                    repeatMainMenu = true;
                    System.out.println("Incorrect username or password!");
                }
            } else if (selection == END_SESSION) {
                System.out.println("Have a nice day! :)");
            } else {
                repeatMainMenu = true;
                System.out.println("Invalid option, please choose between 1-3.");
            }
        }while (repeatMainMenu);

    }
}
