import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Exercise4 {
    public static void main(String[] a) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(" http://demo.guru99.com/popup.php");//webpage launch
        String parentwindow =driver.getWindowHandle();//parentwindow handle
        driver.findElement(By.xpath("//a[@target='_blank']")).click();//Click on "Click here".
        Set<String> allwindows=driver.getWindowHandles();//child window handles
        for(String child : allwindows)//for child window
        {
            if(!parentwindow.equalsIgnoreCase(child))
            {
                driver.switchTo().window(child);
                driver.findElement(By.name("emailid")).sendKeys("demo@gmail.com");
                WebElement submit = new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.elementToBeClickable(By.name("btnLogin")));
                driver.close();
            }
        }
        driver.switchTo().window(parentwindow);
        String actualmessage = driver.findElement(By.className("barone")).getText();
        String expectedmessage="Guru99 Bank";
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
