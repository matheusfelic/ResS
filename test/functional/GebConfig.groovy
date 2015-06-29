import org.openqa.selenium.chrome.ChromeDriver

driver = {
    File file = new File("C:/Users/Holanda Cavalcanti/Downloads/ResS-master/chromedrivers/chromedriver.exe");


    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    new ChromeDriver();
}

baseUrl = "http://localhost:8070/"