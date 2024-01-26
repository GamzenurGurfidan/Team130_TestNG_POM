package tests.day16_testNG_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PageClassKullanimi {
    @Test
    public void aramaTesti (){
        // 1- testotomasyonu anasayfaya gidin
        // 2- phone icin arama yapin
        // 3- Arama sonucunda bulunan urun sayisinin 3’den cok oldugunu test edin
        // 4- ilk urunu tiklayin
        // 5- acilan urun sayfasinda, urun isminde case sensitive olmadan phone bulundugunu test edin.

        Driver.getDriver().get("https://testotomasyonu.com/");
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();

        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        int actualSonucSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();
        int expectedMinSonucSayisi = 3;

        Assert.assertTrue(actualSonucSayisi > expectedMinSonucSayisi);

        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        String expectedUrunIsimIcerigi = "phone";
        String actualUrunIsmiKucukHarf = testOtomasyonPage.urunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerigi));

        ReusableMethods.bekle(2);
        Driver.quitDriver();

    }
}
