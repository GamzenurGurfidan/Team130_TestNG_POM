package tests.day18_softAssertion_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_WebAppTesti {
    @Test
    public void test01(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroURL"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        String expectedURL = ConfigReader.getProperty("zeroURL");
        String actualURL = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualURL,expectedURL,"URL testi FAILED");

        // 3. Sign in butonuna basin
        ZeroWebPage zeroWebPage = new ZeroWebPage();
        zeroWebPage.signInButton.click();

        // 4. Login kutusuna “username” yazin
        zeroWebPage.usernameKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliUsername"));

        // 5. Password kutusuna “password” yazin
        zeroWebPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));

        // 6. Sign in tusuna basin
        zeroWebPage.signInKutusu.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroWebPage.loginDogrulamaAdi.isDisplayed(),"Giris Yapildi Testi FAILED");

        // 9. Online banking menusunu tiklayin
        zeroWebPage.onlineBankingMenu.click();

        //10. Pay Bills sayfasina gidin
        zeroWebPage.payBillsElementi.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroWebPage.purchaseForeignCurrency.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebPage.currencyDDM.isEnabled());

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select currencySelect = new Select(zeroWebPage.currencyDDM);
        currencySelect.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedSecilenOption = "Eurozone (euro)";
        String actualSecilenOption = currencySelect.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSecilenOption,expectedSecilenOption,"Eurozone secim testi FAILED");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        int expectedOptionSayisi = 16;
        int actualOptionSayisi = currencySelect.getOptions().size();

        softAssert.assertEquals(actualOptionSayisi,expectedOptionSayisi,"dropdown option sayisi testi FAILED");
        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        List<WebElement> dropdownOptionElementleriList = currencySelect.getOptions();

        List<String> dropdownOptionsListesi = ReusableMethods.stringListeCevir(dropdownOptionElementleriList);


        String expectedOptionIcerik = "Canada (dollar)";
        softAssert.assertTrue(dropdownOptionsListesi.contains(expectedOptionIcerik),"Canada FAILED");

        //17. Sayfayi kapatin

        Driver.quitDriver();

    }
}
