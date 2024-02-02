package tests.day19_TestNGReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluAramaSepetiTesti extends TestBaseRapor {
    @Test
    public void aramaSepetiTesti (){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        // 2- phone icin arama yapin
        // 3- Listelenen sonuclardan ilkini tiklayin
        // 4- urun ismini kaydedin ve sepete ekleyin
        // 5- your cart linkine tiklayin
        // 6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        // 7- sayfayi kapatin

        extentTest = extentReports.createTest("arama sepeti testi","sepetes attigimiz urun ismi ile sepetteki urun ismi ayni olmali");

        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        extentTest.info("kullanici testotomasyonu anasayfaya gider");

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        extentTest.info("phone icin arama yapar");

        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        extentTest.info("listenen sonuclardan ilkine tiklar");

        String sayfadakiUrunIsmi = testOtomasyonPage.urunIsimElementi.getText();
        testOtomasyonPage.sepetButonu.click();

        extentTest.info("ürün ismini kaydeder ve sepete ekler");

        testOtomasyonPage.yourCartButonu.click();
        extentTest.info("your cart linkine tiklar");

        String sepettekiUrunIsmi = testOtomasyonPage.sepettekiUrunIsmi.getText();

        ReusableMethods.bekle(2);

        Assert.assertEquals(sepettekiUrunIsmi,sayfadakiUrunIsmi);

        extentTest.pass("kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test eder");

        Driver.quitDriver();
        extentTest.info("sayfayi kapatir");

    }
}
