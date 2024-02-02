package tests.day18_softAssertion_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SoftAssertion {
    /*
        TestNG JUnit'teki assertion classinin aynisina sahiptir

        Ancak bu assertionda, bir test methodunun icinde birden fazla assertion oldugunda
        ilk FAILED olan assertionda kodlarin calismasini durdugu icin
        geriye kalan assertionlarin sonuclarini gorme sansimiz OLMAZ

        Eger birden fazla assertion olan bir test methodunda
        tum assertionlari yapip
        en sonda varsa failed tum assertionlari reporlamiasini istersek
        TestNG deki softAssert classini kullanabiliriz

        SoftAssert kullanmak için 3 aadim gerekir
        1- softAssert objesi olusturma
        2- olusturdugumuz obje üzerinden assertionlari yapma
        3- assertAll() ile yapilan tum assertionlari raporlama

        softAssert hatayi assertAll() methodunun calistigi satirda raporlar
        birden fazla assertion olan bir methodda
        failed olan assertioni rahat bulabilmek icin
        assertion kodlarina mesaj da eklemek isabetli bir tercih olacaktir

        softAssert ile hazirlanan bir test methodunun sonunda
        assertAll() demezsek
        failed olan assertion olsa bile
        testimiz PASSED olur
     */

    @Test
    public void sofAssertAramaTesti(){

        // testotomasyonu anasayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        // sayfaya gittiginizi test edin
        String expectedURL = ConfigReader.getProperty("toURL")+"/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        // Assert.assertEquals(actualURL,expectedURL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualURL,expectedURL,"URL Testi FAILED"); // 1. assertion yapildi

        // phone için arama yapın

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // bulunan urun sayisinin 3den falza oldugunu test edin
        int expectedUrunSayisi = 3;
        int actualUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

        // Assert.assertTrue(actualUrunSayisi > expectedUrunSayisi);
        softAssert.assertTrue(actualUrunSayisi > expectedUrunSayisi,"2. assertion FAILED"); // 2. assertion

        // ilk ürüne tiklayin
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        // acilan urun sayfasindai urun isminin
        // case sensetive olmadan phone içerdigini test edin
        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsimElementi = testOtomasyonPage.urunIsimElementi.getText().toLowerCase();

        // Assert.assertTrue(actualUrunIsimElementi.contains(expectedUrunIsimIcerik));
        softAssert.assertTrue(actualUrunIsimElementi.contains(expectedUrunIsimIcerik),"Urun Ismi FAILED"); // 3. assertion

        softAssert.assertAll();

        // sayfayi kapatin

        Driver.quitDriver();

    }
}
