public class Property {
    private City city;
    private User user;
    private String street;
    private Integer roomsAmount;
    private Double price;
    private Integer propertyType;
    private Integer rentOrSale;
    private Integer houseNumber;
    private Integer floor;
    //O(1)
    public Property(){}
    //O(1)
    public Property(City city, User user, String street,
                    Integer roomsAmount, double price,
                    Integer propertyType, Integer forRent,
                    int houseNumber, int floor) {
        this.city = city;
        this.user = user;
        this.street = street;
        if (this.validatePropertyType(propertyType)){
            this.propertyType = propertyType;
        }
        if (this.validateRoomsAmount(roomsAmount)){
            this.roomsAmount = roomsAmount;
        }
        if (this.validatePrice(price)){
            this.price = price;
        }
        if (this.validateRentOrSale(forRent)){
            this.rentOrSale = forRent;
           }
        if (this.validateHouseNumber(houseNumber)){
            this.houseNumber = houseNumber;
        }
        if (this.validateFloor(floor)){
            this.floor = floor;
        }
    }
    //O(1)
    public boolean validatePrice (double price){
        boolean valid = false;
        if (price >=0){
            valid = true;
        }
        return valid;
    }
    //O(1)
    public boolean validateFloor (int floor){
        boolean valid = false;
        if (floor >= Constants.BASEMENT_FLOOR){
            valid = true;
        }
        return valid;
    }
    //O(1)
    public boolean validateHouseNumber (Integer houseNumber){
        boolean valid = false;
        if (houseNumber >= Constants.MIN_HOUSE_NUMBER){
            valid = true;
        }
        return valid;
    }
    //O(1)
    public boolean validateRoomsAmount(int roomsAmount){
        boolean valid = false;
        if (roomsAmount >= Constants.MIN_ROOMS_NUMBER){
            valid = true;
        }
        return valid;
    }
    //O(1)
    public boolean validatePropertyType (Integer propertyType){
        boolean valid = false;
        if (propertyType == Constants.REGULAR_APARTMENT || propertyType == Constants.PENTHOUSE_APARTMENT || propertyType == Constants.COTTAGE){
            valid = true;
        }
        return valid;
    }
    //O(1)
    public boolean validateRentOrSale (Integer rentOrSale){
        boolean valid = false;
        if (rentOrSale != null){
            if (rentOrSale.equals(Constants.FOR_RENT) || rentOrSale.equals(Constants.FOR_SALE)){
                valid = true;
            }
        }
        return valid;
    }
    //O(1)
    public User getUser() {
        return user;
    }
    //O(1)
    public Integer getRoomsAmount() {
        return roomsAmount;
    }
    //O(1)
    public void setRoomsAmount(Integer roomsAmount) {
        if (this.validateRoomsAmount(roomsAmount)){
            this.roomsAmount = roomsAmount;
        }
    }
    //O(1)
    public Double getPrice() {
        return price;
    }
    //O(1)
    public void setPrice(Double price) {
        this.price = price;
    }
    //O(1)
    public Integer getPropertyType() {
        return propertyType;
    }
    //O(1)
    public void setPropertyType(Integer propertyType) {
        if (this.validatePropertyType(propertyType)){
            this.propertyType = propertyType;
        }
    }
    //O(1)
    public Integer getRentOrSale() {
        return rentOrSale;
    }
    //O(1)
    public void setRentOrSale(Integer forRent) {
        this.rentOrSale = forRent;
    }
    //O(1)
    public Integer getHouseNumber() {
        return houseNumber;
    }
    //O(1)
    public void setHouseNumber(Integer houseNumber) {
        if (this.validateHouseNumber(houseNumber)){
            this.houseNumber = houseNumber;
        }
    }
    //O(1)
    public Integer getFloor() {
        return floor;
    }
    //O(1)
    public void setFloor(Integer floor) {
        if (this.validateFloor(floor)){
            this.floor = floor;
        }
    }
    //O(1)
    public String toString (){
        String output = this.city.getName() + " " + this.street + " " + this.houseNumber + ".\n";
        switch (propertyType){
            case Constants.REGULAR_APARTMENT -> output += "Regular apartment - ";
            case Constants.PENTHOUSE_APARTMENT -> output += "Penthouse apartment - ";
            case Constants.COTTAGE -> output += "Cottage - ";
        }
        switch (this.rentOrSale){
            case Constants.FOR_RENT -> output += "for rent: ";
            case Constants.FOR_SALE -> output += "for sale: ";
        }
        output += this.roomsAmount + " rooms";
        if (this.propertyType != Constants.COTTAGE){
            output += ", floor " + this.floor;
        }
        output += "\nPrice: " + this.price + "$.\n" + "Contact info: " + this.user.toString();
        return output;
    }
}
