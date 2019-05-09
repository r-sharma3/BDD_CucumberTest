package cucumberTest;

import java.awt.List;
//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ch.qos.logback.core.net.SyslogOutputStream;

public class PopupTest {

	private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {

		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver","D:\\WorkSpace\\CucumberTest\\Drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();

		//Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//Launch the Online Store Website

		//driver.get("https://www.justinmind.com/usernote/tests/27261324/30995992/32137559/index.html#/screens/d12245cc-1680-458d-89dd-4f0d7fb22724");
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.get("http://192.168.9.113/adminautomation/Login");
		
		driver.findElement(By.id("UserName")).sendKeys("rgupta");
		driver.findElement(By.id("Password")).sendKeys("Intsof@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-id='TestCreation']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-id='LOFT']/a")).click();
		WebElement fra = driver.findElement(By.id("TestCreationLOFTFrame"));
		Thread.sleep(2000);
		driver.switchTo().frame(fra);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='open-sidepanel-arrow']")).click();
		
		
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// By remove = By.cssSelector("#s-Hotspot_77");

		// get the "Add Item" element
		//WebElement RemoveBttn = wait.until(ExpectedConditions.presenceOfElementLocated(remove));

		//driver.findElement(By.cssSelector("#s-Hotspot_77")).click();
		//Thread.sleep(2000);
		//verifyPopUpMsg("example.xml","Example Test Form Name");
		// Find the element that's ID attribute is 'account'(My Account) 

		//List <WebElement> ele = driver.findElements(By.xpath("//*[@id='s-Text_28']")).getAttribute("span");
		String filter = "Subject";
		String value = "Computer Science";
		filter(filter,value);
	}

	/*public static boolean verifyPopUpMsg(String fileName, String testFormName)
	{
		boolean flag = false;
		String fileN = driver.findElement(By.cssSelector("#rtr-s-Text_28_0")).getText();
		String TestFN = driver.findElement(By.cssSelector("#rtr-s-Text_28_1")).getText();
		System.out.println(fileN+" : "+TestFN);
		if(fileN.trim().equalsIgnoreCase(fileName.trim()) && TestFN.contains(testFormName))
		{
			flag = true;
		}
		else
			flag = false;
		System.out.println(flag);
		return flag;
	}
*/
	public static void filter(String filterName, String filterValue) throws InterruptedException
	{
		//WebElement ele = driver.findElement(By.xpath("//div[@class='surpass-filters-panel']"));
		//driver.switchTo().frame(ele);
		Thread.sleep(2000);
		WebElement filter = driver.findElement(By.xpath("//div[contains(text(),'"+filterName+"')]"));
		filter.click();
		Thread.sleep(2000);
		WebElement fValue = driver.findElement(By.xpath("//div[@title='"+filterValue+"']"));
		fValue.click();
		driver.findElement(By.xpath("//button[@aria-labelledby='Apply']")).click();


	}

}
