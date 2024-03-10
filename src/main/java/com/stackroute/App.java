package com.stackroute;


import com.stackroute.model.LoanApplication;
import com.stackroute.model.Customer;
import com.stackroute.service.LoanApprovalService;

 
public class App 
{
    public static void main( String[] args )
    {
    //    create an object of LoanApplication using builder class
    //    print the object using toString method

        LoanApplication loanApplication = new LoanApplication.LoanApplicationBuilder()
                .applicationId(1)
                .loanAmount(10000)
                .tenure(12)
                .creditScore(7.5f)
                .build();
        System.out.println(loanApplication);

        // create an object of Customer using builder class
        // print the object using toString method

         Customer customer = new Customer.CustomerBuilder()
                .customerId(1)
                .customerName("John")
                .customerAge(25)
                .loanApplication(loanApplication)
                .build();

        System.out.println(customer);

        // create an object of LoanApprovalService
        // call the method approveLoanApplication with the customer object
        // print the result

        LoanApprovalService loanApprovalService = new LoanApprovalService();
        System.out.println(loanApprovalService.approveLoanApplication(customer));
System.out.println("---------------------------------------------------");

          //create an object of LoanApplication using builder class with values to  return true
          //in the approveLoanApplication method

        LoanApplication loanApplication1 = new LoanApplication.LoanApplicationBuilder()
                .applicationId(2        )
                .loanAmount(200000)
                .tenure(24)
                .creditScore(8.0f)
                .build();
        System.out.println(loanApplication1);

        // create an object of Customer using builder class with values to  return true
        //in the approveLoanApplication method

        Customer customer1 = new Customer.CustomerBuilder()
                .customerId(2)
                .customerName("John")
                .customerAge(25)
                .loanApplication(loanApplication1)
                .build();

        System.out.println(customer1);


        System.out.println(loanApprovalService.approveLoanApplication(customer1));

   
         









    }
}
