package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class C04_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/Drivers/ChromeDriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com"); // get ile ayni islevi yapar.
        Thread.sleep(2000);

        driver.get("https://www.wisequarter.com");
        Thread.sleep(2000);

        // yeniden amazon'a donelim.
        driver.navigate().back();
        Thread.sleep(2000);

        // tekrar wisequarter'a gitmek istersek.
        driver.navigate().forward();
        Thread.sleep(2000);


        driver.quit();

    }
}
