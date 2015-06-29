package residueGenerator

import harvestCompany.HarvestCompany

class GeneratorHarvestSolicitationController {

    def index(long id) {
        def residueGeneratorInstance = ResidueGenerator.get(id)
        if(!residueGeneratorInstance.hasActiveHarvest){
            redirect(action:"create", id : residueGeneratorInstance.id)
            return
        }

        String harvester = HarvestCompany.get(residueGeneratorInstance.harvestSolicitation.harvesterId).name

        render(view: "index", model: [residueGeneratorInstance: residueGeneratorInstance, harvester:harvester])
    }

    def create(long id){
        List<HarvestCompany> companyList = HarvestCompany.findAll();
        def harvestSolicitationInstance = new HarvestSolicitation(generatorId: id);
        render(view: "create", model: [harvestSolicitationInstance: harvestSolicitationInstance, companyList:companyList] )
    }

    def save(){
        def harvestSolicitationInstance = new HarvestSolicitation(params)
        harvestSolicitationInstance.solicitationDate = new Date()
        harvestSolicitationInstance.status = "Pendente"
        harvestSolicitationInstance.residueGenerator = ResidueGenerator.get(harvestSolicitationInstance.generatorId)

        if(!harvestSolicitationInstance.save(flush: true)){
            List<HarvestCompany> companyList = HarvestCompany.findAll();
            render(view: "create", model: [harvestSolicitationInstance: harvestSolicitationInstance, companyList:companyList])
            return
        }
        def residueGenerator = ResidueGenerator.get(harvestSolicitationInstance.generatorId);
        residueGenerator.harvestSolicitation = harvestSolicitationInstance;
        residueGenerator.hasActiveHarvest = true;
        residueGenerator.save(flush: true)
        redirect(action: "index", id: harvestSolicitationInstance.generatorId)
    }


}
