Feature: Delete Lead Functionality

@Regression
Scenario: Positive flow for Delete Lead

Given Enter username
And Enter password
When Click on Login button 
Then HomePage should be displayed
When Click on CRMSFA link
Then MyHome Page should be displayed
When Click on Leads link
Then MyLeads Page should be displayed
When Click on Find Leads link
Then Find Leads Page should be displayed
When Click on the Phone link
Then Phone Number text field should be displayed
When Enter phone number
And Click on Find Leads button
Then Lead List should be displayed
When Click on first lead
Then View Lead Page should be displayed
When Click on Delete link
#Then 'My Leads' Page should be dislayed
When Click on Find Leads link
And Enter lead id
And Click on Find Leads button
Then Lead should not be displayed

