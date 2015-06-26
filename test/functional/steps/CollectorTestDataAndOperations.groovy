package steps

import ResidueCollector.ResidueCollector
import ResidueCollector.ResidueCollectorController

class CollectorTestDataAndOperations {

    static collectors = [
            [collectorName: "Test", cnpj:"53.406.847/0001-36"],
            [name: "Ong Trevo", cnpj:"11.353.973/0001-20"]
    ]


    static public void createCollector(String nome, String ncnpj){
        def cont = new ResidueCollectorController()
        def novoCollector = getCollector()
        cont.params << novoCollector << [collectorName: nome] << [cnpj:ncnpj]
        cont.create()
        cont.save()
        cont.response.reset()
    }

    static public void editCollector(String oldCNPJ,String newCNPJ){
        def existingCollector = ResidueCollector.findByCnpj(newCNPJ)
        def oldCollector = ResidueCollector.findByCnpj(oldCNPJ)
        if(newCNPJ != null && newCNPJ.size()==18 && existingCollector==null) {
            createCollector("TestEdit", newCNPJ)
            oldCollector.delete(flush: true)
            }
    }

    static public def getCollector(){
        return findCollectorByCnpj("53.406.847/0001-36")
    }

    static public def findCollectorByCnpj(String novCnpj) {
        collectors.find { collector ->
            collector.cnpj == novCnpj
        }
    }
}
