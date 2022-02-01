package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_KeywordActions extends TestBase {

    //1- Bir Class olusturalim KeyboardActions1
    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    //4- aramanin gerceklestigini test edin


    @Test
    public void test01(){
        //2- https://www.amazon.com sayfasina gidelim

        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.click();
        Actions actions=new Actions(driver);
        actions.click().keyDown(Keys.SHIFT).
                sendKeys("s").//shift e basili s
                keyUp(Keys.SHIFT).sendKeys("amsung ").//shitften elini cek amsung yolla
                keyDown(Keys.SHIFT).sendKeys("a").//shifte bas ve
                keyUp(Keys.SHIFT).sendKeys("71").sendKeys(Keys.ENTER).//shiftten elini cek ve 71 yaz enter a bas
                perform();



       //4- aramanin gerceklestigini test edin

    }


}
