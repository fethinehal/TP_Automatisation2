package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.fail;

public class Login {
    WebDriver driver;
    // By userName = By.name("username");
    @FindBy(name = "user-name")
    WebElement userName;
    // By password = By.name("password");
    @FindBy(name = "password")
    WebElement password;
    // By titleText =By.class("alfresco-header-Title__text has-max-width");

    // By login = By.xpath("//button[@type='button']");
    @FindBy(name = "login-button")
    WebElement BtnLogin;
    //Fonction de connexion
    public void loginPageAcceuille(String strUsername, String strPassword) throws InterruptedException {
        this.setUserName(strUsername);
        this.setPassword(strPassword);
        this.clickLogin();
    }
    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setUserName(String strUserName) {
        userName.sendKeys(strUserName);
    }
    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }
    public void clickLogin() {
        BtnLogin.click();
    }
    public void AssertLogin(){
        String expectedurl = "https://www.saucedemo.com/inventory.html";
        String actuelURL = driver.getCurrentUrl();
        System.out.println(actuelURL);
        if (!expectedurl.equals(actuelURL)) {
            fail("la page est introuvable");
        }
    }
}
