Feature: Login to the OrangeHRMS website


Scenario: Positive Login of the website

And Enter the username as 'Admin'
And Enter the password as 'admin123'
When Click on the Login button
Then Verify the dashboard

Scenario Outline: Invalid login of the website
And Enter the username as <UserName>
And Enter the password as <password>
When Click on the Login button
But Verify the dashboard is not displayed
 
 Examples:
 |UserName|password|
 |'Admin'|'admin1234'|