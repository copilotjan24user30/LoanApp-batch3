package com.stackroute.utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyUtilityTest {

    @Test
    public void testValidatePassword() {
        assertTrue(MyUtility.validatePassword("Password123@"));
        assertFalse(MyUtility.validatePassword("password"));
        assertFalse(MyUtility.validatePassword("PASSWORD123"));
        assertFalse(MyUtility.validatePassword("Password123"));
        assertFalse(MyUtility.validatePassword("Password@"));
        assertFalse(MyUtility.validatePassword("123@"));
        assertFalse(MyUtility.validatePassword(null));
        assertFalse(MyUtility.validatePassword(""));
    }

    @Test
    public void testValidateDate() {
        assertTrue(MyUtility.validateDate("12/31/2020"));
        assertFalse(MyUtility.validateDate("13/31/2020"));
        assertFalse(MyUtility.validateDate("12/32/2020"));
        assertFalse(MyUtility.validateDate("02/29/2021"));
        assertFalse(MyUtility.validateDate("12/31/20"));
        assertFalse(MyUtility.validateDate("12-31-2020"));
        assertFalse(MyUtility.validateDate(null));
        assertFalse(MyUtility.validateDate(""));
    }
}
