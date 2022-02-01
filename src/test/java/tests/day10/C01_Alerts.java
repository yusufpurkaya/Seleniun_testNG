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

import java.sql.DriverManager;
import java.time.Duration;

public class C01_Alerts {

  //● Bir class olusturun: Alerts
  //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.


  //● Bir metod olusturun: sendKeysAlert
  //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
  //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
  WebDriver driver;
  String sonucyazisistr;
  String expected;
  WebElement sonucyazisi;
  @BeforeClass
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");


  }

  @Test
  public void acceptAlert() {
    //● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //        “You successfully clicked an alert” oldugunu test edin.
    driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
    driver.switchTo().alert();

  sonucyazisi = driver.findElement(By.xpath("//p[@style='color:green']"));
    sonucyazisistr = sonucyazisi.getText();
    expected = "You successfully clicked an alert";
   Assert.assertEquals(sonucyazisistr, expected);
  }
/*
   @Test
    public void acceptAlertTesti() throws InterruptedException {
        //● Bir metod olusturun: acceptAlert
        //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();
        //      “You successfully clicked an alert” oldugunu test edin.
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        Thread.sleep(3000);
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
    }
 */
  @Test
  public void dismissAlert() {
    //● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //        “successfuly” icermedigini test edin.

    driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
    driver.switchTo().alert().dismiss();

   sonucyazisi = driver.findElement(By.xpath("//p[@id='result']"));
    sonucyazisistr = sonucyazisi.getText();
    String istenmeyen = "successfuly";
    Assert.assertFalse(sonucyazisistr.contains(istenmeyen));
  }

  @Test
  public void sendKeysAlert() {
    //● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
  driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
  driver.switchTo().alert().sendKeys("yusuf");
  driver.switchTo().alert().accept();

   sonucyazisi = driver.findElement(By.xpath("//p[@id='result']"));
    sonucyazisistr = sonucyazisi.getText();
    String isim = "yusuf";
Assert.assertTrue(sonucyazisistr.contains(isim));



  }

@AfterClass
  public void tearDown(){
    driver.close();
}



}
