
Feature: Pesquisa de pontos de coleta
  As a membro da empresa coletora
  I want to pesquisar pontos de coleta aos quais eu esteja associado
  so that eu possa obter suas informações cadastrais

  Scenario: Pesquisa por nome do ponto
    Given Existe no sistema um ponto chamado "RU"
    When procuro por "RU"
    Then consigo obter o perfil do "RU"

  Scenario: Pesquisa por nome cnpj do ponto
    Given Existe um cnpj de ponto de coleta com o numero "testecnpj1"
    When pesquiso o ponto pelo cnpj "testecnpj1"
    Then consigo obter o perfil do ponto com cnpj "testecnpj1"

  Scenario: Pesquisa de pontos não encontrados
    Given Nao existe no sistema um ponto chamado "Area 2"
    When pesquiso pelo ponto "Area 2"
    Then Nao eh possivel se obter o ponto "Area 2"

  Scenario: Pesquisa de pontos encontrados
    Given Eu estou logado na pagina de pesquisa
    When pesquiso por "RU"
    Then A lista de pontos com o nome procurado aparecera


