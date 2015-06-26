package steps

import ResidueCollector.ResidueCollector
import geb.Page
import static cucumber.api.groovy.EN.*
//CONTROLLER TESTS


When(~'^I change the cnpj "([^"]*)" to "([^"]*)"$'){String oldCnpj, String newCnpj->
    cnpjnew = newCnpj
    CollectorTestDataAndOperations.editCollector(oldCnpj,cnpjnew)
}

Then(~'the residue collector with cnpj "([^"]*)" is left unchanged$'){String cnpj ->
    assert ResidueCollector.findByCnpj(cnpj) != null
}