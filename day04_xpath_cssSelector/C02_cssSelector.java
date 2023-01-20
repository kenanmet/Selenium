package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {
    public static void main(String[] args) throws InterruptedException {

        // 1- Gerekli ayarlari yapin.
        System.setProperty("webdriver.chrome.driver","src/Drivers/ChromeDriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // 2- https://www.amazon.com adresine gidin.
        driver.get("https://www.amazon.com");

        // 3- Sayfayi refresh yapin.
        driver.navigate().refresh();

        // 4- Sayfa basliginin "Spend less" ifadesi icerdigini test edin.
        String expectedMetin="Spend less";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedMetin)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");
        }

        // 5- Gift Cards sekmesine basin.
        driver.findElement(By.linkText("Gift Cards")).click();
        Thread.sleep(2000);

        // 6- Birthday butonuna basin.
        driver.findElement(By.xpath("//a[@aria-label='Birthday']")).click();

        // 7- Best seller bolumunden ilk urunu tiklayin.
        driver.findElement(By.xpath("(//li[@class='a-carousel-card acswidget-carousel__card'])[1]")).click();

        // 8- Gift card details'den 25$'i secin.
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();

        // 9- Urun ucretinin 25$ oldugunu test edin.
        driver.findElement(By.xpath("(//span[text()='$25.00'])[1]"));

        // 10- Sayfayi kapatin
        Thread.sleep(2000);
        driver.close();
    }
}
