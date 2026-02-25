package com.xyzbank.testdata;

/**
 * Test Data Configuration
 * Central location for all test data used in automation
 */
public class TestData {
    
    // Customer Data
    public static class Customers {
        public static final String HARRY_POTTER = "Harry Potter";
//        public static final String HERMOINE_GRANGER = "Hermoine Granger";
//        public static final String RON_WEASLEY = "Ron Weasly";
//        public static final String ALBUS_DUMBLEDORE = "Albus Dumbledore";
//        public static final String NEVILLE_LONGBOTTOM = "Neville Longbottom";
    }
    
    // Manager Test Data
    public static class ManagerData {
        public static class ValidCustomers {
            public static final String FIRST_NAME = "John";
            public static final String LAST_NAME = "Doe";
            public static final String POSTAL_CODE = "12345";
            
            public static final String FIRST_NAME_2 = "Jane";
            public static final String LAST_NAME_2 = "Smith";
            public static final String POSTAL_CODE_2 = "67890";
            
            public static final String FIRST_NAME_3 = "Alice";
            public static final String LAST_NAME_3 = "Johnson";
            public static final String POSTAL_CODE_3 = "11111";
        }
        
        public static class InvalidCustomers {
            public static final String INVALID_NAME_WITH_NUMBERS = "John123";
            public static final String INVALID_NAME_WITH_SPECIAL_CHARS = "@Jane";
            public static final String INVALID_POSTAL_CODE_ALPHA = "ABC12";
            public static final String INVALID_POSTAL_CODE_MIXED = "123AB";
        }
        
        public static class Currency {
            public static final String DOLLAR = "Dollar";
//            public static final String POUND = "Pound";
//            public static final String RUPEE = "Rupee";
        }
    }
    
    // Transaction Amounts
    public static class Amounts {
        public static final String SMALL_DEPOSIT = "100";
        public static final String MEDIUM_DEPOSIT = "500";
        public static final String LARGE_DEPOSIT = "1000";
        public static final String EXTRA_LARGE_DEPOSIT = "2000";
        
        public static final String SMALL_WITHDRAWAL = "50";
        public static final String MEDIUM_WITHDRAWAL = "100";
        public static final String LARGE_WITHDRAWAL = "500";
        
        public static final String ZERO_AMOUNT = "0";
        public static final String NEGATIVE_AMOUNT = "-100";
    }
    
    // Wait Times (in milliseconds)
    public static class WaitTimes {
        public static final int SHORT_WAIT = 500;
        public static final int MEDIUM_WAIT = 1000;
        public static final int LONG_WAIT = 2000;
        public static final int EXTRA_LONG_WAIT = 3000;
    }
    
    // Expected Messages
    public static class Messages {
        public static final String CUSTOMER_ADDED_SUCCESS = "Customer added successfully";
        public static final String ACCOUNT_CREATED_SUCCESS = "Account created successfully";
//        public static final String TRANSACTION_FAILED = "Transaction Failed";
//        public static final String DEPOSIT_SUCCESS = "Deposit Successful";
        //public static final String WITHDRAWAL_SUCCESS = "Transaction successful";
    }
    
    // URLs
    public static class URLs {
        public static final String BASE_URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    }
}
