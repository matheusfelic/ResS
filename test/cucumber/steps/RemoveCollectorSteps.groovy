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

When(~'^I select the collector with CNPJ "([^"]*)"$'){ String p ->
    page.selectResidueCollectorByCNPJ(p)
}

When(~'^I delete the collector$'){->
    page.selectDeleteResidueCollector()
}

Then(~'^a collector with CNPJ "([^"]*)" does not appear on the list$'){String a->
    def b = ResidueCollector.findAll()
    assert ResidueCollector.findByCnpj(a) == null
}