package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BasicAuthentication {
    //1- Bir class olusturun : BasicAuthentication
    //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //    Html komutu : https://username:password@URL
    //    Username     : admin
    //    password      : admin

WebDriver driver;
@BeforeClass
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
@Test
public void test01(){
 //   driver.get("https://the-internet.herokuapp.com/basic_auth");
    // eger bu sekilde gitsek karsimiza username ve password girecegim yer cikar ve ben
    //buralari locate edemiyorum
 //   "https://admin:admin@https://the-internet.herokuapp.com/basic_auth"
    // basic authentication isteyen siteler bize nasil ve hangi bilgilerle authentication
    //yapabilecegimizi vermek zorundadir mesela ucretli siteler
    // bizde adim adim sitenin bize gonderdigi isleri yapmak zorundayiz
    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");


    //4- Basarili sekilde sayfaya girildigini dogrulayin
    WebElement congrulations=driver.findElement(By.tagName("p"));
    Assert.assertTrue(congrulations.isDisplayed());

}
@AfterClass
    public void tearDown(){
    driver.close();
}


}
