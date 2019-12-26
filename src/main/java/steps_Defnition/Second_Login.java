package steps_Defnition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class Second_Login{
	public static WebDriver driver;
	WebDriverWait eltWait;
	
	
	 @Given("^Open browser and file url	second$")				
	    public void SecondbrowsrLaunch() throws Throwable							
	    {	
			System.out.println(".222222222222222222222222222");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
			eltWait=new WebDriverWait(driver, 10);
			eltWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("site-description"))));
	        System.out.println("Page laoded...........");					
	    }		

	    @When("^click on new indow button Second$")					
	    public void Windowhandling() throws Throwable 							
	    {	
	    	eltWait=new WebDriverWait(driver, 10);
	    	WebElement newwindow=driver.findElement(By.id("button1"));
	    	eltWait.until(ExpectedConditions.visibilityOf(newwindow));
	    	System.out.println(driver.getWindowHandle());
//	    	WebElement element = driver.findElement(By.id("gbqfd"));
	    	JavascriptExecutor executor = (JavascriptExecutor)driver;
	    	executor.executeScript("arguments[0].click();", newwindow);
//	    	newwindow.click();
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
	    	System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	    }		

	    @Then("^close new window and switch to main window second$")					
	    public void tearDown() throws Throwable 							
	    {    		
	    	driver.quit();
	    	Runtime.getRuntime().exec("Taskkill /IM Chromedriver.exe /f");
	        System.out.println("####################################");					
	    }	
	    
	    
	    
	    
	    

}
