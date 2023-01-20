package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ZeroTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        // 3. Login alanine  “username” yazdirin
        WebElement loginKutusu=driver.findElement(By.xpath("//input[@type='text']"));
        loginKutusu.sendKeys("username");

        // 4. Password alanine “password” yazdirin
        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@type='password']"));
        passwordKutusu.sendKeys("password");

        // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // 6. Navigate back yapip, online banking menusunden Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("200");

        // 8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");

        // 9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

        // 10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement succesfullyElementi=driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (succesfullyElementi.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        Thread.sleep(2500);
        driver.close();
    }
}
