package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01 {

    //● Bir class oluşturun: DependsOnTest
    //● https://www.amazon.com/ adresine gidin.

    WebDriver driver;
@BeforeClass
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}


    //    1. Test : Amazon ana sayfaya gittiginizi test edin

   @Test
    public void logoTest(){
    driver.get("https://www.amazon.com/");
      WebElement logoelementi=driver.findElement(By.id("nav-logo-sprites"));
       Assert.assertTrue(logoelementi.isDisplayed());
   }


    //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //    arama yapin ve aramanizin gerceklestigini Test edin

   @Test(dependsOnMethods = "logoTest")
    public void searchBox(){
    WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("Nutella"+Keys.ENTER);
Assert.assertTrue(driver.getTitle().contains("Nutella"));
}




    //    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
    //    $14.99 oldugunu test edin

@Test(dependsOnMethods = "searchBox")
    public void test03(){
    WebElement ilkUrun=driver.findElement(By.xpath("//img[@data-image-index='1']"));
    ilkUrun.click();
    WebElement price=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[2]"));
    String priceStrng=price.getText();

    Assert.assertTrue(price.getText().contains("$14.99"));
}


@BeforeClass
    public void tearDown(){
    driver.close();
}








}
