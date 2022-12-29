import java.security.PublicKey;

public class Property {
    private City city;
    private User user;
    private String street;
    private Float roomsAmount;
    private Double price;
    private Integer propertyType;
    private Integer forRent;
    private Integer houseNumber;
    private Integer floor;
    public final int REGULAR_APARTMENT = 1;
    public final int PENTHOUSE_APARTMENT = 2;
    public final int COTTAGE = 3;
    public final int BASEMENT_FLOOR = -1;
    public final float MIN_ROOMS_NUMBER = 1;
    public final int MIN_HOUSE_NUMBER = 1;
    public final Integer FOR_RENT = 1;
    public final Integer FOR_SALE = 2;
// input validations
    public Property(){}
    public Property(City city, User user, String street,
                    float roomsAmount, double price,
                    Integer propertyType, Integer forRent,
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
            this.forRent = forRent;
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
    private boolean validateIfForRent (Integer isForRent){
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

    public Float getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(Float roomsAmount) {
        if (this.validateRoomsAmount(roomsAmount)){
            this.roomsAmount = roomsAmount;
        }
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

    public Integer getSaleOrRent() {
        return forRent;
    }

    public void setForRent(Integer forRent) {
        this.forRent = forRent;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        if (this.validateHouseNumber(houseNumber)){
            this.houseNumber = houseNumber;
        }
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        if (this.validateFloor(floor)){
            this.floor = floor;
        }
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
