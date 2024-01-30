package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuAddRemovePage {
    public TestOtomasyonuAddRemovePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "h2")
    public WebElement addRemoveYaziElementi;

    @FindBy(xpath = "//*[text()='Electronics Products']")
    public WebElement electronicsProductLinki;

    @FindBy(xpath = "//*[@class='current']")
    public WebElement electronicsSayfasiDogrulama;

    @FindBy(xpath = "//*[@class='product-box mb-2 pb-1']")
    public List<WebElement> bulunanElementlerList;
}
