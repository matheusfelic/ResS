package pages
import geb.Page

/**
 * Created by Win7 on 02/05/2015.
 */
class ResidueGeneratorListPage extends Page {
    static url = "residuegenerator/list"

    static at = {
        String gp = "Lista de Geradores de Residuo"
        title ==~ gp
    }

}
