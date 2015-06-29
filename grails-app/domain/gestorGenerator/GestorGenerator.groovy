package gestorGenerator


class GestorGenerator {

    String nomeDaEmpresa;
    String cNPJ;
    String endereco;
    String telefone;
    String email;
    String homePage;

    static constraints = {

        nomeDaEmpresa (nullable: false, blank: false, unique: true );
        cNPJ (nullable: false, blank: false, unique: true)
        telefone (nullable: false,blank: false,matches: "^[0-9]{8}" )
        email (nullable: false, email: true, blank: false);
        endereco (nullable: false, blank: false);
        homePage (nullable: true, blank : true);


    }

}
