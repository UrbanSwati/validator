import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Phil (https://github.com/NgakaMafona) Modified by William (https://github.com/UrbanSwati)
 * Validations class used for from validations in applications
 */
public class Validations
{
    public Validations()
    {

    }

    /**
     * Method to validate e-mail address
     * @param email users e-mail to be validated
     * @return boolean
     */
    public boolean isValidEmail(String email)
    {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /**
     * Method to validate telephone number
     * @param tel telephone number
     * @return boolean
     */
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


    /**
     * Method to validate a strong password
     *
     * a digit must occur at least once
     * a lower case letter must occur at least once
     * an upper case letter must occur at least once
     * a special character must occur at least once
     * no whitespace allowed in the entire string
     * at least eight characters length
     *
     * @param password users password
     * @return boolean
     */
    public boolean validPassword(String password)
    {
        /*       ^                # start-of-string
        *        (?=.*[0-9])       # a digit must occur at least once
        *        (?=.*[a-z])       # a lower case letter must occur at least once
        *        (?=.*[A-Z])       # an upper case letter must occur at least once
        *        (?=.*[@#$%^&+=])  # a special character must occur at least once
        *        (?=\S+$)          # no whitespace allowed in the entire string
        *        .{8,}             # anything, at least eight places though
        *         $                # end-of-string
        */

        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!^&+=])(?=\\S+$).{8,}$";

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    /**
     * Method to validate no digits in string
     * @param str string
     * @return boolean
     */
    public boolean validString(String str)
    {
        boolean valid = false;

        for(int x = 0; x <= str.length() -1; x++)
        {
            if(!Character.isDigit( str.charAt( x ) ))
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

    /**
     * Method to validate South African ID number
     * @param id South African Identity Document number
     * @return boolean
     */
    public boolean isValidID(String id)
    {
        boolean valid = false;

        if(id.length() == 13){
            valid = getIdentitySummationRL(new BigInteger(id));
        }

        return valid;
    }

    //Luhn Algorithm to validate the ID
    @NotNull
    private Boolean getIdentitySummationRL(BigInteger identities){
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
