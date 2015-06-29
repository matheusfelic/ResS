package steps

import pages.ResultadosPesquisaPages
import residueGenerator.ResidueGenerator
import pages.PesquisaPages
import static cucumber.api.groovy.EN.*

Given(~'^Existe no sistema um ponto chamado "([^"]*)"$') { String Gerador ->
    assert GeneratorTestDataAndOperations.createGeneratorName(Gerador) == null
}
When (~'^procuro por "([^"]*)"$') { String nomeGerador ->
    assert ResidueGenerator.findByNameGenerator(nomeGerador) != null
}
Then (~'^consigo obter o perfil do "([^"]*)"$'){ String gerador ->
    GeneratorTestDataAndOperations.showGenerator(gerador)
}

Given(~'^Existe um cnpj de ponto de coleta com o numero "([^"]*)"$'){ String cnpj ->
    assert GeneratorTestDataAndOperations.createGeneratorCnpj(cnpj) == null
}

When(~'^pesquiso o ponto pelo cnpj "([^"]*)"$'){ String cnpj ->
    assert ResidueGenerator.findByCnpj(cnpj) != null
}

Then(~'^consigo obter o perfil do ponto com cnpj "([^"]*)"$'){ String cnpj->
    GeneratorTestDataAndOperations.showGeneratorByCnpj(cnpj)
}

Given(~'^Nao existe no sistema um ponto chamado "([^"]*)"$'){ String gerador ->
    assert ResidueGenerator.findByNameGenerator(gerador) == null
}

When(~'^pesquiso pelo ponto "([^"]*)"$'){ String gerador ->
    assert ResidueGenerator.findByNameGenerator(gerador) == null
}
Then(~'^Nao eh possivel se obter o ponto "([^"]*)"$'){ String gerador ->
    GeneratorTestDataAndOperations.showGenerator(gerador)
}

Given(~'Eu estou logado na pagina de pesquisa'){ ->
    to PesquisaPages
    at PesquisaPages
}
When(~'^pesquiso por "([^"]*)"$'){ String gerador ->
    assert page.realizarBusca(gerador) != null
}

Then(~'A lista de pontos com o nome procurado aparecera'){ ->
    at ResultadosPesquisaPages
}