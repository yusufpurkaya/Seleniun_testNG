package tests.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

public class Q07 {
    // 1) "https://www.facebook.com/" SAYFASINA GiDiN
    // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
    // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN


    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
   driver=new ChromeDriver();

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();


// 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
WebElement birthday=driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select select=new Select(birthday);
        List<WebElement> birthdaylist=select.getOptions();
      String birthdaylistesi="";
        for (WebElement each:birthdaylist
             ) {
            birthdaylistesi+=each.getText()+" ";

        }

        System.out.println("DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESi : "+birthdaylistesi);

        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN



        WebElement birthmonts=driver.findElement(By.id("month"));
        Select selectmonths=new Select(birthmonts);
        List<WebElement> birthmontslist=selectmonths.getOptions();
        String birthmontslistesi="";
        for (WebElement each:birthmontslist
        ) {
            birthmontslistesi+=each.getText()+" ";

        }

        System.out.println("DOGUM TARiHi BOLUMUNDEKi aylarin LiSTESi : "+birthmontslistesi);

        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
        WebElement birthyears=driver.findElement(By.name("birthday_year"));
        Select selectyears=new Select(birthyears);
        List<WebElement> birthyearslist=selectyears.getOptions();
        String birthyearslistesi="";
        for (WebElement each:birthyearslist
        ) {
            birthyearslistesi+=each.getText()+" ";

        }

        System.out.println("DOGUM TARiHi BOLUMUNDEKi yillarin LiSTESi : "+birthyearslistesi);



    }

@AfterClass
    public void tearDown(){
        driver.close();
}



}
