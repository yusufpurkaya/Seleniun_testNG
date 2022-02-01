package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {
    //➢ doubleClick ( ): WebElement’e çift tıklama yapar
    //➢ clickAndHold ( ): WebElement uzerinde click yapili olarak bizden komut bekler.
//➢ dragAndDrop ( ): WebElement’i bir noktadan diğerine sürükler ve bırakır
//➢ moveToElement ( ): Mouse’u istedigimiz WebElement’in uzerinde tutar
//➢ contextClick ( ): Mouse ile istedigimiz WebElement’e sag tiklama yapar



    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfaya gidin
        // sag ustte hello,signIn elementinin uzerinde mouse'u bekletin

        driver.get("https://www.amazon.com");

        Actions actions=new Actions(driver);
        WebElement helloElementi = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(helloElementi).perform();
        Thread.sleep(1000);
        // acilan menude new list linkine tiklayin
        WebElement listElement = driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
actions.click(listElement).perform();

        // ve new list sayfasinin acildigini test edin
String title=driver.getTitle();
        SoftAssert softassert=new SoftAssert();
        softassert.assertTrue(title.contains("Your List"));

softassert.assertAll();
        //Assert.assertTrue(title.contains("Your List"));
        // hard assertions ile de yapilabilirdi
    }

}
