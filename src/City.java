public class City {
    private String name;
    private String county;

    private String[] streets;

    public City(String name, String county, String[] streets) {
        this.name = name;
        this.county = county;
        this.streets = streets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setStreets(String[] streets) {
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
}
