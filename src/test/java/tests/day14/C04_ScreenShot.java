package tests.day14;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_ScreenShot extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.google.com");
        // tum sayfanin screen shot ini almak icin
// 1.adim-> obje olusturalim ve deger olarak driver imizi atayalim,
        //deger olarak driver imizi kabul etmesi icin cast yapmamiz gerekir
        TakesScreenshot tss= (TakesScreenshot) driver;

        //2.adim-> tum sayfanin screen shot ini almak icin bir file olusturalim ve dosya path ini belirtelim


        File tumsayfascreenshot=new File("src\\tumsayfa.png");

        //3.adim-> olusturdugumuz file  ile takesScreenShot objesini iliskilendirelim

        tumsayfascreenshot=tss.getScreenshotAs(OutputType.FILE);
//eger spesifik bir web elementin screen shot ini almak isterseniz
WebElement logoElementi=driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        File logoResmi=new File("src/logo.png");
        logoResmi=logoElementi.getScreenshotAs(OutputType.FILE);



    }


}
