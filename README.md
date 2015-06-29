# ResS_Project

Grails 2.1.5
ChromeDriver 2.1.5
JDK 1.7.0_65 SDK 7
Cucumber 0.10.0
Geb 0.9.2
Selenium 2.39.0

-------------------------------------------------------------------------------------------------------------------

Mark as Test Source todas as subpastas imediatas de test (não as subpastas das subpastas)
Em GebConfig.groovy setar caminho do chromeDriver no File (2.1.5)

-------------------------------------------------------------------------------------------------------------------

Arquivos Modificados:

conf.BuildConfig
cucumber.support.env.groovy
cucumber.CucumberGebSupport.gdsl
functional.GebConfig.groovy
conf.spring.CucumberConfig.groovy
-------------------------------------------------------------------------------------------------------------------

P/ testar:  test-app functional:cucumber --stacktrace
