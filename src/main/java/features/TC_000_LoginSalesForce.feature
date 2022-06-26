Feature: Login

Scenario Outline: Login Sales Force

Given User is in Login Page
And User Enter Username as <uName>
And User Enter Password as <pwd>
When User clicks on Login
Then Home page is displayed

Examples:
|uName||pwd|
|'ramkumar.ramaiah@testleaf.com'||'Password@123'|