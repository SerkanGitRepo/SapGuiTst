Feature: Table Call

Scenario Outline: Via SE16 get table selected data
Given Se16 transaction "<sessionId>" code call
When User "<sessionId>" type table name into textbox
And User fill "<date>" BUDAT "<sessionId>" and POSBN field
Then Statusbar text "<sessionId>" control

Examples:
|sessionId|date|
|0|19.10.2020|
|0|22.10.2020|