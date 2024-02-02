package tests.day16_testNG_POMg;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_WebUniversityTest {

    @Test
    public void webUniversityTest(){
        // 1."https://webdriveruniversity.com/" adresine gidin
        // 2."Login Portal" a kadar asagi inin
        // 3."Login Portal" a tiklayin
        // 4.Diger window'a gecin
        // 5."username" ve "password" kutularina deger yazdirin
        // 6."login" butonuna basin
        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        // 8.Ok diyerek Popup'i kapatin
        // 9.Ilk sayfaya geri donun
        // 10.Ilk sayfaya donuldugunu test edin

        Driver.getDriver().get("https://webdriveruniversity.com/");

        WebUniversityPage webUniversityPage = new WebUniversityPage();

        String birinciWHD = Driver.getDriver().getWindowHandle();

        // portal yazisina kadar asagıya inmek için JS executor olusturmak kullanalim

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        // jse.executeScript("arguments[0].scrollIntoView(true)",webUniversityPage.loginPortalElementi);

        ReusableMethods.bekle(2);

        webUniversityPage.loginPortalElementi.click();

        ReusableMethods.titleIleWindowDegistir("WebDriver | Login Portal",Driver.getDriver());

        Faker faker = new Faker();
        webUniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webUniversityPage.passwordKutusu.sendKeys(faker.internet().password());

        webUniversityPage.loginButonu.click();

        String expectedAlertYazisi = "validation failed";
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);

        Driver.getDriver().switchTo().alert().accept();

        Driver.getDriver().switchTo().window(birinciWHD);

        String expectedURL = "https://webdriveruniversity.com/";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);

        ReusableMethods.bekle(1);

        Driver.quitDriver();

    }

}
