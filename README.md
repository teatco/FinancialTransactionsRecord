# FinancialTransactionsRecord
Financial Transactions Record is a simple software that records transactions 


## Classes Structure 
	1. Transaction is an abstract class that will dive PaymentTransaction and ReversalTransaction
	2. PaymentTransaction to represent the actual transaction been done or accepted, will have an extra attribute which
	is final constant to represent the transaction type as payment type.
	3. ReversalTransaction class to represent the transaction that has been refused, will have a pointer to
	the Transaction that has been rejected and also will have a final constant Transaction type. 
	4. ReadFile is a general class to read text file, has got a method that accept the file name as parameter
	5. FinancialTransactionRecordWorkFlow to structure the system and make calls to the following sub-component:
	read form file, digest data, and calculate the account balance for an account in a period.
	6. FinancialTransactionRecords that will contain the main method
	
	
## Sub-Components of the System
1. read form file
2. digest transactions data
3. calculate balance and the number of transactions of an account in specific period



## Testing
1. tested Read from file class
2. Inheritance classes 
3. also the workflow class
4. created a test to get the account balances and the number of transactions of all account number that are introduced 
in the specification sheet 


## How to Run the System 
Run as java application, modify the Main method in the FinancialTransactionRecords class if you need to change the account number or
the period that you are looking in between, also you can change the data in the file called data which is in the main folder. Make sure
you pass the file name too if you have change it.
