Feature: Order T-Shirt and Verify in Order History
 In order to access my account
  As a user of the website
    I want to log into the website
    Order a T-Shirt
    Verify the order History
 
@Order
Scenario: Successful Login with Valid Credentials and order one T-Shirt
 Given Load Application URL
 And Navigate to LogIn Page and enter valid credentials
 When Go to T-Shirt menu
 And Order a T-Shirt "cheque"
 Then Verify order successfully completed message
 And Verify orderReference Number in the Order History table
 
Scenario: Update Personal Information (First Name) in My Account
	When Go to My Account
	And Click on My personal Information
	And Update FirstName and save
	Then Verify the save success message
	And SignOut
	And Close Browser