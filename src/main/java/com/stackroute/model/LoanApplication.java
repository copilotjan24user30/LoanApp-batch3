package com.stackroute.model;


 /*
  * create class with the following attributes
  * applicationId, loanAmount as int ,tenure as int,creditScore as float
  * create a static   builder class LoanApplicationBuilder as a innerclass
  * to build the object of LoanApplication.
  * create getter and setter ,toString method for the class LoanApplication
  * create a private constructor with parameter as a builder class object
  */
public class LoanApplication {
    private int applicationId;
    private int loanAmount;
    private int tenure;
    private float creditScore;
    
    private LoanApplication(LoanApplicationBuilder builder) {
        this.applicationId = builder.applicationId;
        this.loanAmount = builder.loanAmount;
        this.tenure = builder.tenure;
        this.creditScore = builder.creditScore;
    }
    
    public int getApplicationId() {
        return applicationId;
    }
    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
    public int getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }
    public int getTenure() {
        return tenure;
    }
    public void setTenure(int tenure) {
        this.tenure = tenure;
    }
    public float getCreditScore() {
        return creditScore;
    }
    public void setCreditScore(float creditScore) {
        this.creditScore = creditScore;
    }
    
    @Override
    public String toString() {
        return "LoanApplication [applicationId=" + applicationId + ", loanAmount=" + loanAmount + ", tenure=" + tenure
                + ", creditScore=" + creditScore + "]";
    }
    
    public static class LoanApplicationBuilder {
        private int applicationId;
        private int loanAmount;
        private int tenure;
        private float creditScore;
        
        public LoanApplicationBuilder applicationId(int applicationId) {
            this.applicationId = applicationId;
            return this;
        }
        public LoanApplicationBuilder loanAmount(int loanAmount) {
            this.loanAmount = loanAmount;
            return this;
        }
        public LoanApplicationBuilder tenure(int tenure) {
            this.tenure = tenure;
            return this;
        }
        public LoanApplicationBuilder creditScore(float creditScore) {
            this.creditScore = creditScore;
            return this;
        }
        
        public LoanApplication build() {
            return new LoanApplication(this);
        }
    }
}




