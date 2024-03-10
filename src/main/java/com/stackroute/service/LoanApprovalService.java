package com.stackroute.service;

 
/*create the  method approveLoanApplication with parameter as a customer object
 * return type as a boolean
 * approveLoanApplication method should return true if the  following conditions are satisfied
 * credit score is greater than 7.5
 * loan amount is less than 500000  and greater than 100000
 * 
 * customer age is greater than 20 and less than or equal  to 60
 *   
 * 
 */
 
import com.stackroute.model.Customer;

public class LoanApprovalService {
    /**
     * This method checks if a customer is eligible for a loan based on certain criteria.
     * 
     * @param customer The customer whose loan application is to be approved.
     * @return true if the customer's credit score is greater than 7.5, the loan amount is between 100,000 and 500,000,
     *         the customer's age is between 20 and 60, and the loan tenure is between 12 and 36 months. Otherwise, it returns false.
     */
    public boolean approveLoanApplication(Customer customer) {
        if(customer.getLoanApplication().getCreditScore() > 7.5 && 
            customer.getLoanApplication().getLoanAmount() > 100000 && 
            customer.getLoanApplication().getLoanAmount() < 500000 && 
            customer.getCustomerAge() > 20 && 
            customer.getCustomerAge() <= 60  &&  
            (customer.getLoanApplication().getTenure() < 36 && customer.getLoanApplication().getTenure() > 12)){
            return true;
        }
        return false;
    }
}

