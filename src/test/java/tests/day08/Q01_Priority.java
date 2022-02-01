package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Q01_Priority {
    //Priority
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
   WebDriver driver=new ChromeDriver();
   @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver.navigate().to("");
    }
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

}
