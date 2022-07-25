Feature: Login functionality for leaftaps application 

#Background:
#Given Open the Chrome Browser 
#Given Load application url as 'http://leaftaps.com/opentaps'

@Smoke @Sanity
Scenario: Login with positive credential 


Given Enter username
And Enter password
When Click on Login button
Then HomePage should be displayed 


@Smoke @Sanity
Scenario Outline: Login with negative credential 
 

Given Enter username as <username>
And Enter password as <password>
When Click on Login button 
But Error message should be displayed 

Examples:
|username|password|
|'Demo'|'crmsfa'|
|'CS'|'crmsfa'|
|'DemoC'|'crms'|