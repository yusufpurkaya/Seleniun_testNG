package tests.day08;

import org.testng.annotations.Test;

public class C01_Notaions {
    @Test
    public void youtubetest(){
        System.out.println("youtube testi calisti");
    }
    @Test
    public void amazontest(){
        System.out.println("amazon testi calisti");
    }
    @Test(priority =1 )
    public void bestbuytest(){
        System.out.println("bestbuy testi calisti");
    }



}
