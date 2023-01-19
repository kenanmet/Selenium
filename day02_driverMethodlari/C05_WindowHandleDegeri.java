package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_WindowHandleDegeri {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/Drivers/ChromeDriver/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getWindowHandle()); // CDwindow-8E42C87E6CEF94EC85D33F1BD947D114
        Thread.sleep(2000);


        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("www.wisequarter.com");
        System.out.println(driver.getWindowHandle());
        Thread.sleep(2000);

        driver.quit();
    }
}
