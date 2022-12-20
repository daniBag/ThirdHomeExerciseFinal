public class Property {
    private City city;
    private User user;
    private String street;
    private float rooms;
    private double price;
    private String propertyType;
    private boolean forRent;
    private int number;
    private int floor;

    public Property(City city, User user, String street,
                    float rooms, double price,
                    String propertyType, boolean forRent,
                    int number, int floor) {
        this.city = city;
        this.user = user;
        this.street = street;
        this.rooms = rooms;
        this.price = price;
        this.propertyType = propertyType;
        this.forRent = forRent;
        this.number = number;
        this.floor = floor;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public float getRooms() {
        return rooms;
    }

    public void setRooms(float rooms) {
        this.rooms = rooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public boolean isForRent() {
        return forRent;
    }

    public void setForRent(boolean forRent) {
        this.forRent = forRent;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


}
