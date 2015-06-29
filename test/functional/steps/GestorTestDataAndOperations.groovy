package steps

import gestorGenerator.GestorGenerator
import gestorGenerator.GestorGeneratorController

class GestorTestDataAndOperations{


    static gestors = [

            [nomeDaEmpresa:"RU",
             cNPJ:"77.274.871/0001-28",
             endereco: "Bubble Street number 7",
             telefone:"34524412",
             email:"jose@hotmail.com",
             homePage:"supimpa.com.br"],

            [nomeDaEmpresa:"ADUFEPE",
             cNPJ:"58391029",
             endereco:"Bubble Street number 4",
             telefone:"22241415",
             email:"maria@hotmail.com",
             homePage:""],

            [nomeDaEmpresa:"IFPE",
             cNPJ:"24192843",
             endereco:"Bubble Street number 12",
             telefone:"fa22-gja0",
             email:"ifpe@hotmail.com",
             homePage:"ifpe.com.br"],



    ]

    static public def getGestor(String cnpj){
        return findGestorByCnpj(cnpj)
    }

    static public def findGestorByCnpj(String cnpj) {
        gestors.find { gestor ->
            gestor.cNPJ == cnpj
        }
    }

    static public def findGestorByPhone(String phone){
        gestors.find{ gestor ->
            gestor.telefone == phone
        }
    }

    static public void createGestor(String cnpj){
        def cont = new GestorGeneratorController()
        def novoGestor = findGestorByCnpj(cnpj)
        cont.params << novoGestor.getProperties()
        cont.create()
        cont.save()
        cont.response.reset()
    }


}