package cucumberTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
	private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.ie.driver","D:\\WorkSpace\\CucumberTest\\Drivers\\IEDriverServer.exe"); 
        driver = new InternetExplorerDriver();
 
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
 
        //Launch the Online Store Website
 
        driver.get("http://www.store.demoqa.com");
 
        // Find the element that's ID attribute is 'account'(My Account) 
 
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
 
        // Find the element that's ID attribute is 'log' (Username)
 
        // Enter Username on the element found by above desc.
        //Thread.sleep(2000);
        
        //WebElement FormName = driver.findElement(By.xpath("//form[@name='loginform']")); 
        //WebElement FormName = driver.findElement(By.xpath("//div[@id='login_wrapper']"));
        //driver.switchTo().frame(FormName);
 
        // -- driver.findElement(By.id("log")).sendKeys("testuser_1"); 
        
        WebElement ajaxControl = (new WebDriverWait(driver, 15))
        		.until(ExpectedConditions.presenceOfElementLocated(By
        				.id("log")));
 
        driver.findElement(By.xpath("//input[@id='log']"));
        
        // Find the element that's ID attribute is 'pwd' (Password)
 
        // Enter Password on the element found by the above desc.
 
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
 
        // Now submit the form. WebDriver will find the form for us from the element 
 
        driver.findElement(By.id("login")).click();
 
        // Print a Log In message to the screen
 
        System.out.println("Login Successfully");
 
        // Find the element that's ID attribute is 'account_logout' (Log Out)
 
        driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
 
        // Print a Log In message to the screen
 
        System.out.println("LogOut Successfully");
 
        // Close the driver
 
        driver.quit();
 
	}

}
