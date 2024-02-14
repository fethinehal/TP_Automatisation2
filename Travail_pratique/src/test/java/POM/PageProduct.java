package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PageProduct {
    WebDriver driver;
    public PageProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Recherche_Element(){
        List<WebElement> ListLesProduits = driver.findElements(By.tagName("a"));
        int k= 0;
        for(int i= 0; i < ListLesProduits.size() - 1; i++){
            String a = ListLesProduits.get(i).getText();
            String b = ListLesProduits.get(i+1).getText();
            k= k+(a.compareTo(b));
        }
        System.out.println("--------------résultat =" + k);
        Assert.assertTrue(k<0,"L'ordre est décrroissant");
        System.out.println("L'ordre des produits est croissant");
        for(WebElement link:ListLesProduits){
            if(!link.getText().equals("Twitter")& !link.getText().equals("Facebook")
                    &!link.getText().equals("LinkedIn")) {
                System.out.println(link.getText());
            }
        }
    }
}
