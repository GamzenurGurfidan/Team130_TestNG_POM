package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
        Bu classin amaci
        belirlenen browsera uygun webDriver objesi olusturmak
     */
    private Driver(){
        /*
            baska classlarin Driver classindan obje olusturmasini engellemek için
            Singleton pattern kullanilmiştir
            Singleton pattern classdan obje olusturulmasini engellemek için
            constructori gorunur yapip, erisimini private yapmaya dayanir
         */
    }

    public static WebDriver driver;

    public static WebDriver getDriver(){

        String browserTercihi = ConfigReader.getProperty("browser");
        /*
            browserin sadece chrome olmamasi için
            configuration.properties'e browser = " " secenegi ekledik

            Orada yazan browser tercihini 22. satirda alip
            tercihe uygun driver olusturmasi için
            bir switch statement kullandik

         */


        if (driver == null){
            switch (browserTercihi){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;

    }
    public static void closeDriver(){

        if (driver != null){
            driver.close();
            driver = null;
        }
    }
    public static void quitDriver(){

        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
