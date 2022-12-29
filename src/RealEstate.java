import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private City[] cities;
    private Property[] properties;
    public static final int IGNORE_SEARCH_PARAM = -999;
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
    private Object[] addObjectToArray(Object object, Object[] objects){
        Object[] objectsTemp = new Object[objects.length + 1];
        for (int i = 0; i < objects.length; i++){
            objectsTemp[i] = objects[i];
        }
        objectsTemp[objects.length] = object;
        return objectsTemp;
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
        this.users = (User[]) this.addObjectToArray(user, this.users);
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
                        float roomsAmount;
                        System.out.println("Please enter your property's rooms amount: ");
                        roomsAmount = scanner.nextFloat();
                        int houseNumber;
                        System.out.println("Please enter your property's house number: ");
                        houseNumber = scanner.nextInt();
                        int rentOrSale;
                        System.out.println("Is your property for rent? (1/2)\n" +
                                "For rent -> insert 1\n" +
                                "For sale -> insert 2");
                        rentOrSale = scanner.nextInt();
                        double price;
                        System.out.println("Enter your property's price please: ");
                        price = scanner.nextDouble();
                        property =new Property(currentCity, user, streetName, roomsAmount, price, propertyType, rentOrSale, houseNumber, floor);
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
                        while (property.getRentOrSale()==null){
                            System.out.println("Invalid status: \n" +
                                    "For rent -> insert 1\n" +
                                    "For sale -> insert 2");
                            rentOrSale = scanner.nextInt();
                        }
                        while (property.getPrice()==null){
                            System.out.println("Invalid price. Please try again");
                        }
                        this.properties = (Property[]) this.addObjectToArray(property,this.properties);
                        published = true;
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
                System.out.println("*********");
            }
        }
    }
    public Property[] search (){
        Property[] searchResults = new Property[0];
        if (this.properties.length > 0){
            Property current = new Property();
            Scanner scanner = new Scanner(System.in);
            System.out.println("At any one of the parameters you can enter -999 to not filter by this parameter.");
            int rentOrSale;
            do {
                System.out.println("Please enter 1 if for rent or 2 for sale:");
                rentOrSale = scanner.nextInt();
            }while (!current.validateRentOrSale(rentOrSale) && rentOrSale != IGNORE_SEARCH_PARAM);
            int propertyType;
            do {
                System.out.println("Please enter your property type:\n" +
                        "1- An apartment in a building\n" +
                        "2- A penthouse in a building\n" +
                        "3- A Cottage");
                propertyType = scanner.nextInt();
            }while (!current.validatePropertyType(propertyType) && propertyType != IGNORE_SEARCH_PARAM);
            float rooms;
            do {
                System.out.println("Please enter rooms amount");
                rooms = scanner.nextInt();
            }while (!current.validateRoomsAmount(rooms) && rooms != IGNORE_SEARCH_PARAM);
            double minPrice;
            double maxPrice;
            do {
                System.out.println("Enter min price: ");
                minPrice = scanner.nextDouble();
                System.out.println("Enter max price: ");
                maxPrice = scanner.nextDouble();
            }while ((!current.validatePrice(minPrice) && minPrice != IGNORE_SEARCH_PARAM)
                    || (!current.validatePrice(maxPrice) && maxPrice != IGNORE_SEARCH_PARAM) || minPrice > maxPrice);
            int fittingCounter = 0;
            for (int i = 0; i < this.properties.length; i++){
                current = this.properties[i];
                if (current.getRentOrSale().equals(rentOrSale) || rentOrSale == IGNORE_SEARCH_PARAM){
                    if (current.getPropertyType().equals(propertyType) || propertyType == IGNORE_SEARCH_PARAM){
                        if (current.getRoomsAmount().equals(rooms) || rooms == IGNORE_SEARCH_PARAM){
                            if (maxPrice == IGNORE_SEARCH_PARAM && current.getPrice() >= minPrice){
                                fittingCounter++;
                            }else if (current.getPrice() >= minPrice && current.getPrice() <= maxPrice){
                                fittingCounter++;
                            } else if (maxPrice == IGNORE_SEARCH_PARAM && minPrice == IGNORE_SEARCH_PARAM) {
                                fittingCounter++;
                            }
                        }
                    }
                }
            }
            searchResults = new Property[fittingCounter];
            fittingCounter = 0;
            for (int i = 0; i < this.properties.length; i++){
                current = this.properties[i];
                if (current.getRentOrSale().equals(rentOrSale) || rentOrSale == IGNORE_SEARCH_PARAM){
                    if (current.getPropertyType().equals(propertyType) || propertyType == IGNORE_SEARCH_PARAM){
                        if (current.getRoomsAmount().equals(rooms) || rooms == IGNORE_SEARCH_PARAM){
                            if (maxPrice == IGNORE_SEARCH_PARAM && current.getPrice() >= minPrice){
                                searchResults[fittingCounter] = this.properties[i];
                                fittingCounter++;
                            }else if (current.getPrice() >= minPrice && current.getPrice() <= maxPrice){
                                searchResults[fittingCounter] = this.properties[i];
                                fittingCounter++;
                            } else if (maxPrice == IGNORE_SEARCH_PARAM && minPrice == IGNORE_SEARCH_PARAM) {
                                searchResults[fittingCounter] = this.properties[i];
                                fittingCounter++;
                            }
                        }
                    }
                }
            }
        }
        return searchResults;
    }
    public void removeProperty (User user){
        Scanner scanner = new Scanner(System.in);
        int propertiesCounter = 0;
        for (int i = 0; i < this.properties.length; i++){
            if (this.properties[i].getUser().equals(user)){
                propertiesCounter++;
            }
        }
        if (propertiesCounter == 0){
            System.out.println("Lo hedpasta af neches ya manyak");
        }else{
            Property[] userProperties = new Property[propertiesCounter];
            propertiesCounter = 0;
            for (int i = 0; i < this.properties.length; i++){
                if (this.properties[i].getUser().equals(user)) {
                    userProperties[propertiesCounter] = this.properties[i];
                    propertiesCounter++;
                    System.out.println((propertiesCounter + 1) + ". " + this.properties[i]);
                }
            }
            System.out.println("Please enter which property would you like to remove: ");
            int toRemove;
            boolean inputValid;
            do {
                toRemove = scanner.nextInt();
                if (toRemove < 0 || toRemove > propertiesCounter){
                    System.out.println("Yeled hara. tachnis kelet normalli");
                    inputValid = false;
                }else {
                    inputValid = true;
                }
            }while (!inputValid);
            Property[] temp = new Property[this.properties.length - 1];
            propertiesCounter = 0;
            for (int i = 0; i < this.properties.length; i++){
                if (this.properties[i].equals(userProperties[toRemove])){
                    continue;
                }
                temp[propertiesCounter] = this.properties[i];
                propertiesCounter++;
            }
            this.properties = temp;
            System.out.println("The requested property was removed successfully.");
        }
    }

}
