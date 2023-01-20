package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        // amazon'a gidip nutella icin arama yapin
        // ilk sayfada cikan urunlerin icerisinde
        // en yuksek fiyati bulun


        System.setProperty("webdriver.chrome.driver","src/Drivers/ChromeDriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        List<WebElement>fiyatlarListesi=driver.findElements(By.className("a-price-whole"));

        // WebElement bir obje oldugundan, direk yazdirilamaz.
        System.out.println(fiyatlarListesi);

        // Bunun icin for-each loop kullanarak
        // her bir WebElement uzerindeki yazilari tek tek yazdirmaliyiz.
        for (WebElement each:fiyatlarListesi
             ) {
            System.out.print(each.getText() + " ");
        }

        /*
            En yuksek fiyati bulabilmek icin java bilgimiz kullanmaliyiz
                1- WebElementlerden getText ile fiyati String olarak alin.
                2- string fiyati kiyaslama yapabilmek icin Integer'a cevirin.
                3- En yuksek fiyati bulup yazdirin.
         */

        String fiyatStr;
        Integer fiyatInt;
        Integer enYuksekFiyat=0;  // karsilastirma yapacagimiz icin 0 atadik.

        for (WebElement each:fiyatlarListesi
             ) {
            fiyatStr=each.getText();
            fiyatInt=Integer.parseInt(fiyatStr);

            if (fiyatInt>enYuksekFiyat){
                enYuksekFiyat=fiyatInt;
            }
        }

        System.out.println("");
        System.out.println("En yuksek urun fiyat: " + enYuksekFiyat);


        Thread.sleep(2000);
        driver.close();
    }
}
