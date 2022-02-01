package tests.day10;

public class Iframe {

     /*
        iframe: bir web sayfasını başka bir web sayfasında görüntülemek için kullanılan bir HTML tag idir.
        Yani bir sitede başka bir web sayfasinin gomulu olmasi denebilir.
        3 adimda iframe i handle edebiliyoruz
        1. Adim: iframe locate etmek
        WebElement iframe=driver.findElement...;
        2.Adim : driver i frame gecirmek cunku driver a bunun bir frame oldugunu belirtmeliyiz
        yoksa locate ettigimiz elementi bulamaz
        driver.switchTo().frame(   ); ama hangi iframe ? iste bunun icinde 3 secenegimiz var
        iframe in ID veya INDEX veya locate ettigim webelementi
        bunun icin locate ettgimiz webelementi parametre olrak yaziyoruz
        3.Adim : driver i frame e gecirdigimiz icin hala frame de kaldi , frame den cikmak icin 2 secenek var
        yine driver.switchTo().
        parentFrame()-> bi ustteki frame e gecer
        veya defaultContent()-> en yukari gider .
        */

}
