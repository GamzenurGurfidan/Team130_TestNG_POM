package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebPage {
    public ZeroWebPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement usernameKutusu;

    @FindBy(id = "user_password")
    public  WebElement passwordKutusu;

    @FindBy(xpath = "//*[@name='submit']")
    public WebElement signInKutusu;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement loginDogrulamaAdi;

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankingMenu;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsElementi;

    @FindBy(xpath = "(//li[@class='ui-state-default ui-corner-top'])[2]")
    public WebElement purchaseForeignCurrency;

    @FindBy(id = "pc_currency")
    public WebElement currencyDDM;

}
