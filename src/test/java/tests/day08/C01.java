package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C01 {
    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.

WebDriver driver;
Select select;
    SoftAssert softAssert;
@BeforeClass
      public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://www.amazon.com");

      }


//- Test 1
    //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
@Test
    public void test01(){

   WebElement dropDown= driver.findElement(By.id("searchDropdownBox"));
select=new Select(dropDown);
List<WebElement> optionlistesi=new ArrayList<>();
optionlistesi=select.getOptions();


    Assert.assertFalse(optionlistesi.equals(45));

}


    //-Test 2
    //    1. Kategori menusunden Books secenegini  secin
    //    2. Arama kutusuna Java yazin ve aratin
    //    3. Bulunan sonuc sayisini yazdirin
    //    4. Sonucun Java kelimesini icerdigini test edin

    @Test
    public void test02(){
    driver.findElement(By.xpath("//option[text()='Books']")).click();
WebElement seracbox=driver.findElement(By.id("twotabsearchtextbox"));
seracbox.sendKeys("Java"+ Keys.ENTER);
WebElement sonuc=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
String sonucStr=sonuc.getText();
        System.out.println(sonucStr);
     //   System.out.println(sonucStr.contains("Java")?"java icerme testi Pass":"java icerme testi Failed");


   // Hard assert ile yapınız
        //Assert.assertTrue(sonucStr.contains("Java"));
        // sonucun java icerip icermedigini test edin ama akıs durmasın
     softAssert   =new SoftAssert();
        softAssert.assertFalse(sonucStr.contains("Java")," soft assert ile java testi failed");


        //"Java" için 30.000'den fazla sonuçtan 1-16'sı




WebElement sepet=driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]/span[2]"));
        System.out.println(sepet.isDisplayed()?"sepet objesi goruluyor":"sepet objesi gozukmuyor");
        softAssert.assertAll();

    }

@Test
    public void test03(){
    System.out.println("test 3 calisdi");

}
@AfterClass
    public void tearDown(){
    driver.close();
}



}
