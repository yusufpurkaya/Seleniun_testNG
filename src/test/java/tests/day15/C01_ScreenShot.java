package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_ScreenShot extends TestBase {

    @Test
    public void nutellaTesti() throws IOException {

        //amazon anasayfaya gidip
        driver.get("https://www.amazon.com");

        //nutella icin arama yapalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

       // sonuclarin nutella icerdigini test edelim
searchBox.sendKeys("Nutella"+ Keys.ENTER);

WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        Assert.assertTrue(sonucYazisi.getText().contains("Nutella"));
// testin calisdigini ispat icin sayfanin screenshot ini alalim

        // 1. adim takescreeshot objesi olusturalim
        TakesScreenshot tss= (TakesScreenshot) driver;
        // 2.adim kaydedecegimiz dosyayi olusturalim
        File tumsayfaSS=new File("target/screeshot/tumsayfa.png");

// 3.adim bir dosya daha olusturup screenshot i alalim
        File geciciresim=tss.getScreenshotAs(OutputType.FILE);

        //4.adim geciciresmi kaydetmek istedigimiz asil dosyaya copy edelim
        FileUtils.copyFile(geciciresim,tumsayfaSS);



    }
}
