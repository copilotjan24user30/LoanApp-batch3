package com.stackroute.service;

import org.junit.jupiter.api.Test;

/*  create  junit5  testcase for  approveLoanApplication  method  
 * generate   both positive and negative test cases
 *  Use @BeforeEach  to create the objects of LoanApprovalService  
 * Use @AfterEach to  destroy the objects of LoanApprovalService
 * 
*/
import com.stackroute.model.Customer;
import com.stackroute.model.LoanApplication;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;



class LoanApprovalServiceTest {
    LoanApprovalService loanApprovalService;

    //setup method

    @BeforeEach
    public void setUp() {
        loanApprovalService = new LoanApprovalService();
    }

    //tearDown method

    @AfterEach
    public void tearDown() {
        loanApprovalService = null;
    }


    @Test
    void testApproveLoanApplication() {
         
        //create an object of LoanApplication using builder class with values to  return true
        //in the approveLoanApplication method
        LoanApplication loanApplication = new LoanApplication.LoanApplicationBuilder()
                .applicationId(2        )
                .loanAmount(200000)
                .tenure(24)
                .creditScore(8.0f)
                .build();
        System.out.println(loanApplication);

        //create an object of Customer using builder class with values to  return true
        //in the approveLoanApplication method
        Customer customer = new Customer.CustomerBuilder()
                .customerId(2)
                .customerName("John")
                .customerAge(25)
                .loanApplication(loanApplication)
                .build();
         
        //call the method approveLoanApplication with the customer object and store the result
        boolean result = loanApprovalService.approveLoanApplication(customer);
        //assert the result with the expected value
        assertTrue(result);
        
    }
    @Test
    void testApproveLoanApplicationNegative() {
         
        //create an object of LoanApplication using builder class with values to  return true
        //in the approveLoanApplication method
        LoanApplication loanApplication = new LoanApplication.LoanApplicationBuilder()
                .applicationId(1)
                .loanAmount(10000)
                .tenure(14)
                .creditScore(8.5f)
                .build();
        System.out.println(loanApplication);

        //create an object of Customer using builder class with values to  return true
        //in the approveLoanApplication method
        Customer customer = new Customer.CustomerBuilder()
                .customerId(1)
                .customerName("John")
                .customerAge(25)
                .loanApplication(loanApplication)
                .build();
 
   boolean result = loanApprovalService.approveLoanApplication(customer) ;
    assertFalse(result);

        }
 
 

    @Test
    void testApproveLoanApplicationInvalidAge() {
        // Create an object of LoanApplication using builder class with values to return true
        // in the approveLoanApplication method
        LoanApplication loanApplication = new LoanApplication.LoanApplicationBuilder()
                .applicationId(1)
                .loanAmount(10000)
                .tenure(14)
                .creditScore(8.5f)
                .build();

        // Create an object of Customer using builder class with invalid age (less than 20)
        Customer customer = new Customer.CustomerBuilder()
                .customerId(1)
                .customerName("John")
                .customerAge(18) // Invalid age
                .loanApplication(loanApplication)
                .build();

        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);
    }

   /*  creeate junit5 testcase for  invalid tenure */
    @Test
    void testApproveLoanApplicationInvalidTenure() {
        // Create an object of LoanApplication using builder class with values
        // to return true in the approveLoanApplication method

        LoanApplication loanApplication = new LoanApplication.LoanApplicationBuilder()
                .applicationId(1)
                .loanAmount(10000)
                .tenure(10)
                .creditScore(8.5f)
                .build();   

        // Create an object of Customer using builder class with invalid tenure (less than 12)
        Customer customer = new Customer.CustomerBuilder()
                .customerId(1)
                .customerName("John")
                .customerAge(25)
                .loanApplication(loanApplication)
                .build();
    
        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);

    }


// create  test case for Invalid credit score
    @Test
    void testApproveLoanApplicationInvalidCreditScore() {
        // Create an object of LoanApplication using builder class with values
        // to return true in the approveLoanApplication method

        LoanApplication loanApplication = new LoanApplication.LoanApplicationBuilder()
                .applicationId(1)
                .loanAmount(200000)
                .tenure(14)
                .creditScore(7.0f) // Invalid credit score
                .build();

        // Create an object of Customer using builder class with invalid credit score (less than 7.5)
        Customer customer = new Customer.CustomerBuilder()
                .customerId(1)
                .customerName("John")
                .customerAge(25)
                .loanApplication(loanApplication)
                .build();

        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);
    }

    // create  test case for Invalid loan amount
    @Test
    void testApproveLoanApplicationInvalidLoanAmount() {
        // Create an object of LoanApplication using builder class with values  to return true in the approveLoanApplication method 
        LoanApplication loanApplication = new LoanApplication.LoanApplicationBuilder()
                .applicationId(1)
                .loanAmount(1000000) // Invalid loan amount
                .tenure(14)
                .creditScore(8.5f)
                .build();

        // Create an object of Customer using builder class with invalid loan amount (greater than 500000)
        Customer customer = new Customer.CustomerBuilder()
                .customerId(1)
                .customerName("John")
                .customerAge(25)
                .loanApplication(loanApplication)
                .build();

        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);

    
    }

    
        
        
}




