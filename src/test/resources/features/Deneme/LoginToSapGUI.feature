Feature: Login To SAP via GUI
Scenario Outline: Login With SystemName Client UserName nad Password
Given User Open SAP Logon App "<SapSys>"
When User enter "<username>" and "<password>" and send enter
And SAP Sys "<client>" Info "<SapLang>" fill 
Then User should be login

Examples:
|SapSys|username|password|client|SapLang|
|PSQ|serkanaks|Zorlu.8383|021|TR|


 