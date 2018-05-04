import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class ValidationsTest {

    @Test
    public void isValidEmail() {
        assertTrue(new Validations().isValidEmail("willieskd@gmail.com"));
        assertFalse(new Validations().isValidEmail("willieskdgmail.com"));
        assertFalse(new Validations().isValidEmail("willieskdgmailcom"));
        assertFalse(new Validations().isValidEmail("williesdk@gmailcom"));
        assertFalse(new Validations().isValidEmail("williesdk@gma@il.com"));
    }

    @Test
    public void validPassword() {
        assertFalse(new Validations().validPassword("123456"));
        assertFalse(new Validations().validPassword("12345678"));
        assertFalse(new Validations().validPassword("iamWilliam94"));
        assertTrue(new Validations().validPassword("iamWilliam94!"));
        assertFalse(new Validations().validPassword("iamWilliam"));
        assertFalse(new Validations().validPassword(" "));
        assertFalse(new Validations().validPassword("iamWilliam 23"));
        assertFalse(new Validations().validPassword("iamWi95"));
    }

//    @Test
//    public void validateTel() {
//    }
//
//    @Test
//    public void validString() {
//    }

    @Test
    public void isValidID() {
        //Correct 13 numbers and valid ID
        assertTrue(new Validations().isValidID("9401195312088"));

        //Incorrect: 12 numbers
        assertFalse(new Validations().isValidID("940119531208"));

        //Incorrect: 14 numbers
        assertFalse(new Validations().isValidID("94011953120888"));

        //Incorrect: invalid ID
        assertFalse(new Validations().isValidID("9401195312188"));

    }
}