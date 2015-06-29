Feature: Gestor cadastre

  As an administrator
  I want to cadastre a new account
  So that I can use and manage information of these gestors


  Scenario: Gestor cadastre

    Given the system has no cadastre with CNPJ "77.274.871/0001-28"
    When i try to create an account with CNPJ "77.274.871/0001-28"
    Then the account is stored properly in the system

  Scenario: gestor cadastre without website

    Given the system has no cadastre with CNPJ "58391029"
    When i try to create an account with CNPJ"58391029" without a website
    Then the account is properly stored in the system

  Scenario: gestor cadastre with Phone number field not containing only numbers

    Given i want to cadastre a new gestor with CNPJ "59182195"
    When i try to create an account with Phone number field "fa22-gja2"
    Then the account with phone number "fa22-gja2" is not stored in the system


  Scenario: gestor cadastre web

    Given i am at the gestor cadastre page
    When i fill all the registration data fields correctly
    And  try to create my account
    Then i should see a message confirming the creation


  Scenario: gestor cadastre without website web

    Given i am at the gestor cadastre page
    And the system has no cadastre with CNPJ ""
    When i fill all the registration data fields except for the website
    And  try to create my account
    Then i should see a message confirming the creation


  Scenario: gestor cadastre with phone number field not containing only numbers web

    Given i am at the gestor cadastre page
    When i fill the "phone number" field with "fa22-gja0"
    And try to create my account
    Then i should see an error message