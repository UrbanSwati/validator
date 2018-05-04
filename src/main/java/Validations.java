import java.math.BigInteger;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Home on 2016/06/09.
 */
public class Validations
{
    public Validations()
    {

    }

    public boolean isValidEmail(String email)
    {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public boolean validateTel(String tel)
    {
        boolean valid = false;

        int count = 0;

        for(int i = 0; i < tel.length(); i++)
        {
            if(Character.isDigit(tel.charAt(i)))
            {
                count++;
                valid = true;
            }
            else
            {
                valid = false;
                break;
            }
        }

        return valid;
    }


    public boolean validPassword(String password)
    {
        //        ^                 # start-of-string
        //        (?=.*[0-9])       # a digit must occur at least once
        //        (?=.*[a-z])       # a lower case letter must occur at least once
        //        (?=.*[A-Z])       # an upper case letter must occur at least once
        //        (?=.*[@#$%^&+=])  # a special character must occur at least once
        //        (?=\S+$)          # no whitespace allowed in the entire string
        //        .{8,}             # anything, at least eight places though
        //          $               # end-of-string

        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!^&+=])(?=\\S+$).{8,}$";

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public boolean validString(String s)
    {
        boolean valid = false;

        for(int x = 0; x <= s.length() -1; x++)
        {
            if(!Character.isDigit( s.charAt( x ) ))
            {
                valid = true;
                x++;
            }
            else
            {
                valid = false;
                break;
            }
        }

        return valid;
    }

    public boolean isValidID(String id)
    {
        boolean valid = false;

        if(id.length() == 13){
            valid = getIdentitySummationRL(new BigInteger(id));
        }

        return valid;
    }

    //Luhn Algorithm to validate the ID
    public Boolean getIdentitySummationRL(BigInteger identities){
        char[] idchars = identities.toString().toCharArray();
        int sum = 0;
        // loop over each digit, except the check-digit
        for (int i = 0; i < idchars.length - 1; i++) {
            int digit = Character.getNumericValue(idchars[i]);
            if ((i % 2) == 0) {
                sum += digit;
            } else {
                sum += digit < 5 ? digit * 2 : digit * 2 - 9;
            }
        }
        int checkdigit = Character.getNumericValue(idchars[idchars.length - 1]);
        int compdigit = (sum * 9) % 10;

        return checkdigit == compdigit;
    }

}
