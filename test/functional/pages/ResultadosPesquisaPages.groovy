package pages

import geb.Page

class ResultadosPesquisaPages extends Page {
    def titulo = "Resultados da Pesquisa"
    static url = "ResS/residueGenerator/search"

    static at = {
        title ==~ titulo
    }
}
