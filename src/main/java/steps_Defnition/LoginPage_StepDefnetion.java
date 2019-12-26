package steps_Defnition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class LoginPage_StepDefnetion {
	
	public static WebDriver driver;
	WebDriverWait eltWait;
	
	@Given("^Open browser and file url$")				
    public void open_the_Firefox_and_launch_the_application() throws Throwable							
    {	
		System.out.println("...........");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		eltWait=new WebDriverWait(driver, 10);
		eltWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("site-description"))));
        System.out.println("Page laoded...........");					
    }		

    @When("^click on new indow button$")					
    public void enter_the_Username_and_Password() throws Throwable 							
    {	
    	eltWait=new WebDriverWait(driver, 10);
    	WebElement newwindow=driver.findElement(By.id("button1"));
    	eltWait.until(ExpectedConditions.visibilityOf(newwindow));
    	System.out.println(driver.getWindowHandle());
//    	WebElement element = driver.findElement(By.id("gbqfd"));
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click();", newwindow);
//    	newwindow.click();
    	eltWait.until(ExpectedConditions.numberOfWindowsToBe(2));
    	Set<String> wind=driver.getWindowHandles();
    	String[] window=new String[wind.size()];
    	int i=0;
    	for(String str: wind){
    		window[i]=str;
    		System.out.println("WIndows : "+str);
    		i++;
    	}
    	driver.switchTo().window(window[1]);
    	driver.manage().window().maximize();
    	eltWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("primary-menu"))));
    	driver.close();
    	driver.switchTo().window(window[0]);
    	eltWait.until(ExpectedConditions.visibilityOf(newwindow));
    	System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
    }		

    @Then("^close new window and switch to main window$")					
    public void Reset_the_credential() throws Throwable 							
    {    		
    	driver.quit();
    	Runtime.getRuntime().exec("Taskkill /IM Chromedriver.exe /f");
        System.out.println("This step click on the Reset button.");					
    }	

   
    
}
