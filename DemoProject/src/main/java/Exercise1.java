import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Exercise1 {

    public static void main(String[]a)throws Exception{

        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");

        WebElement ifreamElement =driver.findElement(By.id("iframeResult"));//find fream element

        driver.switchTo().frame(ifreamElement);///driver switch ifream

        WebElement trybtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='myFunction()']")));
        trybtn.click();

        Alert a1=driver.switchTo().alert();
        System.out.println("message is :"+a1.getText());
        a1.accept();
        driver.switchTo().defaultContent();
        driver.close();

    }
}
