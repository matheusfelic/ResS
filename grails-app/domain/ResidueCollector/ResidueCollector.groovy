package ResidueCollector


class ResidueCollector {

    String collectorName
    String cnpj

    static constraints = {

        collectorName blank:false, nullable:false
        cnpj blank:false, nullable:false, MaxSize: 18, MinSize:18, unique: true


    }
}
