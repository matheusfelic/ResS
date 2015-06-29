package pages

import geb.Page

class GithubPage extends Page {

    def título = "pauloborba/ResS · GitHub"
    static url = "https://github.com/pauloborba/ResS"

    static at = {
        title ==~ título
    }
}
