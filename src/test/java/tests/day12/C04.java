package tests.day12;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04 extends TestBase {
    //Yeni bir class olusturalim: MouseActions2
    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim


        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement tasinacakElement=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedefElement=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(tasinacakElement,hedefElement).perform();


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

String actuelDroppedYazisi=hedefElement.getText();
String expectedDropYazisi="Dropped!";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actuelDroppedYazisi,expectedDropYazisi);
        softAssert.assertAll();

    }

}
