package steps

import residueGenerator.ResidueGenerator
import residueGenerator.ResidueGeneratorController

/**
 * Created by Win7 on 02/05/2015.
 */

class residueGeneratorTestDataAndOperations {

    static generators = [
            [nameGenerator:"RU",
             type: "Restaurante",
             cnpj: "testecnpj1",
             addressGenerator: "ufpe",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0,
             volume: 30f],
            [nameGenerator:"Area2",
             type: "Cantina",
             cnpj: "testecnpj2",
             addressGenerator: "Area 2",
             averageMonthlyMeals: 0,
             averageDailyMeals: 0,
             volume: 5f]
    ]

    static public def findResidueGeneratorByAddress(String address) {
        generators.find { residueGenerator ->
            residueGenerator.addressGeneratorGenerator == address
        }
    }

    static public void createResidueGenerator(String title, String endereco){
        def cont = new ResidueGeneratorController()
        def tempGerador = findResidueGeneratorByAddress(endereco)
        cont.params << tempGerador << [nameGenerator:title]
        cont.request.setContent(new byte[1000])
        cont.create()
        cont.save()
        cont.response.reset()
    }



    static public boolean containResidueGenerator(String title,ResidueGenerator[] ResGen){
        def testresidue = ResidueGenerator.findByAddressGenerator(title)
        def answer = ResGen.any(testresidue.getAt(1))
        return answer
    }

    static public def isSorted(ResidueGenerator[] ResGen,String desiredOrder){
        def isSorted = false
        switch(desiredOrder) {
            case 'nameGenerator':
                isSorted = (ResGen.size() < 2 || (1..<ResGen.size()).every() {(ResGen[it - 1].nameGenerator).compareTo(ResGen[it].nameGenerator) < 0})
                break
            case 'volume':
                isSorted = (ResGen.size() < 2 || (1..<ResGen.size()).every() {(ResGen[it - 1].volume) > ResGen[it].volume})
                break
        }
        return isSorted
    }
}
