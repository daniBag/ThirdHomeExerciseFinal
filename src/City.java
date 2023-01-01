public class City {
    private String name;
    private String district;
    private String[] streets;

    //O(1)
    public City(String name, int district, String[] streets) {
        this.name = name;
        switch (district){
            case Constants.NEGEV_DISTRICT -> this.district = "Negev District";
            case Constants.SOUTHERN_DISTRICT -> this.district = "Southern District";
            case Constants.CENTRAL_DISTRICT -> this.district = "Central District";
            case Constants.SHARON_DISTRICT -> this.district = "Sharon District";
            case Constants.NORTHERN_DISTRICT -> this.district = "Northern District";
            default -> this.district = null;
        }

        this.streets = streets;
    }
    //O(1)
    public String getName() {
        return name;
    }
    //O(n)
    public void printStreetList (){
        for (int i = 0; i < this.streets.length; i++){
            System.out.println(this.streets[i]);
        }
    }
    //O(n)
    public boolean isValidStreet(String streetName){
        boolean valid = false;
        for (int i = 0; i < this.streets.length; i++){
            if (this.streets[i].equals(streetName)){
                valid = true;
                break;
            }
        }
        return valid;
    }
}
