package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpLoad extends TestBase {
    //Tests packagenin altina bir class oluşturun : C05_UploadFile
    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.
    //Upload butonuna basalim.
    //“File Uploaded!” textinin goruntulendigini test edelim


        @Test
        public void test01()  {
            //Tests packagenin altina bir class oluşturun : C05_UploadFile
            //https://the-internet.herokuapp.com/upload adresine gidelim
            driver.get("https://the-internet.herokuapp.com/upload");
            //chooseFile butonuna basalim
            //Yuklemek istediginiz dosyayi secelim.
            // 1- File secme butonunu locate edelim
            WebElement filesecButonu = driver.findElement(By.id("file-upload"));
            // 2- yukleyecegimiz dosyanin dinamik path'ini hazirlayalim
            String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\Deneme\\selenium.txt";
            // 3- sendKeys( ) ile dinamik path'i dosya sec butonuna yollayalim
            filesecButonu.sendKeys(dosyaYolu);
            //Upload butonuna basalim.
            driver.findElement(By.id("file-submit")).click();
            //“File Uploaded!” textinin goruntulendigini test edelim
            WebElement sonucYaziElementi = driver.findElement(By.tagName("h3"));
            Assert.assertTrue(sonucYaziElementi.isDisplayed());

    }
}
