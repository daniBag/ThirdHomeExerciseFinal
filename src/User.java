import java.util.regex.Pattern;

public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private boolean relator;

    public User(){}
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
    private boolean checkIfContains(String check, String contains) {
        boolean isContaining = false;
        for (int i = 0; i < check.length(); i++) {
            if (contains.contains(check.charAt(i) + "")) {
                isContaining = true;
                break;
            }
        }
        return isContaining;
    }
    private boolean passwordValidation(String password){
        boolean strong = false;
        String digits = "0123456789";
        String spacialSymbol = "$%_";
        if (password.length() >= 5){
            if (checkIfContains(password, spacialSymbol)){
                if (checkIfContains(password, digits)) {
                    strong = true;
                }
            }
        }
        return strong;
    }
    private boolean phoneNumberValidating (String phoneNumber){
        boolean valid = false;
        if (Pattern.matches("^(\\d{10})$", phoneNumber)){
            valid = Pattern.matches("^05.*", phoneNumber);
        }
        return valid;
    }
    private void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassword(String password){
        if (this.passwordValidation(password)){
            this.password = password;
        }
    }
    public void setPhoneNumber(String phoneNumber){
        if (this.phoneNumberValidating(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }
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
