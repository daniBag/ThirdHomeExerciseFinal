import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private City[] cities;
    private Property[] properties;
    //O(1)
    public RealEstate(){
        this.cities = new City[]{
                new City("Eilat", Constants.NEGEV_DISTRICT, Constants.EILAT_STREETS),
                new City("Beer Sheva", 1, Constants.BEER_SHEVA_STREETS),
                new City("Mitzpe Ramon", 1, Constants.MITZPE_RAMON_STREETS),
                new City("Kiryat Gat", 2, Constants.KIRYAT_GAT_STREETS),
                new City("Beit Shemesh", 2, Constants.BEIT_SHEMESH_STREETS),
                new City("Modiin", 3, Constants.MODIIN_STREETS),
                new City("Holon", 3, Constants.HOLON_STREETS),
                new City("Hod HaSharon", 4, Constants.HOD_HASHRON_STREETS),
                new City("Tveria", 5, Constants.TVERIA_STREETS),
                new City("Kiryat Shmona", 5, Constants.KIRYAT_SHMONA_STREETS)
        };
        this.users = new User[Constants.INITIALIZING_SIZE];
        this.properties = new Property[Constants.INITIALIZING_SIZE];
    }
    //O(n)
    private boolean existingUserName(String userName){
        boolean exists = false;
        if (this.users != null){
            for (int i = 0; i < this.users.length; i++){
                if (this.users[i].getUserName().equals(userName)){
                    exists = true;
                    break;
                }
            }
        }
        return exists;
    }
    //O(n)
    private User[] addUserToArray(User userToAdd){
        User[] usersUpdated;
        if (this.users == null) {
            usersUpdated = new User[1];
        }else {
            usersUpdated = new User[this.users.length + 1];
            for (int i = 0; i < this.users.length; i++){
                usersUpdated[i] = this.users[i];
            }
        }
        usersUpdated[usersUpdated.length-1] = userToAdd;
        return usersUpdated;
    }
    //O(1)
    private Property[] addPropertyToArray(Property propertyToAdd) {
        Property[] propertiesUpdated;
        if (this.properties == null) {
            propertiesUpdated = new Property[1];
        } else {
            propertiesUpdated = new Property[this.properties.length + 1];
            for (int i = 0; i < this.properties.length; i++) {
                propertiesUpdated[i] = this.properties[i];
            }
        }
        propertiesUpdated[propertiesUpdated.length - 1] = propertyToAdd;
        return propertiesUpdated;
    }
    //O(n)
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
            if (userType == Constants.RELATOR){
                relator = true;
            } else if (userType == Constants.REGULAR) {
                relator = false;
            }else{
                accepted = false;
                System.out.println("Make sure to insert your selection- 1 or 2.");
            }
        }while (!accepted);
        User user = new User(userName, password, phoneNumber, relator);
        while (user.getPassword() == null){
            System.out.println("You're password isn't strong enough, please try again: ");
            password = scanner.next();
            user.setPassword(password);
        }
        while (user.getPhoneNumber() == null){
            System.out.println("Make sure to enter your phone number in a 10 digits format (ex. 0512345678): ");
            phoneNumber = scanner.next();
            user.setPhoneNumber(phoneNumber);
        }
        this.users = this.addUserToArray(user);
        System.out.println("New user was created successfully.");
    }
    //O(n)
    public User userLogin() {
        Scanner scanner = new Scanner(System.in);
        String userName;
        String password;
        System.out.println("enter your user name: ");
        userName = scanner.nextLine();
        System.out.println("enter your password: ");
        password = scanner.nextLine();
        User current = null;
        if (this.users.length > 0){
            for (int i = 0; i < this.users.length; i++) {
                if (this.users[i].getUserName().equals(userName)) {
                    if (this.users[i].getPassword().equals(password)){
                        current = this.users[i];
                        break;
                    }
                }
            }
        }
        return current;
    }
    //O(n)
    private boolean checkIfPassedPostingLimit (User user){
        boolean passedLimit = false;
        int publishedCounter = 0;
        boolean relator = user.isRelator();
        if (this.properties.length > 0)
        for (int i = 0; i < properties.length; i++){
            if (properties[i].getUser().equals(user)){
                publishedCounter++;
                if (relator){
                    if (publishedCounter == Constants.RELATOR_MAX_POST){
                        passedLimit = true;
                        break;
                    }
                } else {
                    if (publishedCounter == Constants.REGULAR_MAX_POST){
                        passedLimit = true;
                        break;
                    }
                }
            }
        }
        return passedLimit;
    }
    //O(n)
    private void printCitiesList (){
        for (int i = 0; i < this.cities.length; i++){
            System.out.println(cities[i].getName());
        }
    }
    //O(n)
    private City checkValidCity(String cityName){
        City current = null;
        for (int i = 0; i < this.cities.length; i++){
            if (this.cities[i].getName().equals(cityName)){
                current = this.cities[i];
                break;
            }
        }
        return current;
    }//O(n)
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
                        Integer floor = Constants.IGNORE;
                        if (propertyType.equals(Constants.REGULAR_APARTMENT) || propertyType.equals(Constants.PENTHOUSE_APARTMENT)){
                            System.out.println("Please enter the floor of the property: ");
                            floor = scanner.nextInt();
                        }
                        int roomsAmount;
                        System.out.println("Please enter your property's rooms amount: ");
                        roomsAmount = scanner.nextInt();
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
                        if (propertyType != Constants.COTTAGE){
                            while (property.getFloor() == null){
                                System.out.println("Invalid floor number, please try again: ");
                                floor = scanner.nextInt();
                                property.setFloor(floor);
                            }
                        }
                        while (property.getRoomsAmount() == null){
                            System.out.println("Invalid rooms amount, please try again: ");
                            roomsAmount = scanner.nextInt();
                            property.setRoomsAmount(roomsAmount);
                        }
                        while (property.getHouseNumber() == null){
                            System.out.println("Invalid house number, please try again:");
                            houseNumber = scanner.nextInt();
                            property.setHouseNumber(houseNumber);
                        }
                        while (property.getRentOrSale() == null){
                            System.out.println("Invalid status: \n" +
                                    "For rent -> insert 1\n" +
                                    "For sale -> insert 2");
                            rentOrSale = scanner.nextInt();
                            property.setRentOrSale(rentOrSale);
                        }
                        while (property.getPrice() == null){
                            System.out.println("Invalid price. Please try again");
                            price = scanner.nextDouble();
                            property.setPrice(price);
                        }
                        this.properties = this.addPropertyToArray(property);
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
    //O(n)
    public void printAllProperties(){
        int printedCounter = 0;
        if (this.properties != null){
            for (int i = 0; i < properties.length; i++){
                System.out.print((i+1) + ". ");
                System.out.println(properties[i]);
                System.out.println("*********");
                printedCounter++;
            }
        }
        if (printedCounter == 0){
            System.out.println("There are no properties to show.");
        }
    }
    //O(n)
    public void printPropertiesFromArray(Property[] properties){
        int printedCounter = 0;
        if (properties == null) {
            if (this.properties != null){
                properties = this.properties;
            }else {
                System.out.println("There are no properties to show.");
            }
        }
        for (int i = 0; i < properties.length; i++){
            System.out.print((i+1) + ". ");
            System.out.println(properties[i]);
            System.out.println("*********");
            printedCounter++;
        }
        if (printedCounter == 0){
            System.out.println("There are no properties to show.");
        }
    }
    //O(n)
    public void printProperties (User user){
        int printedCounter = 0;
        if (this.properties != null){
            for (int i=0; i<this.properties.length; i++){
                if (this.properties[i].getUser().equals(user)){
                    System.out.println(properties[i]);
                    System.out.println("*********");
                    printedCounter++;
                }
            }
        }else {
            System.out.println("There are no properties to show.");
        }
        if (printedCounter == 0){
            System.out.println("There are no properties to show.");
        }
    }
    //O(n)
    private QueryUtility searchQueryBuilder (){
        QueryUtility query = new QueryUtility();
        Scanner scanner = new Scanner(System.in);
        System.out.println("At any one of the parameters you can enter -999 to not filter by this parameter.");
        boolean inputOk = false;
        int rentOrSale;
        do {
            System.out.println("Please enter 1 if for rent or 2 for sale:");
            rentOrSale = scanner.nextInt();
            if (rentOrSale == Constants.IGNORE){
                inputOk = true;
            }else{
                query.setRentOrSale(rentOrSale);
                if (query.getRentOrSale() != null){
                    inputOk = true;
                }
            }
        }while (!inputOk);
        int propertyType;
        inputOk = false;
        do {
            System.out.println("Please enter your property type:\n" +
                    "1- An apartment in a building\n" +
                    "2- A penthouse in a building\n" +
                    "3- A Cottage");
            propertyType = scanner.nextInt();
            if (propertyType == Constants.IGNORE){
                inputOk = true;
            }else{
                query.setPropertyType(propertyType);
                if (query.getPropertyType() != null){
                    inputOk = true;
                }
            }
        }while (!inputOk);
        int rooms;
        inputOk = false;
        do {
            System.out.println("Please enter rooms amount");
            rooms = scanner.nextInt();
            if (rooms == Constants.IGNORE){
                inputOk = true;
            }else{
                query.setRoomsAmount(rooms);
                if (query.getRoomsAmount() != null){
                    inputOk = true;
                }
            }
        }while (!inputOk);
        double minPrice;
        double maxPrice;
        inputOk = false;
        do {
            System.out.println("Enter min price: ");
            minPrice = scanner.nextDouble();
            System.out.println("Enter max price: ");
            maxPrice = scanner.nextDouble();
            if (minPrice == Constants.IGNORE && maxPrice == Constants.IGNORE){
                inputOk = true;
            }else if (minPrice == Constants.IGNORE){
                query.setMaxPrice(maxPrice);
                if (query.getMaxPrice() != null){
                    inputOk = true;
                }
            }else if (maxPrice == Constants.IGNORE) {
                query.setMinPrice(minPrice);
                if (query.getMinPrice() != null) {
                    inputOk = true;
                }
            }else{
                query.setMaxPrice(maxPrice);
                query.setMinPrice(minPrice);
                if (query.getMinPrice() != null && query.getMaxPrice() != null && query.getMinPrice() <= query.getMaxPrice()) {
                    inputOk = true;
                }
            }
        }while (!inputOk);
        return query;
    }
    //O(n)
    private Property[] searchByQuery (QueryUtility query){
        Property current = new Property();
        int fittingCounter = 0;
        Integer rentOrSale = null;
        Integer propertyType = null;
        Integer rooms = null;
        Double minPrice = null;
        Double maxPrice = null;
        User user = query.getUser();
        if (user == null){
            rentOrSale = query.getRentOrSale();
            propertyType = query.getPropertyType();
            rooms = query.getRoomsAmount();
            minPrice = query.getMinPrice();
            maxPrice = query.getMaxPrice();
        }
        for (int i = 0; i < this.properties.length; i++){
            current = this.properties[i];
            if (user == null) {
                if (current.getRentOrSale().equals(rentOrSale) || rentOrSale == null){
                    if (current.getPropertyType().equals(propertyType) || propertyType == null){
                        if (current.getRoomsAmount().equals(rooms) || rooms == null){
                            if ((maxPrice == null && minPrice == null) || (minPrice == null && current.getPrice() <= maxPrice)
                                    ||(maxPrice == null && current.getPrice() >= minPrice)
                                    || (current.getPrice() >= minPrice && current.getPrice() <= maxPrice)) {
                                fittingCounter++;
                            }
                        }
                    }
                }
            }else{
                if (current.getUser() == user){
                    fittingCounter++;
                }
            }
        }
        Property[] searchResults = new Property[fittingCounter];
        fittingCounter = 0;
        for (int i = 0; i < this.properties.length; i++){
            current = this.properties[i];
            if (user == null) {
                if (current.getRentOrSale().equals(rentOrSale) || rentOrSale == null){
                    if (current.getPropertyType().equals(propertyType) || propertyType == null){
                        if (current.getRoomsAmount().equals(rooms) || rooms == null){
                            if ((maxPrice == null && minPrice == null) || (minPrice == null && current.getPrice() <= maxPrice)
                                    ||(maxPrice == null && current.getPrice() >= minPrice)
                                    || (current.getPrice() >= minPrice && current.getPrice() <= maxPrice)) {
                                searchResults[fittingCounter] = this.properties[i];
                                fittingCounter++;
                            }
                        }
                    }
                }
            }else{
                if (current.getUser() == user){
                    searchResults[fittingCounter] = this.properties[i];
                    fittingCounter++;
                }
            }
        }
        return searchResults;
    }//O(n)
    public Property[] search (){
        Property[] searchResults = null;
        if (this.properties.length > 0) {
            QueryUtility query = this.searchQueryBuilder();
             searchResults = this.searchByQuery(query);
        }
        return searchResults;
    }
    //O(n)
    public void removeProperty (User user){
        Scanner scanner = new Scanner(System.in);
        QueryUtility query = new QueryUtility();
        query.setUser(user);
        Property[] byUser = this.searchByQuery(query);
        this.printPropertiesFromArray(byUser);
        System.out.println("Please enter which property would you like to remove: ");
        int toRemove;
        boolean inputValid;
        do {
            toRemove = scanner.nextInt();
            if (toRemove < 0 || toRemove > byUser.length){
                System.out.println("Invalid property, please try again.");
                inputValid = false;
            }else {
                inputValid = true;
            }
        }while (!inputValid);
        Property[] temp = new Property[this.properties.length - 1];
        int propertiesCounter = 0;
        for (int i = 0; i < this.properties.length; i++){
            if (this.properties[i].equals(byUser[toRemove])){
                continue;
            }
            temp[propertiesCounter] = this.properties[i];
            propertiesCounter++;
        }
        this.properties = temp;
        System.out.println("The requested property has been successfully removed.");
    }
}

