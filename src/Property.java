import java.security.PublicKey;

public class Property {
    private City city;
    private User user;
    private String street;
    private Float roomsAmount;
    private Double price;
    private Integer propertyType;
    private Boolean forRent;
    private Integer houseNumber;
    private Integer floor;
    public final int REGULAR_APARTMENT = 1;
    public final int PENTHOUSE_APARTMENT = 2;
    public final int COTTAGE = 3;
    public final int BASEMENT_FLOOR = -1;
    public final float MIN_ROOMS_NUMBER = 1;
    public final int MIN_HOUSE_NUMBER = 1;
    public final String FOR_RENT = "y";
    public final String FOR_SALE = "n";
// input validations
    public Property(){}
    public Property(City city, User user, String street,
                    float roomsAmount, double price,
                    Integer propertyType, String forRent,
                    int houseNumber, int floor) {
        this.city = city;
        this.user = user;
        this.street = street;
        if (this.validateRoomsAmount(roomsAmount)){
            this.roomsAmount = roomsAmount;
        }
        if (this.validatePrice(price)){
            this.price = price;
        }
        if (this.validatePropertyType(propertyType)){
            this.propertyType = propertyType;
        }
        if (this.validateIfForRent(forRent)){
             switch (forRent){
                 case FOR_RENT -> this.forRent =true;
                 case FOR_SALE -> this.forRent =false;
             }
        }
        if (this.validateHouseNumber(houseNumber)){
            this.houseNumber = houseNumber;
        }
        if (this.validateFloor(floor)){
            this.floor = floor;
        }
    }
    public boolean validatePrice (double price){
        boolean valid = false;
        if (price >=0){
            valid = true;
        }
        return valid;
    }
    public boolean validateFloor (int floor){
        boolean valid = false;
        if (floor >= BASEMENT_FLOOR){
            valid = true;
        }
        return valid;
    }
    public boolean validateHouseNumber (Integer houseNumber){
        boolean valid = false;
        if (houseNumber >= MIN_HOUSE_NUMBER){
            valid = true;
        }
        return valid;
    }
    public boolean validateRoomsAmount(float roomsAmount){
        boolean valid = false;
        if (roomsAmount >= MIN_ROOMS_NUMBER){
            if (roomsAmount % 0.5 == 0){
                valid = true;
            }
        }
        return valid;
    }
    public boolean validatePropertyType (Integer propertyType){
        boolean valid = false;
        if (propertyType == REGULAR_APARTMENT || propertyType == PENTHOUSE_APARTMENT || propertyType == COTTAGE){
            valid = true;
        }
        return valid;
    }
    private boolean validateIfForRent (String isForRent){
        boolean valid = false;
        if (isForRent != null){
            if (isForRent.equals(FOR_RENT) || isForRent.equals(FOR_SALE)){
                valid = true;
            }
        }
        return valid;
    }
    public City getCity() {
        return city;
    }

    private void setCity(City city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    private void setUser(User user) {
        this.user = user;
    }

    public String getStreet() {
        return street;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    public float getRoomsAmount() {
        return roomsAmount;
    }

    private void setRoomsAmount(float roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public Integer getPropertyType() {
        return propertyType;
    }

    private void setPropertyType(Integer propertyType) {
        this.propertyType = propertyType;
    }

    public boolean isForRent() {
        return forRent;
    }

    private void setForRent(boolean forRent) {
        this.forRent = forRent;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    private void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFloor() {
        return floor;
    }

    private void setFloor(int floor) {
        this.floor = floor;
    }
    public String toString (){
        String output = this.city.getName() + " " + this.street + " " + this.houseNumber + ".\n";
        switch (propertyType){
            case REGULAR_APARTMENT -> output += "Regular apartment - ";
            case PENTHOUSE_APARTMENT -> output += "Penthouse apartment - ";
            case COTTAGE -> output += "Cottage - ";
        }
        output += (this.forRent ? "for rent: " : "for sale: ") + this.roomsAmount + " rooms";
        if (this.propertyType!=COTTAGE){
            output += ", floor " + this.floor;
        }
        output += "\nPrice: " + this.price + "$.\n" + "Contact info: " + this.user.toString();
        return output;
    }
}
