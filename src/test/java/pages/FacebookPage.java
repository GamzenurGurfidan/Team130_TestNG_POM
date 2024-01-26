package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "email")
    public WebElement emailKutusu;

    @FindBy(id = "pass")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement girisButonu;

    @FindBy(xpath = "//*[text()='Hesabını bul ve giriş yap.']")
    public WebElement girisYapilamadiYaziElementi;
}
