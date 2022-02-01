package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions extends TestBase {



    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
       driver.get("https://the-internet.herokuapp.com/context_menu");


        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliAlan=driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        String expectedStr="You selected a context menu";
        String actuelStr=driver.switchTo().alert().getText();

        //    test edelim.
        Assert.assertEquals(actuelStr,expectedStr);

        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String firstPageHandle=driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
  String secondPageHandle="";
        Set<String> handleSet=driver.getWindowHandles();
        for (String each:handleSet
             ) {if (!(each.equals(secondPageHandle))){
                 secondPageHandle=each;

        }

        }

driver.switchTo().window(secondPageHandle);
        WebElement secondPageWriteElement=driver.findElement(By.tagName("h1"));
    String secondPageWriteElementStr=secondPageWriteElement.getText();
    Assert.assertEquals(secondPageWriteElementStr,"Elemental Selenium");






    }

}
