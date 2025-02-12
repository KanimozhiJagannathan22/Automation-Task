Feature: orange

  Scenario: Login
    Given open browser and enter url
    When enter username, password and click on login
    When click on logout
    And close browser

  Scenario: parameter
  Given open browser and enter url
    When enter "Admin","admin12" and click on login
    When click on logout
    And close browser
    
    Scenario Outline: Datadriven
     Given open browser and enter url
    When enter "<username>","<password>" and click on login
    When click on logout
    And close browser
    
    Examples:
    |username|password|
		|Admin|admin123|


    
    

  
  