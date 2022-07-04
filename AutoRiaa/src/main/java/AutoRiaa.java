import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoRiaa {
    By brand = By.xpath("//input[@id='brandTooltipBrandAutocompleteInput-brand']");
    By model = By.xpath("//input[@id='brandTooltipBrandAutocompleteInput-model']");
    By region = By.xpath("//label[@data-text='Регион']");
    By yearFrom = By.xpath("//select[@id='yearFrom']");
    By yearTo = By.xpath("//select[@id='yearTo']");

    By priceFrom = By.xpath("//input[@id='priceFrom']");
    By priceTo = By.xpath("//input[@id='priceTo']");

    By submitButton = By.xpath("//button[@type='submit']");


 @Test
 public void Test() throws InterruptedException {
     System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
     WebDriver driver = new ChromeDriver();
     driver.get("https://auto.ria.com/");
     driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

     driver.findElement(brand).sendKeys("bmw");
     Thread.sleep(1000);
     driver.findElement(By.xpath("//li[@data-value='9']")).click();
     driver.findElement(model).sendKeys("x6");
     Thread.sleep(1000);
     driver.findElement(By.xpath("//li[@data-value='2153']")).click();
     Thread.sleep(1000);
     driver.findElement(region).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//a[text()='Киев']")).click();
     driver.findElement(yearFrom).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//option[@value='2008']")).click();
     Thread.sleep(2000);
     driver.findElement(yearTo).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//div[@class='t-cell'][2]//option [@value='2020']")).click();
     //driver.findElement(By.xpath("//option[@value='2020']")).click();

     Thread.sleep(2000);
     driver.findElement(priceFrom).sendKeys("10000");
     driver.findElement(priceTo).sendKeys("18000");
     Thread.sleep(2000);
     driver.findElement(submitButton).click();

     Assert.assertEquals("https://auto.ria.com/search/?categories.main.id=1&price.currency=1&price.USD.gte=10000&price.USD.lte=18000&indexName=auto,order_auto,newauto_search&region.id[0]=10&brand.id[0]=9&model.id[0]=2153&year[0].gte=2008&year[0].lte=2020&size=20", driver.getCurrentUrl());
 }

}
