package tests.day15_testNG_POM;

import org.testng.annotations.Test;
import utilities.Driver;

public class C02_Priority {

    // ● https://www.testotomasyonu.com/ adresine gidin.
    // Olusturacaginiz 3 farkli test method’unda asagida verilen görevleri yapin.
    // 1. Test : Testotomasyonu ana sayfaya gittiginizi test edin
    // 2. Test : search Box’i kullanarak “phone” icin arama yapin
    //           ve arama sonucunda urun bulunabildigini test edin
    // 3.Test : ilk urunu tiklayin ve urun isminin case sensitive olmaksizin phone icerdigini test edin

    @Test
    public void testOtomasyonAnaSayfaTesti(){

        Driver.getDriver().get("https://www.testotomasyonu.com");


    }

}
