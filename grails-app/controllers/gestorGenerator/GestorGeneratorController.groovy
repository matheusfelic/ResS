package gestorGenerator

import org.springframework.dao.DataIntegrityViolationException

class GestorGeneratorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [gestorGeneratorInstanceList: GestorGenerator.list(params), gestorGeneratorInstanceTotal: GestorGenerator.count()]
    }

    def create() {
        [gestorGeneratorInstance: new GestorGenerator(params)]
    }

    def save() {
        def gestorGeneratorInstance = new GestorGenerator(params)
        if (!gestorGeneratorInstance.save(flush: true)) {
            render(view: "create", model: [gestorGeneratorInstance: gestorGeneratorInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'gestorGenerator.label', default: 'GestorGenerator'), gestorGeneratorInstance.id])
        redirect(action: "show", id: gestorGeneratorInstance.id)
    }

    def show(Long id) {
        def gestorGeneratorInstance = GestorGenerator.get(id)
        if (!gestorGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gestorGenerator.label', default: 'GestorGenerator'), id])
            redirect(action: "list")
            return
        }

        [gestorGeneratorInstance: gestorGeneratorInstance]
    }

    def edit(Long id) {
        def gestorGeneratorInstance = GestorGenerator.get(id)
        if (!gestorGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gestorGenerator.label', default: 'GestorGenerator'), id])
            redirect(action: "list")
            return
        }

        [gestorGeneratorInstance: gestorGeneratorInstance]
    }

    def update(Long id, Long version) {
        def gestorGeneratorInstance = GestorGenerator.get(id)
        if (!gestorGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gestorGenerator.label', default: 'GestorGenerator'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (gestorGeneratorInstance.version > version) {
                gestorGeneratorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'gestorGenerator.label', default: 'GestorGenerator')] as Object[],
                          "Another user has updated this GestorGenerator while you were editing")
                render(view: "edit", model: [gestorGeneratorInstance: gestorGeneratorInstance])
                return
            }
        }

        gestorGeneratorInstance.properties = params

        if (!gestorGeneratorInstance.save(flush: true)) {
            render(view: "edit", model: [gestorGeneratorInstance: gestorGeneratorInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'gestorGenerator.label', default: 'GestorGenerator'), gestorGeneratorInstance.id])
        redirect(action: "show", id: gestorGeneratorInstance.id)
    }

    def delete(Long id) {
        def gestorGeneratorInstance = GestorGenerator.get(id)
        if (!gestorGeneratorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gestorGenerator.label', default: 'GestorGenerator'), id])
            redirect(action: "list")
            return
        }

        try {
            gestorGeneratorInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'gestorGenerator.label', default: 'GestorGenerator'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'gestorGenerator.label', default: 'GestorGenerator'), id])
            redirect(action: "show", id: id)
        }
    }
}
