Feature: remove a residue collector
  As an administrator
  I want to be able to remove residue collectors
  So that I can remove collectors who no longer offer collecting services

  Scenario: remove a collector
    Given a collector with CNPJ "53.406.847/0001-37" exists in the system
    When I remove a collector with CNPJ "53.406.847/0001-37"
    Then a collector with CNPJ "53.406.847/0001-37" no longer exists in the system

  Scenario: remove a collector GUI
    Given I am at the collector list page
    And a collector with CNPJ "53.406.847/0001-37" exists in the system
    When I click on collector with CNPJ "53.406.847/0001-37" instance
    And I click on delete button
    Then I am at the collector list page
    And a collector with CNPJ "53.406.847/0001-37" does not appear on the list

