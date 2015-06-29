package gestorGenerator



import org.junit.*
import grails.test.mixin.*

@TestFor(GestorGeneratorController)
@Mock(GestorGenerator)
class GestorGeneratorControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/gestorGenerator/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.gestorGeneratorInstanceList.size() == 0
        assert model.gestorGeneratorInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.gestorGeneratorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.gestorGeneratorInstance != null
        assert view == '/gestorGenerator/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/gestorGenerator/show/1'
        assert controller.flash.message != null
        assert GestorGenerator.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/gestorGenerator/list'

        populateValidParams(params)
        def gestorGenerator = new GestorGenerator(params)

        assert gestorGenerator.save() != null

        params.id = gestorGenerator.id

        def model = controller.show()

        assert model.gestorGeneratorInstance == gestorGenerator
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/gestorGenerator/list'

        populateValidParams(params)
        def gestorGenerator = new GestorGenerator(params)

        assert gestorGenerator.save() != null

        params.id = gestorGenerator.id

        def model = controller.edit()

        assert model.gestorGeneratorInstance == gestorGenerator
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/gestorGenerator/list'

        response.reset()

        populateValidParams(params)
        def gestorGenerator = new GestorGenerator(params)

        assert gestorGenerator.save() != null

        // test invalid parameters in update
        params.id = gestorGenerator.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/gestorGenerator/edit"
        assert model.gestorGeneratorInstance != null

        gestorGenerator.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/gestorGenerator/show/$gestorGenerator.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        gestorGenerator.clearErrors()

        populateValidParams(params)
        params.id = gestorGenerator.id
        params.version = -1
        controller.update()

        assert view == "/gestorGenerator/edit"
        assert model.gestorGeneratorInstance != null
        assert model.gestorGeneratorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/gestorGenerator/list'

        response.reset()

        populateValidParams(params)
        def gestorGenerator = new GestorGenerator(params)

        assert gestorGenerator.save() != null
        assert GestorGenerator.count() == 1

        params.id = gestorGenerator.id

        controller.delete()

        assert GestorGenerator.count() == 0
        assert GestorGenerator.get(gestorGenerator.id) == null
        assert response.redirectedUrl == '/gestorGenerator/list'
    }
}
