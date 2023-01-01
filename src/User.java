import java.util.regex.Pattern;

public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private boolean relator;
    //O(1)
    public User(){}
    //O(1)
    public User(String userName, String password, String phoneNumber, boolean relator) {
        this.userName = userName;
        if (this.passwordValidation(password)){
            this.password = password;
        }
        if (this.phoneNumberValidating(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }
        this.relator = relator;
    }
    //O(1)
    private boolean passwordValidation(String password){
        boolean strong = false;
        if (password.length() >= 5){
            if (password.matches(Constants.REGEX_DIGITS)){
                strong = password.matches(Constants.REGEX_SYMBOL);
            }
        }
        return strong;
    }
    //O(1)
    private boolean phoneNumberValidating (String phoneNumber){
        boolean valid = false;
        if (phoneNumber.matches(Constants.PHONE_NUMBER_REGEX)){
            valid = phoneNumber.matches(Constants.PHONE_NUMBER_PREFIX_REGEX);
        }
        return valid;
    }
    //O(1)
    public void setPassword(String password){
        if (this.passwordValidation(password)){
            this.password = password;
        }
    }
    //O(1)
    protected void setPhoneNumber(String phoneNumber){
        if (this.phoneNumberValidating(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }
    }
    //O(1)
    private void setRelator(boolean relator){
        this.relator = relator;
    }
    //O(1)
    public String getUserName(){
        return userName;
    }
    //O(1)
    public String getPassword() {
        return password;
    }
    //O(1)
    public String getPhoneNumber() {
        return phoneNumber;
    }
    //O(1)
    public boolean isRelator() {
        return relator;
    }
    //O(1)
    public String toString(){
        return this.userName + " " + this.phoneNumber + " (" + (this.relator ? "real estate broker" : "individual") + ").";
    }
}
