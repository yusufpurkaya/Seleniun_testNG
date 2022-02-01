package tests.day13;

import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C02_FileExist {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home")); //C:\Users\yepka
  String path=System.getProperty("user.home")+"\\Desktop\\Deneme\\selenium.txt";
        System.out.println(Files.exists(Paths.get(path)));
        //C:\Users\yepka\Desktop\Deneme
        System.out.println(System.getProperty("user.dir"));// C:\Users\yepka\IdeaProjects\com.testNGBatch44


      //  System.out.println( Files.exists(Paths.get(path)));
       String pomyolu=System.getProperty("user.dir")+"\\pom.xml";

        System.out.println(Files.exists(Paths.get(pomyolu)));



    }
}
