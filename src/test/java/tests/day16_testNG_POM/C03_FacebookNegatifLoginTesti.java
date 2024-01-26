package tests.day16_testNG_POM;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_FacebookNegatifLoginTesti {
    @Test
    public void facebookNegatifLoginTesti(){
        // 1 - https://www.facebook.com/ adresine gidin
        //     cookies cıkıyorsa kabul edin
        // 2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        // 3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        // 4- Basarili giris yapilamadigini test edin

        Driver.getDriver().get("https://www.facebook.com/");

        FacebookPage facebookPage = new FacebookPage();
        Faker faker = new Faker();

        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());

        facebookPage.girisButonu.click();

        Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());
        ReusableMethods.bekle(1);

        Driver.quitDriver();

    }
}
