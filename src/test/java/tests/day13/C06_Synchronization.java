package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;


public class C06_Synchronization extends TestBase {


    @Test
    public void test01() throws InterruptedException {


      //  driver.get("https://www.youtube.com");
       // driver.findElement(By.xpath("//input[@id='search']")).click();

   /*
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-submit")).click();
   */

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
       Thread.sleep(3000);
        WebElement yaziElementi=driver.findElement(By.xpath("//p[@id='message']"));
Assert.assertTrue(yaziElementi.isDisplayed());

// implicitly wait tum class icin islemleri bekler teker teker
// explicitly wait ise belirli bir kosul icin kullanilir

// Thread.sleep ise java dan gelen ve islem hallolsa bile bekler

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
      //  wait.until(ExpectedConditions.    )



    }
}
