package tests.day15_testNG_POM;

import org.testng.annotations.Test;

public class C03_PriorityKurallari {

    /*
        1- eger bizim mudahalemiz olmazsa TestNG testleri isim sirasina göre calistirir
        2- eger biz testleri siralamk istersek
           (priority = istenenDeger) yazariz
           ve TestNG priority degerlerine bakarak kucukten buyuge dogru calıstırır
        3- bazi test methodlarina priorty atmasi yapip,
           bazilarina yapmazsak TestNG atama yapilmayanlara default olarak
           priority = 0 atamasi yapar
           ve bu degere gore priorityleri siralar
        4- Eger ayni priority degerine sahip birden fazla test methodu varsa
           kendi iclerinde harf sirasina göre calisir
     */

    @Test
    public void testOtomasyonuTesti(){
        System.out.println("test otomasyonu calısti");
    }
    @Test
    public void wiseQuarterTesti(){
        System.out.println("wise quarter calısti");
    }
    @Test
    public void youTubeTesti(){
        System.out.println("youtube calıstı");
    }
}
