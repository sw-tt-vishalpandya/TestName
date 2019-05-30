import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Exercise6 {
    public static void main(String[] a) {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://toolsqa.com/automation-practice-switch-windows");//webpage launch

        String parentwindow = driver.getWindowHandle();//parentwindow handle
        driver.findElement(By.id("button1")).click();//Click on "Click here".
        Set<String> allwindows = driver.getWindowHandles();//child window handles
        for (String child : allwindows)//for child window
        {
            if (!parentwindow.equalsIgnoreCase(child))
            {
                driver.switchTo().window(child);
                driver.manage().window().maximize();
                String actualmessage = driver.findElement(By.xpath("//span[contains(text(),'Popular Tutorial')]")).getText();
                String expectedmessage="Popular Tutorial";
                if (actualmessage.equals(expectedmessage))
                {
                    System.out.println("Message is matche.Originial messege is : " + actualmessage);
                }else
                {
                    System.out.println("Message is not match.");
                }
                driver.close();
                }
        }
        driver.switchTo().window(parentwindow);
        driver.close();
        

    }
}