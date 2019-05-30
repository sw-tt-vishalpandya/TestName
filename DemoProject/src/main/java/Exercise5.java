import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Exercise5 {
    public static void main(String[]a)throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/delete_customer.php");//webpage launch
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("53920");//user input
        driver.findElement(By.name("submit")).click();//clciking on submit button
        Alert a1 =driver.switchTo().alert();//switch to alert1
        a1.accept();
        Alert a2=driver.switchTo().alert();//switch to alert2
        a2.accept();
        driver.close();

    }


}
