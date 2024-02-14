package Test;

import POM.Login;
import POM.PageProduct;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.*;

public class TesterPageConnexion2 {
    WebDriver driver = null;
    Login PageLogin;
    PageProduct PageElement;
    String UserName = "standard_user";
    String Password = "secret_sauce";
    public String url = "https://www.saucedemo.com/";

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional String browser){
        //String browser="chrome";

            if (browser.equalsIgnoreCase("chrome")) {
                System.out.println("******Exécution avec:" + browser);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(url);
            } else if (browser.equalsIgnoreCase("Edge")) {
                System.out.println("******Exécution avec:" + browser);
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get(url);
            }
        }
    @Test(testName = "Test avec données non valide", priority = 2)
    public void Test_données_non_valide() throws InterruptedException {
        System.out.println(" Début de test");

        PageLogin = new Login(driver);
        PageLogin.loginPageAcceuille("12345", "12345");
        String expectedurl = "https://www.saucedemo.com/inventory.html";
        String actuelURL = driver.getCurrentUrl();
        System.out.println(actuelURL);
        if (!expectedurl.equals(actuelURL)) {
            System.out.println("la page est introuvable");
        }
    }

    @Test(testName = "Test avec données non valide", priority = 1)
    public void Test_données_valide() throws InterruptedException {
        System.out.println(" Début de test");
        PageLogin = new Login(driver);
        PageLogin.loginPageAcceuille(UserName, Password);
        PageLogin.AssertLogin();
    }
    @Test(testName = "Recherche element", priority = 3)
    public void Recherche_element() throws InterruptedException {
        System.out.println(" Début de test");
        PageLogin = new Login(driver);
        PageLogin.loginPageAcceuille(UserName, Password);
        PageLogin.AssertLogin();
        PageElement = new PageProduct(driver);
        PageElement.Recherche_Element();
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

