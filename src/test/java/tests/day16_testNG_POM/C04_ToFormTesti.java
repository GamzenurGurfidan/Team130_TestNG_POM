package tests.day16_testNG_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C04_ToFormTesti {

    @Test
    public void formTesti(){

        // 1 - https://testotomasyonu.com/form adresine gidin
        // 2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        // 3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        // 4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        // 5- Secilen değerleri konsolda yazdirin
        // 6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        // 7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        Driver.getDriver().get("https://testotomasyonu.com/form");

        TestOtomasyonFormPage testOtomasyonFormPage = new TestOtomasyonFormPage();

        Select selectGun = new Select(testOtomasyonFormPage.gunDropDownMenu);
        selectGun.selectByIndex(5);

        Select selectAy = new Select(testOtomasyonFormPage.ayDropDownMenu);
        selectAy.selectByValue("nisan");

        Select selectYil = new Select(testOtomasyonFormPage.yilDropDownMenu);
        selectYil.selectByVisibleText("1990");

        System.out.println(selectYil.getFirstSelectedOption().getText() + "\n" +
                           selectAy.getFirstSelectedOption().getText() + "\n"+
                           selectGun.getFirstSelectedOption().getText());

        List<WebElement> ayDropdownTumOpsiyonlar = selectAy.getOptions();

        System.out.println(ReusableMethods.stringListeCevir(ayDropdownTumOpsiyonlar));

        Assert.assertEquals(ayDropdownTumOpsiyonlar.size(),13);


        ReusableMethods.bekle(1);
        Driver.quitDriver();

    }
}
