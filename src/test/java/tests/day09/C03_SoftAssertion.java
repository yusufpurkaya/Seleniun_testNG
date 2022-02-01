package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {
    @Test
    public void test(){
        int a=10;
        int b=20;
        int c=30;
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(a,b,"1.test failed");  //Failed
softAssert.assertTrue(a>b,"2.test failed");//Failed
softAssert.assertTrue(a<c,"3.test failed");//Passed
softAssert.assertTrue(c>b,"4.test failed");//Passed
softAssert.assertTrue(c<a,"5.test failed");//Failed

softAssert.assertAll();   // bunu eklemesek tum testler pass failed leri gorsede bana bisey demez test pass olur
    }
}
