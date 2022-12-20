import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean phoneNumberValidating (String phoneNumber){
        boolean valid = false;
        String digits = "";
        if (Pattern.matches("^(\\d{10})$", phoneNumber)){
            valid = Pattern.matches("^05.*", phoneNumber);
        }
        return valid;
    }
    public static void main(String[] args) {
            String str = "0509530653";
            System.out.println(phoneNumberValidating(str));
    }
}
/*(?=\S+$)(?=.*[%$_])
Pattern p = Pattern.compile("(.*\\d?%?.*)+(.*%?|$?.*)");
    Matcher m = p.matcher(password);
            System.out.println(m.matches());*/