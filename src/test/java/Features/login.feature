Feature: Login Page of the Orange HRMS 


Scenario: Positive Login of the website

And Enter the username as 'Admin'
And Enter the password as 'admin123'
When Click on the Login button
Then Verify the dashboard


Scenario Outline: Invalid login of the website message is displayed 
And Enter the username as <UserName>
And Enter the password as <password>
When Click on the Login button
But Verify the invalid credentials message  is displayed
 
 Examples:
 |UserName|password|
 |'Admin'|'admin1234'|
 

Scenario: Verify the forgot passwordlink
When Click on the Forgotpassword link
Then Verify the Reset Password Page is displayed


Scenario: Verify the reset password button
When Click on the Forgotpassword link
And  Enter the username as 'Suman'
And Click on the ResetPassword Button
Then Verify the Reset Password sent Page is displayed 
