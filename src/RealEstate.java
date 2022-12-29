import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private City[] cities;
    private Property[] properties;
    public RealEstate(){}

    private boolean existingUserName(String userName){
        boolean exists = false;
        for (int i = 0; i < users.length; i++){
            if (users[i].getUserName().equals(userName)){
                exists = true;
                break;
            }
        }
        return exists;
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
        password = scanner.nextLine();
        System.out.println("Please enter your phone number: ");
        phoneNumber = scanner.nextLine();
        System.out.println("Choose your profile type: " + "\n" + "Insert 1 for relator." + "\n" + "Insert 2 for regular user.");
        int userType;
        do{
            userType = scanner.nextInt();
            if (userType == 1){
                relator = true;
            } else if (userType == 2) {
                relator = false;
            }else{
                accepted = false;
                System.out.println("Make sure to insert your selection- 1 or 2.");
            }
        }while (!accepted);
        User user = new User(userName, password, phoneNumber, relator);
        while (user.getPassword() == null){
            System.out.println("You're password isn't strong enough, please try again: ");
            password = scanner.nextLine();
            user.setPassword(password);
        }
        while (user.getPhoneNumber() == null){
            System.out.println("Make sure to enter your phone number in a 10 digits format (ex. 0512345678): ");
            phoneNumber = scanner.nextLine();
            user.setPhoneNumber(phoneNumber);
        }
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
    private boolean checkIfPassedPostingLimit (User user){
        boolean passedLimit = false;
        int publishedCounter = 0;
        boolean relator = user.isRelator();
        for (int i = 0; i < properties.length; i++){
            if (properties[i].getUser().equals(user)){
                publishedCounter++;
                if (relator){
                    if (publishedCounter == 5){
                        passedLimit = true;
                        break;
                    }
                } else {
                    if (publishedCounter == 2){
                        passedLimit = true;
                        break;
                    }
                }
            }
        }
        return passedLimit;
    }
    private void printCitiesList (){
        for (int i = 0; i < this.cities.length; i++){
            System.out.println(cities[i].getName());
        }
    }

    private City checkValidCity(String cityName){
        City current = null;
        for (int i = 0; i < this.cities.length; i++){
            if (this.cities[i].getName().equals(cityName)){
                current = this.cities[i];
                break;
            }
        }
        return current;
    }
    private boolean validateIfForRent (String isForRent){
        boolean valid = false;
        if (isForRent != null){
            if (isForRent.equals("y") || isForRent.equals("n")){
                valid = true;
            }
        }
        return valid;
    }
    public boolean postNewProperty (User user){
        Scanner scanner = new Scanner(System.in);
        boolean published = false;
        Property property = new Property();
        if (!this.checkIfPassedPostingLimit(user)){
            this.printCitiesList();
            System.out.println("Enter the exact name of the city: ");
            String cityName = scanner.nextLine();
            City currentCity = this.checkValidCity(cityName);
            if (currentCity != null){
                currentCity.printStreetList();
                System.out.println("Enter the exact name of the street: ");
                String streetName = scanner.nextLine();
                if (currentCity.isValidStreet(streetName)){
                    System.out.println("Please enter your property type:\n" +
                            "1- An apartment in a building\n" +
                            "2- A penthouse in a building\n" +
                            "3- A Cottage");
                    boolean inputValid;
                    Integer propertyType;
                    propertyType = scanner.nextInt();
                    inputValid = property.validatePropertyType(propertyType);
                    if (inputValid){
                        Integer floor = null;
                        if (propertyType.equals(property.REGULAR_APARTMENT) || propertyType.equals(property.PENTHOUSE_APARTMENT)){
                            System.out.println("Please enter the floor of the property: ");
                            floor = scanner.nextInt();
                        }
                        Float roomsAmount;
                        System.out.println("Please enter your property's rooms amount: ");
                        roomsAmount = scanner.nextFloat();
                        int houseNumber;
                        System.out.println("Please enter your property's house number: ");
                        houseNumber = scanner.nextInt();
                        Integer forRent;
                        System.out.println("Is your property for rent? (1/2)\n" +
                                "For rent -> insert 1\n" +
                                "For sale -> insert 2");
                        forRent = scanner.nextInt();
                        /*if (!inputValid){
                            System.out.println("Invalid selection, please insert y/n.");
                        }
                    }while (!inputValid);*/

                        double price;
                        System.out.println("Enter your property's price please: ");
                        price = scanner.nextDouble();
                        /*if (!inputValid){
                            System.out.println("Invalid, please enter again: ");
                        }
                    }while (!inputValid);*/
                        property =new Property(currentCity, user, streetName, roomsAmount, price, propertyType, forRent, houseNumber, floor);
                        if (propertyType!=property.COTTAGE){
                            while (property.getFloor()==null){
                                System.out.println("Invalid floor number, please try again: ");
                                floor = scanner.nextInt();
                                property.setFloor(floor);
                            }
                        }
                        while (property.getRoomsAmount()==null){
                            System.out.println("Invalid rooms amount, please try again: ");
                            roomsAmount = scanner.nextFloat();
                            property.setRoomsAmount(roomsAmount);
                        }
                        while (property.getHouseNumber()==null){
                            System.out.println("Invalid house number, please try again:");
                            houseNumber = scanner.nextInt();
                            property.setHouseNumber(houseNumber);
                        }
                    inputValid=property.validatePropertyType(propertyType);
                    }else {
                        System.out.println(propertyType + " is an invalid input.");
                    }
                } else{
                    System.out.println(streetName + " is not a street in this city.");
                }
            } else {
                System.out.println(cityName + " is not a city in the system.");
            }
        }else{
            System.out.println("ERROR! you have passed your properties publishing limit.");
        }
        return published;
    }

    public void printAllProperties(){
        for (int i=0; i<this.properties.length; i++){
            System.out.println(this.properties[i]);
        }
    }
    public void printProperties (User user){
        for (int i=0; i<this.properties.length; i++){
            if (this.properties[i].getUser().equals(user)){
                System.out.println(properties[i]);
            }
        }
    }
    public Property[] search (){
        int forRent;
        int propertyType;
        float rooms;
        double minPrice;
        double maxPrice;
        int counter;
        for ()
    }
}
