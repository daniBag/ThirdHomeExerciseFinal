public class QueryUtility {
    private User user;
    private Integer rentOrSale;
    private Integer propertyType;
    private Double minPrice;
    private Double maxPrice;
    private Integer roomsAmount;
    private Property property;
    //O(1)
    public QueryUtility(){
        this.property = new Property();
    }
    //O(1)
    public User getUser() {
        return user;
    }
    //O(1)
    public void setUser(User user) {
        this.user = user;
    }
    //O(1)
    public Integer getRentOrSale() {
        return rentOrSale;
    }
    //O(1)
    public void setRentOrSale(Integer rentOrSale) {
        if (property.validateRentOrSale(rentOrSale)){
            this.rentOrSale = rentOrSale;
        }
    }
    //O(1)
    public Integer getPropertyType() {
        return propertyType;
    }
    //O(1)
    public void setPropertyType(Integer propertyType) {
            if (property.validatePropertyType(propertyType)){
                this.propertyType = propertyType;
            }
    }
    //O(1)
    public Double getMinPrice() {
        return minPrice;
    }
    //O(1)
    public void setMinPrice(Double minPrice) {
            if (property.validatePrice(minPrice)){
                this.minPrice = minPrice;
            }
    }
    //O(1)
    public Double getMaxPrice() {
        return maxPrice;
    }
    //O(1)
    public void setMaxPrice(Double maxPrice) {
            if (property.validatePrice(maxPrice)){
                this.maxPrice = maxPrice;
            }
    }
    //O(1)
    public Integer getRoomsAmount() {
        return roomsAmount;
    }
    //O(1)
    public void setRoomsAmount(Integer roomsAmount) {
            if (property.validateRoomsAmount(roomsAmount)){
                this.roomsAmount = roomsAmount;
            }
    }
}
