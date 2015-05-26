package steps

import ResidueCollector.ResidueCollector
import ResidueCollector.ResidueCollectorController

class CollectorTestDataAndOperations {

    static collectors = [
            [name: "Petrobras", cnpj:"53.406.847/0001-37"],
            [name: "Ong Trevo", cnpj:"11.353.973/0001-20"]
    ]
    static public void createCollector(String name, String cnpj){
        def cont = new ResidueCollectorController()
        cont.params << [cnpj:cnpj] << [name:name]
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public def getCollector(){
        def cont = new ResidueCollectorController()
        cont.params << collectors.get(0)
        cont.create()
        cont.save()
        cont.response.reset()
        return ResidueCollector.findByCnpj("53.406.847/0001-37")
    }

    static public def findCollectorByCnpj(String cnpj) {
       collectors.find {collectors ->
            collectors.cnpj == cnpj
        }
    }
}
