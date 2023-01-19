package day02_driverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_DriverFindElementMethodu {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/Drivers/ChromeDriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");


        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        // findElement bize bir WebElement dondurecegi icin bir WebElement'e atadik.

        aramaKutusu.sendKeys("Java");
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        Thread.sleep(2000);
        driver.close();
    }
}
