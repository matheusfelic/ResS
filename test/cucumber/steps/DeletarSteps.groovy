package steps

import pages.ResidueGeneratorEditPage
import residueGenerator.ResidueGenerator
import pages.PesquisaPages
import static cucumber.api.groovy.EN.*

Given(~'^Estou na pagina de editar do ponto "([^"]*)"$'){
    to ResidueGeneratorEditPage
}

When(~'^deleto o ponto aceitando a mensagem de confirmação'){ ->
    assert withConfirm(true) {$("input", name: "_action_delete").click() } == "Tem certeza?"
}

Then(~'^a deleção é confirmada'){ ->
    at PesquisaPages
}

Then(~'^O ponto continua no sistema'){ ->
    at ResidueGeneratorEditPage
}

When(~'^Desisto de deletar um ponto recusando a mensagem de confirmação'){ ->
    assert withConfirm(false) {$("input", name: "_action_delete").click() } == "Tem certeza?"
}