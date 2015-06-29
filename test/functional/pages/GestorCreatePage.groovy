package pages

import geb.Page
import steps.GestorTestDataAndOperations

class GestorCreatePage extends Page {

    def titulo = "Criar GestorGenerator"
    static url = "/ResS/gestorGenerator/create"

    static at = {

        title ==~ titulo
    }

    def fillGestorDetails(String cnpj){
        GestorTestDataAndOperations GTDO = new GestorTestDataAndOperations();
        LinkedHashMap gestor = GTDO.getGestor(cnpj);
        $("form").nomeDaEmpresa = gestor.nomeDaEmpresa
        $("form").cNPJ = gestor.cNPJ
        $("form").endereco = gestor.endereco
        $("form").telefone = gestor.telefone
        $("form").email = gestor.email
        $("form").homePage = gestor.homePage

    }

    def selectCreateGestor(){
        $("input", name: "create").click()
    }

}

