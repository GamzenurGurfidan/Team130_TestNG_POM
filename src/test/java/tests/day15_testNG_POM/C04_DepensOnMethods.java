package tests.day15_testNG_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C04_DepensOnMethods {
    /*
        Priority test method'larinin calisma siralamasini belirler
        ancak bir onceki method calismadiysa veya failed olduysa
        sonraki test method'unun bosuna calismasina engel olmaz

        1- dependsonMethods kullandigimizda
           bagli olan method (b), bagli oldugu method'u (a) kontrol eder
           Eger a method'u calismadiysa veya failed oldu ise b'yi ignore eder

        2- Test method'lari bagimsiz olarak calistirilabilir
           ANCAK eger bir method dependsOnMethods ile baska bir method'a baglanmis ise
           direk bagli olan method(b)'u calistirmak isteseniz de
           kendisi direk calismaz, once bagli oldugu method(a)'u calistirir
           o calisip PASSED olursa, kendisi(b) de calisir

           AMA bu kural sadece iki method icin gecerlidir,
           uc veya daha fazla method'un bagli olmasi durumunda
           hata verir ve test method'larini calistirmaz

        3- Isim sirasi veya priority sebebi ile
           once bagli olan method calistirilmak istenirse
           bagli olan method, onceligi bagli oldugu method'a verir
           once bagli olunan method calisir, eger passed olursa
           bagli olan method da calisir
     */

    List<WebElement> bulunanUrunElementleriList;

    @Test
    public void a() {
        // 1. Test : Testotomasyonu ana sayfaya gittiginizi test edin

        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedURL = "https://www.testotomasyonu.com/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test(dependsOnMethods = "a")
    public void b() {
        // 2. Test : search Box’i kullanarak “phone” icin arama yapin
        //           ve arama sonucunda urun bulunabildigini test edin

        WebElement aramakutusu = Driver.getDriver().findElement(By.id("global-search"));

        aramakutusu.sendKeys("phone" + Keys.ENTER);

        bulunanUrunElementleriList = Driver.driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanUrunElementleriList.size()>0);

    }

    @Test(dependsOnMethods = "b")
    public void c(){
        // 3.Test : ilk urunu tiklayin ve
        //          urun isminin case sensitive olmaksizin phone icerdigini test edin

        bulunanUrunElementleriList.get(0).click();

        WebElement urunIsimElementi =
                Driver.getDriver().findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedText = "phone";
        String actualText = urunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualText.contains(expectedText));

        Driver.quitDriver();

    }
}
