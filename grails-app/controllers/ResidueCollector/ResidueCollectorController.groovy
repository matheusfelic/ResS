package ResidueCollector
import org.springframework.dao.DataIntegrityViolationException

class ResidueCollectorController {

    static allowedMethods = [save:"POST", update:"POST",delete:"POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer MaxItems){
        params.max = Math.min(MaxItems ?: 10, 100)
        [residueCollectorInstanceList: ResidueCollector.list(params),residueCollectorInstanceTotal: ResidueCollector.count()]
    }

    def create(){
        def residueCollector = new ResidueCollector(params)
        [residueCollectorInstanceList: residueCollector]
    }

    def save() {
        def residueCollectorInstance = new ResidueCollector(params)
        if (!residueCollectorInstance.save(flush: true)) {
            render(view: "create", model: [residueCollectorInstance: residueCollectorInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'residueCollector.label', default: 'ResidueCollector'), residueCollectorInstance.id])
        redirect(action: "show", id: residueCollectorInstance.id)
    }

    def show(Long id) {
        def residueCollectorInstance = ResidueCollector.get(id)
        if (!residueCollectorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'residueCollector.label', default: 'residueCollector'), id])
            redirect(action: "list")
            return
        }

        [residueCollectorInstance: residueCollectorInstance]
    }

    def edit(Long id) {
        def residueCollectorInstance = ResidueCollector.get(id)
        if (!residueCollectorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'residueCollector.label', default: 'residueCollector'), id])
            redirect(action: "list")
            return
        }

        [residueCollectorInstance: residueCollectorInstance]
    }

    def update(Long id, Long version) {
        def residueCollectorInstance = ResidueCollector.get(id)
        if (!residueCollectorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'residueCollector.label', default: 'residueCollector'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (residueCollectorInstance.version > version) {
                residueCollectorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'residueCollector.label', default: 'residueCollector')] as Object[],
                        "Another user has updated this residueCollector while you were editing")
                render(view: "edit", model: [residueCollectorInstance: residueCollectorInstance])
                return
            }
        }

        residueCollectorInstance.properties = params

        if (!residueCollectorInstance.save(flush: true)) {
            render(view: "edit", model: [residueCollectorInstance: residueCollectorInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'residueCollector.label', default: 'residueCollector'), residueCollectorInstance.id])
        redirect(action: "show", id: residueCollectorInstance.id)
    }

    def delete(Long id) {
        def residueCollectorInstance = ResidueCollector.get(id)
        if (!residueCollectorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'residueCollector.label', default: 'residueCollector'), id])
            redirect(action: "list")
            return
        }

        try {
            residueCollectorInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'residueCollector.label', default: 'residueCollector'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'residueCollector.label', default: 'residueCollector'), id])
            redirect(action: "show", id: id)
        }
    }
}
