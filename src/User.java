public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private boolean relator;

    public User(String userName, String password, String phoneNumber, boolean relator) {
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.relator = relator;
    }
    private void setUserName(String userName){
        this.userName = userName;
    }
    private void setPassword(String password){
        this.password = password;
    }
    private void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    private void setRelator(boolean relator){
        this.relator = relator;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isRelator() {
        return relator;
    }
}
