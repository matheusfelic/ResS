  Feature: List of geradorDeResiduo.
    As a coletorDeResiduo.
    I want to list and sort all geradorDeResiduo.
    so that I know all geradorDeResiduo and which geradorDeResiduo are a priority.


  #if($list)
    Scenario: list existing geradorDeResiduo.
     Given the system has a geradorDeResiduo named "Restaurante Universitario" in it.
     When I create a list with all geradorDeResiduo.
     Then a list of results containing "Restaurante Universitario" appears.

    Scenario: sort list of existing geradorDeResiduo by volume of residue.
     Given the system has a geradorDeResiduo named "Restaurante Universitario" with volume "10".
     And the system has a geradorDeResiduo named "Cantina da Area 2" with volume "2".
     When I sort the list content by volume.
     Then a list of results containing "Restaurante Universitario" appears.
     And a list of results containing "Cantina da Area 2" appears.
     And "Restaurante Universitario" appears before "Cantina Area 2".

    Scenario: display list.
     Given I am on the Index page.
     When I click on the Residue Generators List button.
     Then I am on the Residuo Generator List page.
     And a list of geradorDeResiduo is displayed.

    Scenario: sort by volume.
     Given I am at the Residue Generators List page.
     When I click on the Sort by Volume button.
     Then I am on the Residue Generators List page.

    Scenario: no geradorDeResiduo on system.
     Given there are no geradorDeResiduo in the system.
     And I am at the "Gerador de Residuos" page.
     When I click on the "Organizar por volume de residuo" button.
     Then an error message "Nao ha gerador de residuo para a lista ser organizada" appears.
     And I am on the "Gerador de Residuos" page.
  #end