public class Property {
    private City city;
    private User user;
    private String street;
    private float roomsAmount;
    private double price;
    private Integer propertyType;
    private boolean forRent;
    private Integer houseNumber;
    private int floor;
    public final Integer REGULAR_APARTMENT = 1;
    public final Integer PENTHOUSE_APARTMENT = 2;
    public final Integer COTTAGE = 3;
    public final int TOP_FLOOR_POSSIBLE = 50;
    public final int LOWEST_FLOOR = -1;
    public final float MAX_ROOMS_NUMBER = 12;
    public final float MIN_ROOMS_NUMBER = 1;
    public final int MIN_HOUSE_NUMBER = 1;
    public final int MAX_HOUSE_NUMBER = 500;
    public final int FOR_RENT = 1;
    public final int FOR_SALE = 2;
// input validations
    public Property(){}
    public Property(City city, User user, String street,
                    float roomsAmount, double price,
                    Integer propertyType, boolean forRent,
                    int houseNumber, int floor) {
        this.city = city;
        this.user = user;
        this.street = street;
        this.roomsAmount = roomsAmount;
        this.price = price;
        this.propertyType = propertyType;
        this.forRent = forRent;
        this.houseNumber = houseNumber;
        this.floor = floor;
    }
    public boolean validateRentOrSale (Integer rentOrSale){
        boolean valid = false;
        if (rentOrSale == 1 || rentOrSale == 2){
            valid = true;
        }
        return valid;
    }
    public boolean validateFloor (int floor){
        boolean valid = false;
        if (floor <= TOP_FLOOR_POSSIBLE && floor >= LOWEST_FLOOR){
            valid = true;
        }
        return valid;
    }
    public boolean validateHouseNumber (Integer houseNumber){
        boolean valid = false;
        if (houseNumber >= MIN_HOUSE_NUMBER && houseNumber <= MAX_HOUSE_NUMBER){
            valid = true;
        }
    }
    public boolean validateRoomsAmount(float roomsAmount){
        boolean valid = false;
        if (roomsAmount <= MAX_ROOMS_NUMBER && roomsAmount >= MIN_ROOMS_NUMBER){
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


}
