package com.stackroute.model;
/*
 * create class with the following attributes
 * customerId,customerName as String ,customerAge as int,LoanApplication as object
 * create a static   builder class CustomerBuilder as a innerclass
 * to build the object of Customer.
 * create getter and setter ,toString method for the class Customer
 * create a private constructor with parameter as a builder class object
 * 
 */

public class Customer {
    private int customerId;
    private String customerName;
    private int customerAge;
    private LoanApplication loanApplication;
    
    private Customer(CustomerBuilder builder) {
        this.customerId = builder.customerId;
        this.customerName = builder.customerName;
        this.customerAge = builder.customerAge;
        this.loanApplication = builder.loanApplication;
    }
    
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getCustomerAge() {
        return customerAge;
    }
    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }
    public LoanApplication getLoanApplication() {
        return loanApplication;
    }
    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }
    
    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAge=" + customerAge
                + ", loanApplication=" + loanApplication + "]";
    }
    
    public static class CustomerBuilder {
        private int customerId;
        private String customerName;
        private int customerAge;
        private LoanApplication loanApplication;
        
        public CustomerBuilder customerId(int customerId) {
            this.customerId = customerId;
            return this;
        }
        public CustomerBuilder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }
        public CustomerBuilder customerAge(int customerAge) {
            this.customerAge = customerAge;
            return this;
        }
        public CustomerBuilder loanApplication(LoanApplication loanApplication) {
            this.loanApplication = loanApplication;
            return this;
        }
        
        public Customer build() {
            return new Customer(this);
        }
    }
}
