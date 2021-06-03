import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    static final String VALID_DOB="^(((0[1-9]|[12][0-9]|30)[-]?(0[13-9]|1[012])|31[-]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-]?02)[-]?[0-9]{4}|29[-]?02[-]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$";
    static final String VALID_ID="^[C]\\d{4}[G|H|I|K]\\d{2}$";
    static final String VALID_EMAIL="^[a-zA-Z]+\\.[a-zA-Z]*@[c][o][d][e][g][y][m]\\.[v][n]";
    public Regex(){}

    static boolean validate(String regex, String propeties){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher= pattern.matcher(propeties);
        return matcher.matches();
    }


}
