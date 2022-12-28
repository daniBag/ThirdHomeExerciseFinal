public class City {
    private String name;
    private String county; // לשנות למספרים+ קבועים
    private String[] streets;

    public City(String name, String county, String[] streets) {
        this.name = name;
        this.county = county;
        this.streets = streets;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setCounty(String county) {
        this.county = county;
    }

    private void setStreets(String[] streets) {
        this.streets = streets;
    }

    public String getName() {
        return name;
    }

    public String getCounty() {
        return county;
    }

    public String[] getStreets() {
        return streets;
    }
    public void printStreetList (){
        for (int i = 0; i < this.streets.length; i++){
            System.out.println(this.streets[i]);
        }
    }
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
