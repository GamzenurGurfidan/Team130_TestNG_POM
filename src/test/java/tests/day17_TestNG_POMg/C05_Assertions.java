package tests.day17_TestNG_POMg;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_Assertions {
    @Test
    public void aramaTesti (){

        // testotomasyonu anasayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        // sayfaya gittiginizi test edin
        String expectedURL = ConfigReader.getProperty("toURL")+"/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);

        // phone için arama yapın

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // bulunan urun sayisinin 3den falza oldugunu test edin
        int expectedUrunSayisi = 3;
        int actualUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualUrunSayisi > expectedUrunSayisi);

        // ilk ürüne tiklayin
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        // acilan urun sayfasindai urun isminin
        // case sensetive olmadan phone içerdigini test edin
        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsimElementi = testOtomasyonPage.urunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsimElementi.contains(expectedUrunIsimIcerik));
        // sayfayi kapatin

        Driver.quitDriver();

    }
}
