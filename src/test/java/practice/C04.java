package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C04 {
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

/*
                note :
            JavaScriptExecutor nedir?
            JavaScriptExecutor, JavaScript'i Selenium Web sürücüsü aracılığıyla çalıştırmaya yardımcı olan bir Arayüzdür.
            JavaScriptExecutor, javascript'i seçilen pencerede veya geçerli sayfada çalıştırmak için "executescript" ve "executeAsyncScript"
            olmak üzere iki yöntem sunar.

            JavaScriptExecutor'a neden ihtiyacımız var?
            Selenium Webdriver'da, bir web sayfasındaki işlemleri tanımlamak ve gerçekleştirmek için
            XPath, CSS vb. gibi konum belirleyiciler kullanılır.
            Bu konum belirleyicilerin çalışmaması durumunda JavaScriptExecutor'ı kullanabilirsiniz.
            Bir web öğesinde istenen bir işlemi gerçekleştirmek için JavaScriptExecutor'ı kullanabilirsiniz.
            Selenium, javaScriptExecutor'ı destekler. Ekstra bir eklenti veya eklentiye gerek yoktur.
            JavaScriptExecutor kullanmak için komut dosyasında (org.openqa.selenium.JavascriptExecutor) içe aktarmanız yeterlidir.

            executeScript aracılığıyla sayfayı 1000 piksel kaydırın.
            Javascript yöntemi ScrollBy(), web sayfasını belirli piksel sayısına kaydırır.

            ScrollBy() yöntemlerinin sözdizimi şöyledir:
            executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
            x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse sağa hareket eder.
            y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.

            Örnek:
            js.executeScript("window.scrollBy(0,1000)"); // Dikey olarak 1000 piksel aşağı kaydır
     */


    }

    @Test
    public void test() throws InterruptedException {


        //https://www.teknosa.com/ adresine gidiniz
        driver.get("https://www.teknosa.com");
        driver.manage().deleteAllCookies();
        ChromeOptions op = new ChromeOptions();
//disable notification parameter
        op.addArguments("--disable-notifications");

        driver.findElement(By.id("search-input")).sendKeys("Oppo" + Keys.ENTER);

        System.out.println(driver.findElement(By.className("plp-info")).getText() + "  sonuc yazisi");
        driver.findElement(By.xpath("//a[@class='prd-link']")).click(); //ilkine tikla

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,200)");

        driver.findElement(By.id("addToCartButton")).click(); //sepete ekle tikla
        //driver.manage().deleteAllCookies();

//disable notification parameter
        //op.addArguments("--disable-notifications");

        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click(); //sepetime gite tikla

        //driver.manage().deleteAllCookies();

//disable notification parameter
        // op.addArguments("--disable-notifications");

        System.out.println(driver.findElement(By.xpath("//div[@class='cart-sum-title']")).getText());
        driver.findElement(By.xpath("//a[@title='Alışverişi Tamamla']")).click();
        //driver.manage().deleteAllCookies();
        //driver.findElement(By.id("addToCartButton")).click();
        // driver.manage().deleteAllCookies();

//disable notification parameter
        // op.addArguments("--disable-notifications");
        //  js.executeScript("scrollBy(0,200)");


        //arama cubuguna oppo yazip enter deyiniz


        //sonuc sayisini yazdiriniz
        //cikan ilk urune tiklayiniz
        //sepete ekleyiniz
        //sepetime git e tiklayiniz
        //consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        //Alisverisi tamamlayiniz
        //son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        System.out.println(driver.findElement(By.xpath("(//div[@class='lrl-title'])[1]")).getText());
        //js.executeScript("scrollBy(0,200)");
        Thread.sleep(2000);
        //driver i kapatiniz
        driver.quit();
    }

}
