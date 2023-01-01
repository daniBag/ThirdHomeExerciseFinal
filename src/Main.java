import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RealEstate realEstate = new RealEstate();
        int selection;
        boolean repeatMainMenu = false;
        boolean advance = false;
        User currentUser;
        do {
            System.out.println("Please enter your selection:\n" +
                    "1- Create new account\n" +
                    "2-Login to existing account\n" +
                    "3- End session");
            selection = scanner.nextInt();
            if (selection == Constants.CREATE_USER){
                realEstate.createUser();
                repeatMainMenu = true;
            } else if (selection == Constants.USER_LOGIN) {
                currentUser = realEstate.userLogin();
                if (currentUser != null){
                    System.out.println("Successful login!");
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
                            case Constants.POST_NEW_PROPERTY -> {if (realEstate.postNewProperty(currentUser)){
                                    System.out.println("A new property was successfully posted.");
                                }else{
                                System.out.println("New property posting failed.");
                                }
                            }
                            case Constants.REMOVE_PROPERTY -> realEstate.removeProperty(currentUser);
                            case Constants.PRINT_ALL_PROPERTIES -> realEstate.printAllProperties();
                            case Constants.PRINT_USER_PROPERTIES -> realEstate.printProperties(currentUser);
                            case Constants.SEARCH_PROPERTIES -> {
                                Property[] searchResults = realEstate.search();
                                realEstate.printPropertiesFromArray(searchResults);
                            }
                            case Constants.LOG_OUT_AND_RETURN -> {
                                currentUser = new User();
                                advance = true;
                            }
                        }
                    }while (!advance);
                } else {
                    repeatMainMenu = true;
                    System.out.println("Incorrect username or password!");
                    System.out.println("---------------------------------");
                }
            } else if (selection == Constants.END_SESSION) {
                System.out.println("Have a nice day! :)");
                repeatMainMenu =false;
            } else {
                repeatMainMenu = true;
                System.out.println("Invalid option, please choose between 1-3.");
            }
        }while (repeatMainMenu);

    }
}
