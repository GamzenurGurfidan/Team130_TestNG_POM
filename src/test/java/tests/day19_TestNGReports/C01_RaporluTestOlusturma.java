package tests.day19_TestNGReports;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluTestOlusturma extends TestBaseRapor {
    @Test
    public void aramaTesti(){
        /*
            raporlu olmasini istedigimiz her test methodunda
            1- classin TestBaseRapora child yapilmasi
            2- extentTest objesinin olusturulmasi
            3- raporda cıkamsini istedigimiz test adimlarini
               extentTest objesi ile islemeliyiz
         */

        extentTest = extentReports.createTest("arama testi","test otomasyonunda phone aranabilmeli");

        // testotomasyonu anasayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");

        // sayfaya gittiginizi test edin
        String expectedURL = ConfigReader.getProperty("toURL")+"/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        // Assert.assertEquals(actualURL,expectedURL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualURL,expectedURL,"URL Testi FAILED"); // 1. assertion yapildi

        extentTest.info("testotomasyonu sayfasina gittiginiz test eder");

        // phone için arama yapın

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        extentTest.info("phone için arama yapar");

        // bulunan urun sayisinin 3den falza oldugunu test edin
        int expectedUrunSayisi = 3;
        int actualUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

        // Assert.assertTrue(actualUrunSayisi > expectedUrunSayisi);
        softAssert.assertTrue(actualUrunSayisi > expectedUrunSayisi,"2. assertion FAILED"); // 2. assertion

        extentTest.info("bulunan urun sayisinin 3den falza oldugunu test eder");

        // ilk ürüne tiklayin
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        extentTest.info("ilk ürüne tiklar");

        // acilan urun sayfasindai urun isminin
        // case sensetive olmadan phone içerdigini test edin
        String expectedUrunIsimIcerik = "phonel";
        String actualUrunIsimElementi = testOtomasyonPage.urunIsimElementi.getText().toLowerCase();

        extentTest.info("urun isminin case sensetive olmadan phone içerdigini test eder");

        // Assert.assertTrue(actualUrunIsimElementi.contains(expectedUrunIsimIcerik));
        softAssert.assertTrue(actualUrunIsimElementi.contains(expectedUrunIsimIcerik),"Urun Ismi FAILED"); // 3. assertion
        ReusableMethods.bekle(2);
        softAssert.assertAll();

        extentTest.pass("softAssert ile yapılan tum assertionlar reporlanir");

        // sayfayi kapatin

        Driver.quitDriver();

        extentTest.info("sayfayi kapatir");
    }
}
