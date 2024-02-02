package tests.day17_TestNG_POMg;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_NegatifLoginTesti {

    @Test(groups = {"smoke","E2E","regression"})
    public void gecersizPasswordTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        // 2- account linkine basin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.accountLinki.click();

        // 3- 3 farkli test method’u olusturun.
        // - gecerli email, gecersiz password
        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizSifre"));

        // - gecersiz email, gecerli password

        // - gecersiz email, gecersiz password.


        // 4- Signin butonuna basarak login olun
        testOtomasyonPage.loginButonu.click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void gecersizEmailTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        // 2- account linkine basin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.accountLinki.click();

        // 3- 3 farkli test method’u olusturun.
        // - gecersiz email, gecerli password

        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));



        // - gecersiz email, gecersiz password.


        // 4- Signin butonuna basarak login olun
        testOtomasyonPage.loginButonu.click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());

        Driver.quitDriver();

    }

    @Test(groups = "smoke")
    public void gecersizEmailGecersizPasswordTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        // 2- account linkine basin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.accountLinki.click();

        // 3- 3 farkli test method’u olusturun.
        // - gecersiz email, gecersiz password.

        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizSifre"));


        // 4- Signin butonuna basarak login olun
        testOtomasyonPage.loginButonu.click();

        // 5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());

        Driver.quitDriver();
    }

}
