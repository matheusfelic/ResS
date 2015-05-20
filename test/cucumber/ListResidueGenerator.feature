
Feature: List of Residue Generator
  As a Residue Collector
  I want to list and sort all Residue Generators
  so that I know all Residuo Generators and which Residue Generators are a priority


#if($list)
  Scenario: list existing Residue Generator
    Given the system has a Residue Generator at "Av. Jequitiboca" in it
    When I create a list with all Residue Generators
    Then a list of results containing a Residue Generator at "Av. Jequitiboca" appears

  Scenario: sort list of existing Residue Generator by average daily meal
    Given the system has a Residue Generator at "Av. Capacanama" with average daily meal of "10"
    And the system has a Residue Generator at "Av. Brodewai" with average daily meal of "5"
    When I sort the list content by average daily meals
    Then a list of results sorted by daily meals containing a Residue Generator with address "Av. Capacanama" appears before "Av. Brodewai"

  Scenario: display list
    Given I am at the Residue Generator Show page
    When I click on the List Residue Generators button
    Then I am at the Residue Generator List page

  Scenario: sort by average daily meal
    Given I am at the Residue Generators List page
    When I click on the Sort by Average Daily Meal button
    Then I am at the Residue Generators List page
    And a list with Residue Generators sorted by average daily meal appears

  @ignore #abandonado, tenho que ver como fazer para apagar os gerador
  Scenario: no geradorDeResiduo on system
    Given there are no Residue Generator in the system
    And I am at the Residue Generator Show page
    When I click on the List Residue Generators button
    Then an error message saying there are no stored residue generator should appear
    And I am at the Create Residue Generator page
#end
