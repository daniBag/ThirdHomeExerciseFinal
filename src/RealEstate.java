import java.util.Scanner;
import java.util.regex.Pattern;

public class RealEstate {
    private User[] users;
    private City[] cities;
    private Property[] properties;

    private boolean existingUserName(String userName){
        boolean exists = true;
        for (int i = 0; i < users.length; i++){
            if (users[i].getUserName().equals(userName)){
                exists = false;
                break;
            }
        }
        return exists;
    }
    private boolean checkIfContains(String check, String contains) {
        boolean isContaining = false;
        for (int i = 0; i < check.length(); i++) {
            if (contains.contains(check.charAt(i) + "")) {
                isContaining = true;
                break;
            }
        }
        return isContaining;
    }
    private boolean passwordValidation(String password){
        boolean strong = false;
        String digits = "0123456789";
        String spacialSymbol = "$%_";
        if (password.length() >= 5){
            if (checkIfContains(password, spacialSymbol)){
                if (checkIfContains(password, digits)) {
                    strong = true;
                }
            }
        }
        return strong;
    }
    private boolean phoneNumberValidating (String phoneNumber){
        boolean valid = false;
        if (Pattern.matches("^(\\d{10})$", phoneNumber)){
            valid = Pattern.matches("^05.*", phoneNumber);
        }
        return valid;
    }
    private void addUserToUsersArray (User user){
        User[] usersTemp = new User[users.length + 1];
        for (int i = 0; i < users.length; i++){
            usersTemp[i] = users[i];
        }
        usersTemp[users.length] = user;
        users = usersTemp;
    }
    public void createUser(){
        Scanner scanner = new Scanner(System.in);
        String userName;
        String password;
        String phoneNumber;
        boolean relator = false;
        boolean accepted;
        System.out.println("Please enter your user name: ");
        do{
            userName = scanner.nextLine();
            accepted = !existingUserName(userName);
            if (!accepted){
                System.out.println("This user name is already taken, please choose another one: ");
            }
        }while (!accepted);
        System.out.println("Please enter a strong password. Use at least 5 chars 1 digit, 1 of the spacial symbols %, $ or _.");
        do{
            password = scanner.nextLine();
            accepted = passwordValidation(password);
            if (!accepted){
                System.out.println("Not strong enough, please try again: ");
            }
        }while (!accepted);
        System.out.println("Please enter your phone number: ");
        do{
            phoneNumber = scanner.nextLine();
            accepted = phoneNumberValidating(phoneNumber);
            if (!accepted){
                System.out.println("Make sure to enter in a 10 digits format (ex. 0512345678): ");
            }
        }while (!accepted);
        System.out.println("Choose your profile type: " + "\n" + "Insert 1 for relator." + "\n" + "Insert 2 for regular user.");
        float type;
        do{
            type = scanner.nextFloat();
            if (type == 1){
                relator = true;
            } else if (type == 2) {
                relator = false;
            }else{
                accepted = false;
                System.out.println("Make sure to insert your selection- 1 or 2.");
            }
        }while (!accepted);
        User user = new User(userName, password, phoneNumber, relator);
        addUserToUsersArray(user);
    }
    public User userLogin() {
        Scanner scanner = new Scanner(System.in);
        String userName;
        String password;
        System.out.println("enter your user name: ");
        userName = scanner.nextLine();
        System.out.println("enter your password: ");
        password = scanner.nextLine();
        boolean success = false;
        User current = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUserName().equals(userName)) {
                if (users[i].getPassword().equals(password)){
                    current = users[i];
                    break;
                }
            }
        }
        return current;
    }
}
