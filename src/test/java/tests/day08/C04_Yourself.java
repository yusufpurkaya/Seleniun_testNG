package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Yourself {

    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
WebDriver driver;
Select select;
WebElement dropbox;
@BeforeClass
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver.navigate().to("https://www.amazon.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();

}



//- Test 1
    //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
   @Test
    public void Test01(){
    dropbox=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
    select=new Select(dropbox);
       List<WebElement> optionlistesi=select.getOptions();
       Assert.assertEquals(optionlistesi.size(),45,"malesef olmadi");

}



    //-Test 2
    //    1. Kategori menusunden Books secenegini  secin
    //    2. Arama kutusuna Java yazin ve aratin
    //    3. Bulunan sonuc sayisini yazdirin
    //    4. Sonucun Java kelimesini icerdigini test edin
}
