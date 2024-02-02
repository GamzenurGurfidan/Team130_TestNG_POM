package tests.day16_testNG_POMg;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_ConfigurationPropertiesDosyasiKullanma {

    @Test
    public void pozitifLoginTesti(){
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        // 2- account linkine basin
        // 3- Kullanici email'i olarak “wise@gmail.com”girin
        // 4- Kullanici sifresi olarak “12345” girin
        // 5- Login butonuna basarak login olun
        // 6- Basarili olarak giris yapilabildigini test edin

        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();

        testOtomasyonPage.accountLinki.click();

        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        testOtomasyonPage.loginButonu.click();

        Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());

        Driver.quitDriver();

    }
}
