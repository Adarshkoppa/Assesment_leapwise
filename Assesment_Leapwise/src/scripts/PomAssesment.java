package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAssesment {
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	private WebElement loginButton;
	
	@FindBy(xpath = "//input[@placeholder='Phone number' and @type='tel']")
	private WebElement enterNumber;
	
	@FindBy(xpath = "//span[text()=' Get OTP ']")
	private WebElement otp;
	
	@FindBy(xpath = "//div[text()='Group course']")
	private WebElement groupCoursesTab;
	
	@FindBy(xpath = "//span[@class='v-btn__content' and text()=' Cancel ']")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//a[contains(text(),'Classroom ')]")
	private WebElement Classroom;
	
	@FindBy(xpath = "//div[text()='Classroom for Automated testing']")
	private WebElement classroomTitle;
	
	@FindBy(xpath = "//a[text()='Live Sessions']")
	private WebElement liveSessionsTab;
	
	@FindBy(xpath = "//button//span[contains(text(),'Schedule')]")
	private WebElement scheduleSessionButton;
	
	@FindBy(xpath = "//span[text()='Add session ']")
	private WebElement addSessionButton;
	
	@FindBy(xpath = "//div[@class='v-select__slot']/input[@type='text']")
	private WebElement sessionTimePicker;
	
	@FindBy(xpath = "//div[text()='AM']/../../div[4]")
	private WebElement ampm;
	
	@FindBy(xpath = "//span[text()=' Create ']")
	private WebElement createButton;
	
	@FindBy(xpath = "//div[contains(@class, 'sessionCard')]")
	private WebElement sessionCard;
	
	public PomAssesment(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void enterMobileNumber(String no)
	{
		enterNumber.sendKeys(no);
	}
	
	public void getOTP()
	{
		otp.click();
	}
	
	
	public void getGroupCourse()
	{
		groupCoursesTab.click();
	}
	
	public void clickcancelButton()
	{
		cancelButton.click();
	}
	
	public void clickClassroom()
	{
		Classroom.click();
	}
	
	public void getClassroomTitle()
	{
		assert classroomTitle.isDisplayed();
	}
	
	public void clickLiveSessionsTab()
	{
		liveSessionsTab.click();
	}
	
	public void clickScheduleSessionButton()
	{
		scheduleSessionButton.click();
	}
	
	public void clickAddSessionButton()
	{
		addSessionButton.click();
	}
	
	public void getSessionTimePicker(String time)
	{
		sessionTimePicker.sendKeys(time);
	}
	
	public void getAmPm(String DN)
	{
		ampm.sendKeys(DN);
	}
	public void clickCreateButton()
	{
		createButton.click();
	}
	
	public void getSessionCard()
	{
		assert sessionCard.isDisplayed();
	}

	}
