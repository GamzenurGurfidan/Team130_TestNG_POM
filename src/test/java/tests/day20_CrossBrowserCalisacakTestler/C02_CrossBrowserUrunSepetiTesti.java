package tests.day20_CrossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

import java.util.List;

public class C02_CrossBrowserUrunSepetiTesti extends TestBaseCross {
    @Test
    public void urunSepetiTesti(){
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        // 2- phone icin arama yapin
        // 3- Listelenen sonuclardan ilkini tiklayin
        // 4- urun ismini kaydedin ve sepete ekleyin
        // 5- your cart linkine tiklayin
        // 6- kaydettiginiz urun ismi ile sepetteki urun isminin
        //    case sensitive olmadan ayni oldugunu test edin

        driver.get(ConfigReader.getProperty("toURL"));

        driver.findElement(By.id("global-search")).sendKeys("phone" + Keys.ENTER);

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));

        bulunanUrunElementleriList.get(0).click();

        WebElement urunIsmi =
                driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String sayfadakiUrunIsmi = urunIsmi.getText();

        driver.findElement(By.xpath("//button[@class='add-to-cart']")).click();

        driver.findElement(By.xpath("(//div[@class='cart-bar'])[2]")).click();

        WebElement sepettekiUrunElementi =
                driver.findElement(By.xpath("//*[@*='product-title text-center']"));

        String sepettekiUrunIsmi = sepettekiUrunElementi.getText();

        Assert.assertEquals(sepettekiUrunIsmi.toLowerCase(),sayfadakiUrunIsmi.toLowerCase());


    }
}
