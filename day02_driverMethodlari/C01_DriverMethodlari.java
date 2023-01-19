package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/Drivers/ChromeDriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
        // acilan sayfanin basliginin amazon icerdigini test edin.

        String expectedKelime = "amazon";
        String actualResult = driver.getTitle();

        if (actualResult.contains(expectedKelime)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title amazon icermiyor, test FAILED");
            System.out.println(driver.getTitle());
        }


        // gittigimiz sayfanin URL'inin https://amazon.com/ oldugunu test edin.
        String expectedUrl="https://www.amazon.com/";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("URL testi PASSED");
        }else {
            System.out.println("URL https://www.amazon.com/ icermiyor, test FAILED");
            System.out.println(driver.getCurrentUrl());
        }

        Thread.sleep(5000);
        driver.close();

    }
}
