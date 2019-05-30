import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Exercise7 {
    public static void main(String[]a)throws  InterruptedException,AWTException {
        //System.setProperty("webdriver.firefoxgecko.driver", "C:\\Program Files\\chromedriver.exe");
        //WebDriver driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(" https://www.engprod-charter.net");//webpage launch

        Robot rb=new Robot();
        StringSelection Uname = new StringSelection("admin");//username
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Uname, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        //Entered username"admin"
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        //entered tab
        StringSelection Pname = new StringSelection("admin");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Pname, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        //Entered password"admin"

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        //clcik on "enter"

        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);
       //Clcik on cancel

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        System.out.println("TestCase passed");
        driver.close();

    }
}
