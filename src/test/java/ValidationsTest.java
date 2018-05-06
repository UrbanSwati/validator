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
        assertFalse(new Validations().validPassword("myPassword"));
        assertTrue(new Validations().validPassword("myPassword01!"));
        assertFalse(new Validations().validPassword("myPassword"));
        assertFalse(new Validations().validPassword(" "));
        assertFalse(new Validations().validPassword("myPassword 01"));
        assertFalse(new Validations().validPassword("myPass01"));
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
        assertTrue(new Validations().isValidID("ID_Number"));

        //Incorrect: 12 numbers
        assertFalse(new Validations().isValidID("ID_Number"));

        //Incorrect: 14 numbers
        assertFalse(new Validations().isValidID("ID_Number"));

        //Incorrect: invalid ID
        assertFalse(new Validations().isValidID("ID_Number"));

    }
}