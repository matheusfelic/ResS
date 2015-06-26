Feature: Edit a residue collector information
  As a residue collector
  I want to be able to modify my information
  So that I can guarantee all information is up to date

  #if ($ Editar um coletor)
  Scenario: Edit a colector
    Given a collector with name "Teste 4" and CNPJ "53.406.847/0001-20" exists in the system
    When I change the cnpj "53.406.847/0001-20" to "53.406.847/0001-21"
    And a collector with CNPJ "53.406.847/0001-21" is stored in the system

  #if ($ Editar CNPJ para CNPJ invalido)
  Scenario: Editing the CNPJ to an invalid value
    Given a collector with name "Teste 3" and CNPJ "53.406.847/0001-39" exists in the system
    When I change the cnpj "53.406.847/0001-39" to "asdasdasd"
    Then the residue collector with cnpj "53.406.847/0001-39" is left unchanged
  #end

  #if ($ Editar CNPJ para CNPJ ja existente)
  Scenario: Editing CNPJ to a CNPJ already in system
    Given a collector with name "Teste 4" and CNPJ "53.406.847/0001-40" exists in the system
    And a collector with name "Teste 5" and CNPJ "53.406.847/0001-41" exists in the system
    When I change the cnpj "53.406.847/0001-41" to "53.406.847/0001-40"
    Then only one collector with CNPJ "53.406.847/0001-40" is stored in the system
    And a collector with CNPJ "53.406.847/0001-41" is stored in the system
  #end

  #if ($ Editar por GUI)
