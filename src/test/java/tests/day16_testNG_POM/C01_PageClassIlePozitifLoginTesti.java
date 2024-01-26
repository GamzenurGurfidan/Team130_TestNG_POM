package tests.day16_testNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PageClassIlePozitifLoginTesti {

    @Test
    public void pozitifLoginTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        // 2- account linkine basin
        // 3- Kullanici email'i olarak “wise@gmail.com” girin
        // 4- Kullanici sifresi olarak “12345” girin
        // 5- Login butonuna basarak login olun
        // 6- Basarili olarak giris yapilabildigini test edin

        Driver.getDriver().get("https://www.testotomasyonu.com/");

        //POMde page classlarinda locate ettigimiz WebElementler ulasmak icin
        // page classlarindan obje olustururuz

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.accountLinki.click();

        testOtomasyonPage.emailKutusu.sendKeys("wise@gmail.com");
        testOtomasyonPage.passwordKutusu.sendKeys("12345");
        testOtomasyonPage.loginButonu.click();

        Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());


        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
