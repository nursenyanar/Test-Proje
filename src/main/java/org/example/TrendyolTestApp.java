package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TrendyolTestApp
{
    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver","D:/driver/chromedriver.exe");
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void loginPageControl() {
        driver.get("https://www.trendyol.com/");
        Assert.assertTrue(driver.getTitle().equals("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da"));
        System.out.println("Web Sitesi Açıldı ...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("div.fancybox-overlay.fancybox-overlay-fixed > div > div > a")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement logIn=driver.findElement(By.id("accountBtn"));
        logIn.click();
        WebElement textUserName=driver.findElement(By.id("email"));
        textUserName.sendKeys("********@outlook.com");
        WebElement textPassword=driver.findElement(By.id("password"));
        textPassword.sendKeys("********");
        WebElement logInOkBtn=driver.findElement(By.id("loginSubmit"));
        logInOkBtn.click();
        System.out.println("Giriş yapıldı.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("div > div > input")).click();
        driver.findElement(By.cssSelector("div > div > input")).clear();
        driver.findElement(By.cssSelector("div > div > input")).sendKeys("Bilgisayar");
        driver.findElement(By.xpath("//*[@id=\"auto-complete-app\"]/div/div[2]/div/a[1]")).click();
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();

        }
        System.out.println("Bilgisayar kelimesi aratıldı ... ");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();

        }


        Random rnd=new Random();
        int result = rnd.nextInt(70) + 1;
        System.out.println("ürün seçildi");
        WebElement rastgeleUrun=driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div["+result+"]"));
        rastgeleUrun.click();

        try {

            Thread.sleep(3000);
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }
        WebElement basketBtn=driver.findElement(By.className("add-to-bs-tx"));
        basketBtn.click();
        try {

            Thread.sleep(2000);
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }
        WebElement basketGoBtn=driver.findElement(By.className("goBasket"));
        basketGoBtn.click();
        System.out.println("Ürün sepete eklendi.");

        try {

            Thread.sleep(8000);
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/button[2]")).click();
        System.out.println("Ürün adedi 1 adet arttırıldı");
        driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/div[1]/button[2]")).click();
        System.out.println("Ürün sepetten silindi.");

    }
    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }
}
