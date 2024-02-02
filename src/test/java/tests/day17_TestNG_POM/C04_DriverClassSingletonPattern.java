package tests.day17_TestNG_POM;

import org.testng.annotations.Test;

public class C04_DriverClassSingletonPattern {
    @Test
    public void test01(){

        /*
            Testlerimizde kullanacağımız webDriver objesini
            Utilities altindaki driver classindaki
            getDriver() ile olurturuyoruz

            Driver classindaki WebDriver objesin olarak olusturulan
            driver'a Driver Classindan obje olusturarak da erişebiliriz
            Ancak mahşerin dört atlisi calişamadigindan
            driver objesi bir ise yaramaz

            POM dizayninda Driver classindaki driver objesine
            obje uzerinden erimi
            iptal etmek için Singleton Pattern tercih edilmiş

         */

        // Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        //Driver obj = new Driver(); // Driver()' has private access in 'utilities.Driver

        // obj.driver.get(ConfigReader.getProperty("toURL"));

    }
}
