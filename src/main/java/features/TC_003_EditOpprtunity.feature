Feature: Edit Opprtunity

Scenario Outline: Edit Opprtunity through Home Page

Given User is on Home Page click on toggle menu from left corner
And Click view All and click Sales from App Launcher
And  Click on Opportunity tab 
Then New Opprtunity page is opened
Given Enter Opprtunity Name as <oppName> and save the text
And select close date as today 
And Select Stage as <stageValue>
When click on Save
Then Opprtunity Name is Verified as <verifyName>


Examples:
|oppName||stageValue||verifyName|
|'Salesforce Automation by Hemanth'||'Needs Analysis'||'Salesforce Automation by Hemanth'|