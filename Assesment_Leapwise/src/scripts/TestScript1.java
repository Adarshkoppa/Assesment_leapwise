package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScript1{
public WebDriver driver;
public WebDriverWait wait;
@Test
	public void test()
	{
		System.setProperty("webdriver.chrome.driver","./software/chromedriver.exe");
		//open the browser
		driver = new ChromeDriver();
		
		//enter the TestUrl
		driver.get("https://staging-web.wise.live");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//setting time duration for WebDriver to search the WebElement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//invoking pom class to use methods/functions
		PomAssesment p = new PomAssesment(driver); 
		
		//click the login link
		p.clickLogin();
		
		//choose login through mobile number
		WebElement mob = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[2]/span[1]"));
		try {
			
			mob = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[2]/span[1]"));
		}
		catch(StaleElementReferenceException e)
		{
			mob.click();	
		}
		
		//enter the phone number
		WebElement enterNo = driver.findElement(By.xpath("//input[@placeholder='Phone number' and @type='tel']"));
		try {
		enterNo = driver.findElement(By.xpath("//input[@placeholder='Phone number' and @type='tel']"));
		}
		catch (StaleElementReferenceException e) 
		{
		enterNo.sendKeys("1111100000");
		}
		p.getOTP();
		
		   //storing otp in webelements
			WebElement otp1 = driver.findElement(By.xpath("//div[@class='v-input__slot']//input[@autocomplete='one-time-code' and @class='otp-field-box--0']/.."));
				
			WebElement otp2 = driver.findElement(By.xpath("//div[@class='v-input__slot']//input[@autocomplete='one-time-code' and @class='otp-field-box--1']/.."));
				
			WebElement otp3 = driver.findElement(By.xpath("//div[@class='v-input__slot']//input[@autocomplete='one-time-code' and @class='otp-field-box--2']/.."));
				
			WebElement otp4 = driver.findElement(By.xpath("//div[@class='v-input__slot']//input[@autocomplete='one-time-code' and @class='otp-field-box--3']/.."));
			
			Actions a = new Actions(driver);	
		    a.sendKeys(otp1,Keys.NUMPAD0).perform();
			a.sendKeys(otp2,Keys.NUMPAD0).perform();
			a.sendKeys(otp3,Keys.NUMPAD0).perform();
			a.sendKeys(otp4,Keys.NUMPAD0).perform();
		
		//otp field is notinteractable so using action class to perform pass the input
		
		
		//verify otp
		driver.findElement(By.xpath("//span[text()=' Verify ']")).click();
		
		// Assert the institute name
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/..//span[contains(text(),'Testing Institute')]")));
		String text = element.getText();
		System.out.println(text);
		Assert.assertEquals(text,"Testing Institute");
		
		
        // Navigate to Classroom
		p.getGroupCourse();
		
		p.clickcancelButton();
     
		p.clickClassroom();
      

        // Assert classroom opened
        p.getClassroomTitle();
       
        WebElement liveSessionsTab = driver.findElement(By.xpath("//a[text()='Live Sessions']"));
        Actions a3 = new Actions(driver);
        try {
        	liveSessionsTab = driver.findElement(By.xpath("//a[text()='Live Sessions']"));
        	a3 = new Actions(driver);
        	} 
        catch (StaleElementReferenceException e) 
        {
        	a3.click(liveSessionsTab).click().perform();
		}
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(liveSessionsTab));
	
	    
		p.clickScheduleSessionButton();

        // Click on 'Add session' and choose time
        p.clickAddSessionButton();
        
        
        WebElement el = driver.findElement(By.xpath("//div[contains(text(),'Feb')]"));
        WebElement date2 = driver.findElement(By.xpath("(//div[@class='v-btn__content']/..)[2]"));
        WebElement date3 = driver.findElement(By.xpath("//td//div[text()='3']"));
        WebElement date4 = driver.findElement(By.xpath("//td//div[text()='4']"));
        Actions a2= new Actions(driver);
        
        
        try {
               el = driver.findElement(By.xpath("//div[contains(text(),'Feb')]"));
               date2 = driver.findElement(By.xpath("(//div[@class='v-btn__content']/..)[3]"));
               date3 = driver.findElement(By.xpath("//td//button[@type='button']//div[text()='3']"));
               date4 = driver.findElement(By.xpath("//td//button[@type='button']//div[text()='4']"));
               a2= new Actions(driver);
        	}
        catch(StaleElementReferenceException e)
        	{
        		a2.click(el).perform();
        	 	a2.click(date2).perform();
        	}
       
        WebElement ele = driver.findElement(By.xpath("//div[@role='combobox']"));
        try {
        	ele = driver.findElement(By.xpath("//div[@role='combobox']"));
            } 
        catch (StaleElementReferenceException e) 
        {
            // Re-locate and retry the action
            ele.click();
            ele.sendKeys(""+Keys.ENTER+"10:00");
        }
        	
       
		WebElement ampm = driver.findElement(By.xpath("//div[@class='text--16']"));
		String text2 = ampm.getText();
		if(text2=="AM")
		{
		Actions act = new Actions(driver);
		act.click(ampm).perform();
		p.clickCreateButton();
		}
		else
		{
        p.clickCreateButton();
		}
        
        // Assert session appears in the timeline
        WebElement sessionCard = driver.findElement(By.xpath("(//div[contains(@class,'session-card')])[3]"));
        assert sessionCard.isDisplayed();

        // Assert session details
        WebElement instructorName = sessionCard.findElement(By.xpath("//div[contains(text(),'Wise Tester')]"));
        WebElement sessionName = sessionCard.findElement(By.xpath("//div[text()='Live session']"));
        WebElement sessionTime = sessionCard.findElement(By.xpath("//div[text()='10:00 PM']"));
        
        assert instructorName.isDisplayed();
        assert sessionName.isDisplayed();
        assert sessionTime.getText().equals("10:00 PM");

        WebElement upcoming = driver.findElement(By.xpath("//button[@type='button' and @value='FUTURE']/.."));
        upcoming.click();
        driver.findElement(By.xpath("//span[text()='See all ']")).click();

        driver.quit();
		
	}

}


