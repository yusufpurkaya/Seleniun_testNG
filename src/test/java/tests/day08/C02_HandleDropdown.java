package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_HandleDropdown {
    WebDriver driver;
  // dikkat testNG de sadece @before veya @after  yok
// dropdown varsa genelde Select class kullanilir
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void dropdowntesti(){
driver.get("https://www.amazon.com");
      WebElement dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
    // 2. adim select class indan bir obje uretelim
        // ve parametre olarak olusturdugumuz webelementi yazalim
        Select select=new Select(dropdown);
 //select objesini kullanarak select class indan var olan 3 secim metodundan
        //istedigimizi kullanarak dropdown da varolan option lardan birini secebiliriz
        //secim yapmamıza yardim eden bu 3 method voiddir yani bize bisey dondurmez sadece secer
        select.selectByIndex(3);
//eger sectigimiz option degerini yazdirmak istersek
        System.out.println(select.getFirstSelectedOption());

        // gorunen isme gore dropdown dan secenek secme
        select.selectByVisibleText("Deals"); // buda dropdown da ki ada gider
        // bu html kodlariyla yazildigi icin value="...." gibi bir degeri vardir aslinda

        // select.selectByValue("buraya value degerini yaz");


        List<String> optionString=new ArrayList<>();
        List<WebElement> dropDownlistesi=new ArrayList<>();

        for (WebElement each:dropDownlistesi
             ) {
            System.out.println(each.getText());

        }

        //optionString.add(each.getText()); for body e bunu de eklesek degerleri bir list e gondermis oluduk
//dropDownlistesi.stream().forEach(t-> System.out.println(t.getText())); Lambdayla yazdirabilirdik

    }
}
