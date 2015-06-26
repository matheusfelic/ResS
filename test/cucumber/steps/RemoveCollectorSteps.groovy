package steps

import static cucumber.api.groovy.EN.*
import ResidueCollector.ResidueCollector
import ResidueCollector.ResidueCollectorController
import pages.ResidueCollectorListPage


When(~'^I remove a collector with CNPJ "([^"]*)"$'){String a ->
    collectorToGetAxed = ResidueCollector.findByCnpj(a)
    collectorToGetAxed.delete(flush:true)
    assert ResidueCollector.findByCnpj(a) == null
}

Then(~'^a collector with CNPJ "([^"]*)" no longer exists in the system$'){String p ->
    assert ResidueCollector.findByCnpj(p) == null
}

When(~'^I click on collector with CNPJ "([^"]*)" instance$'){ String p ->
    page.selectResidueCollectorByCNPJ(p)
}

When(~'^I click on delete button$'){->
    page.selectDeleteResidueCollector()
}

Then(~'^a collector with CNPJ "([^"]*)" does not appear on the list$'){String a->
    listaCollectors = ResidueCollector.findByCnpj(a)
    assert listaCollectors == null
}