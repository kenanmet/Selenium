package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {
    public static void main(String[] args) {

        System.getProperty("webdriver.chrome.driver","src/Drivers/ChromeDriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
        driver.getPageSource();

        String expectedKelime ="ramazan";
        String actualKelime= driver.getPageSource();

        if (actualKelime.contains(expectedKelime)){
            System.out.println("Test Passed");
        }else {
            System.out.println("sayfa kaynagi ramazan icermiyor. Test Failed");
        }

        driver.close();
    }
}
