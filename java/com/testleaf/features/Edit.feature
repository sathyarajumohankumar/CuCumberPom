Feature: Edit Lead Functionality

@Sanity 
Scenario Outline: Positive flow for Edit Lead

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
When Enter firstName as <firstName>
And Click on Find Leads button
Then Lead List should be displayed
When Click on first lead
Then View Lead Page should be displayed
When Click on Edit link
Then Edit Lead Page should be displayed
When Clear company name
Then Company name should be cleared
When Update company name to <newCompName>
And Click on Update button
Then View Lead Page should be displayed
Then Verify <newCompName>  is updated


 Examples:

|firstName|newCompName|
|'kobra'|'Edyec'|