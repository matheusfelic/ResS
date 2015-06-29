package pages
import geb.Page

class ResidueGeneratorIndexPage extends Page {

    def título = "Residue Generator List"
    static url = "/ResS/residueGenerator/list"

    static at = {
        title ==~ título
    }

}
