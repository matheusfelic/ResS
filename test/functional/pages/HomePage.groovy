package pages
import geb.Page
class HomePage extends Page {

    def título = "ResS"
    static url = "/ResS"

    static at = {
        title ==~ título
    }

    def selectResidueGeneratorArea(){
        $('#ResidueGenerator').click();
    }

    def selectGithubRibbon(){
        $('#forkongithublink').click();
    }
}
