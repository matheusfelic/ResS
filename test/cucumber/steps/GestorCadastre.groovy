package steps

import pages.ResidueGeneratorShowPage
import steps.GestorTestDataAndOperations
import pages.GestorCreatePage
import gestorGenerator.GestorGenerator
import static cucumber.api.groovy.EN.*

//Gestor cadastre
Given(~'^the system has no cadastre with CNPJ "([^"]*)"$') { String cnpj ->
    gestor = GestorGenerator.findByCNPJ(cnpj)
    assert gestor == null
}
When(~'^i try to create an account with CNPJ "([^"]*)"$'){ String cNPJ ->
    cnpj = cNPJ
    GestorTestDataAndOperations.createGestor(cNPJ)
}

Then(~'^the account is stored properly in the system$') { ->
    assert GestorTestDataAndOperations.findGestorByCnpj(cnpj) != null
}

//Gestor cadastre without website
When(~'^i try to create an account with CNPJ"([^"]*)" without a website$'){ String cnpj ->
    GestorTestDataAndOperations.createGestor(cnpj)
    CNPJ = cnpj
}

Then(~'^the account is properly stored in the system$') { ->
    assert GestorTestDataAndOperations.findGestorByCnpj(CNPJ) != null
}

//Gestor cadastre with Phone number field not containing only numbers
Given(~'^i want to cadastre a new gestor with CNPJ "([^"]*)"$') {String CNPj  ->
    assert GestorTestDataAndOperations.findGestorByCnpj(CNPj) == null
    CNpj = CNPj
}
When(~'^i try to create an account with Phone number field "([^"]*)"$'){ String phone ->
    GestorTestDataAndOperations.createGestor(CNpj)
}

Then(~'^the account with phone number "([^"]*)" is not stored in the system$') { String telefone ->
    assert GestorTestDataAndOperations.findGestorByPhone(telefone) == null
}

//Gestor cadastre web
Given(~'^i am at the gestor cadastre page$') { ->
    to GestorCreatePage
    at GestorCreatePage
}

//Gestor cadastre web without website field
When(~'^i fill all the registration data fields except for the website$') { ->
    page.fillGestorDetails(CNPJ)
}

When(~'^i fill all the registration data fields correctly$') { ->
    page.fillGestorDetails(cnpj)
}
And(~'^try to create my account') { ->
    page.selectCreateGestor()
}
Then(~'^i should see a message confirming the creation$') { ->

}
And(~'^i am redirected to the home page$') {  ->
    to ResidueGeneratorShowPage
    at ResidueGeneratorShowPage
}

//Gestor cadastre web with phone number not containing only numbers
When(~'^i fill the "phone number" field with "([^"]*)"$'){ String numberField ->
    gestorTest = GestorTestDataAndOperations.findGestorByPhone(numberField)
    page.fillGestorDetails(gestorTest.cNPJ)
}
Then(~'^i should see an error message$'){ ->

}
