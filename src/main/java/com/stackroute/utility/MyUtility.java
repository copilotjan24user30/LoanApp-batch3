package com.stackroute.utility;
 
/*  create the following static methods
 * 1. validatePassword - to validate the password, take string as input and return boolean  
 *  validatePassword  returns true if
 * a. password contains at least 8 characters
 * b. password contains at least one digit (0-9)
 * c. password contains at least one lower case alphabet
 * d. password contains at least one upper case alphabet
 * e. password contains at least one special character ( @, #, %, &, !, $, ^ )
 * 
 * 2. validateDate which takes a string as input and returns boolean
 *     validateDate returns true if the input string is in the format "MM/dd/yyyy"
 *     validateDate using regular expression and LocalDate class to validate
 */

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtility {
    /**
     * Validates a password based on specific criteria.
     *
     * @param password the password to validate
     * @return true if the password is valid, false otherwise
     *
     * The password is considered valid if it meets the following criteria:
     * - Contains at least one digit
     * - Contains at least one lowercase letter
     * - Contains at least one uppercase letter
     * - Contains at least one special character (@, #, $, %, ^, &, +, =)
     * - Does not contain any whitespace characters
     * - Is between 8 and 20 characters in length
     */
    public static boolean validatePassword(String password) {
        // Check if the password is null or empty
        if (password == null || password.trim().isEmpty()) {
            // If it is, return false immediately
            return false;
        }

        // Define a regular expression (regex) string that sets the criteria for a valid password
        String regex = "^(?=.*[0-9])"  // At least one digit
                + "(?=.*[a-z])"  // At least one lowercase letter
                + "(?=.*[A-Z])"  // At least one uppercase letter
                + "(?=.*[@#$%^&+=])"  // At least one special character
                + "(?=\\S+$).{8,20}$";  // No whitespace characters and between 8 and 20 characters in length

        // Compile the regex into a Pattern object
        Pattern p = Pattern.compile(regex);

        // Create a Matcher object that can match the input password against the pattern
        Matcher m = p.matcher(password);

        // Check if the entire password matches the pattern
        // If it does, return true; otherwise, return false
        return m.matches();
    }
    
    public static boolean validateDate(String date) {
        boolean isValid = false;
        String regex = "^(0[1-9]|1[0-2])/(0[1-9]|1[0-9]|2[0-9]|3[0-1])/\\d{4}$";
        Pattern p = Pattern.compile(regex);
        
        if (date != null) {
            Matcher m = p.matcher(date);
            if (m.matches()) {
                String[] dateArray = date.split("/");
                int month = Integer.parseInt(dateArray[0]);
                int day = Integer.parseInt(dateArray[1]);
                int year = Integer.parseInt(dateArray[2]);
                try {
                    LocalDate.of(year, month, day);
                    isValid = true;
                } catch (Exception e) {
                    // If LocalDate.of throws an exception, isValid remains false
             
                }
            }
        }
        return isValid;
    }
    //create main to test the above methods

    public static void main(String[] args) {
        System.out.println(validatePassword("12345678")); //false
        System.out.println(validatePassword("12345678A"));          //false
        System.out.println(validatePassword("12345678a"));         //false
        System.out.println(validatePassword("12345678@"));      //false 
        System.out.println(validatePassword("12345678Aa"));  //false
        System.out.println(validatePassword("12345678Aa@"));  
        System.out.println(validatePassword("12345678Aa@#"));  
        System.out.println(validatePassword("12345678Aa@#1")); //true
        System.out.println(validatePassword("12345678Aa@#1a"));
        System.out.println(validatePassword("12345678Aa@#1aA"));
        System.out.println(validatePassword("12345678Aa@#1aA@"));
        System.out.println(validatePassword("12345678Aa@#1aA@#"));
        System.out.println(validatePassword("12345678Aa@#1aA@#1"));
System.out.println("-----------------------------------");
        //validateDate
        System.out.println(validateDate("12/12/2020")); //true
        System.out.println(validateDate("12/32/2020")); //false
        System.out.println(validateDate("13/12/2020")); //false
         System.out.println(validateDate("12/29/2024")); //true
        System.out.println(validateDate("15/35/2020"));  
        System.out.println(validateDate("1/1/2020"));   //false 
        System.out.println(validateDate("01/01/2020"));
    } 
   
       

}