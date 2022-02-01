package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C02_SoftAssertion {
    //Yeni bir Class Olusturun : C03_SoftAssert



    WebDriver driver;
    @BeforeMethod
public void setUp(){
    // 1. “http://zero.webappsecurity.com/” Adresine gidin
    // 2. Sign in butonuna basin
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://zero.webappsecurity.com/");
driver.findElement(By.className("icon-signin")).click();

    }

@Test
    public void asd(){
        WebElement login=driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username");
// 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
WebElement password=driver.findElement(By.xpath("//input[@id='user_password']"));
password.sendKeys("Password");



    // 5. Sign in tusuna basin

    driver.findElement(By.xpath("//input[@name='submit']")).click();
    // 6. online banking altinda ki Pay Bills sayfasina gidin
driver.navigate().back();


    // 7. “Purchase Foreign Currency” tusuna basin

    // 8. “Currency” drop down menusunden Eurozone’u secin


    // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    SoftAssert softAssert=new SoftAssert(); // ilk adim obje create




    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu
    // test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
    // "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
    // "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)",

    // "Sweden (krona)","Singapore (dollar)","Thailand (baht)"


softAssert.assertAll(); // bunu yapmazsak hata vermez hep pass olur DIKKAT!

    }


}
