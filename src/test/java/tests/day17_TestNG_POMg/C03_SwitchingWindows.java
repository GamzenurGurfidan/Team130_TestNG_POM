package tests.day17_TestNG_POMg;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuAddRemovePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SwitchingWindows {
    @Test
    public void windowTesti(){
        // ● https://testotomasyonu.com/addremove/ adresine gidin.
        // ● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        // ● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        // ● ’Please click for Electronics Products’ linkine tiklayin.
        // ● Electronics sayfasinin acildigini test edin
        // ● Bulunan urun sayisinin 16 olduğunu test edin
        // ● Ilk actiginiz addremove sayfasina donun
        // ● Url’in addremove icerdigini test edin

        Driver.getDriver().get(ConfigReader.getProperty("toURLAddRemove"));

        String expectedYazi ="Add/Remove Elements";

        TestOtomasyonuAddRemovePage testOtomasyonuAddRemovePage = new TestOtomasyonuAddRemovePage();

        String actualYazi = testOtomasyonuAddRemovePage.addRemoveYaziElementi.getText();

        Assert.assertEquals(actualYazi,expectedYazi);

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualYazi,expectedYazi);

        String addRemoveSayfasiWHD = Driver.getDriver().getWindowHandle();

        testOtomasyonuAddRemovePage.electronicsProductLinki.click();

        // link tıklandiginda electronics sayfasi ayri bir tab olarak aciliyor
        // once webDriver objemizi o windowa gecirmeliyiz

        ReusableMethods.titleIleWindowDegistir("Test Otomasyonu - Electronics",Driver.getDriver());

        Assert.assertTrue(testOtomasyonuAddRemovePage.electronicsSayfasiDogrulama.isDisplayed());


        int expectedUrunSayisi = 16;
        int actualUrunSayisi = testOtomasyonuAddRemovePage.bulunanElementlerList.size();

        Assert.assertEquals(actualUrunSayisi,expectedUrunSayisi);

        Driver.getDriver().switchTo().window(addRemoveSayfasiWHD);

        String expectedURLIcerik = "addremove";
        String actualURLIcerik = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualURLIcerik.contains(expectedURLIcerik));

        Driver.quitDriver();

    }
}
