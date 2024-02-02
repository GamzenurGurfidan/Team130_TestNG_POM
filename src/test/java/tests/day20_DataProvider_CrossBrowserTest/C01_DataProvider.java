package tests.day20_DataProvider_CrossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_DataProvider extends TestBaseRapor {
    @DataProvider
    public static Object[][] aranacakUrunlerProvider() {

        /*
            @DataProvider notasyonunu kullanan methodlar bize
            2 katli bir array döndürmek üzere hazirlanmiştir

            bu methodun içerisinde non-primitive data turune sahip
            2 katli bir array oluşturup
            bu arrayi return olarak gönderirsek
            arraydeki her bir inner arrayi sirasiyla
            test methodumuza parametre olarak gonderir

         */

        String[][] aranacakUrunlerArrayi = {{"phone"}, {"java"}, {"dress"}, {"apple"}
                , {"nutella"}, {"cokokrem"}, {"baby"}};

        return aranacakUrunlerArrayi;
    }
    // test otomasyonu anasayfasina gidin
    // verilen urun listesindeki her bir urun icin
    // arama yapip, arama sonucunda urun bulunabildigini test edin
    // aranacak urun listesi: phone, java, dress, apple, nutella, cokokrem, baby


    @Test(dataProvider = "aranacakUrunlerProvider")
    public void topluAramaTesti(String aranacakUrun) {

        extentTest = extentReports.createTest("Toplu arama testi", "verilen listedeki tum urunlerin stokta bulundugunu test eder");

        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        extentTest.info("Kullanici testotomasyonu anasayfasına gider");

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys(aranacakUrun);

        extentTest.info("arama kutusuna " + aranacakUrun + " yazar");

        ReusableMethods.bekle(2);

        testOtomasyonPage.aramaKutusu.submit();
        extentTest.info("arama kutusuna yazilan " + aranacakUrun + " icin arama yapar");

        ReusableMethods.bekle(2);

        String unExpectedSonucYazisi = "0 Products Found";

        Assert.assertFalse(testOtomasyonPage.bulunanSayisiElementi.getText().equals(unExpectedSonucYazisi));

        extentTest.pass(aranacakUrun + " aramasinda urun bulunabildigini test eder");

        Driver.quitDriver();

        extentTest.info("sayfayi kapatir");

    }

}
