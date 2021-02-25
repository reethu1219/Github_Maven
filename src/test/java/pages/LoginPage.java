package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	WebDriver driver;
	
//*********** Web elements***************************************
	@FindBy(xpath="//*[contains(text(),'Sign in')]") //added xpath as locators
	WebElement linkLogin;
	@FindBy(xpath="//input[@id='login_field']")
	WebElement editUsername;
	@FindBy(xpath="//input[@id='password']")
	WebElement editPwd;
	@FindBy(xpath="//input[@value='Sign in']")
	WebElement btnPwd;
	
	public LoginPage(WebDriver testdriver) {
		this.driver= testdriver;
		PageFactory.initElements(driver,this);  //loginpage converted into pagefactory
	}
	
//*************Methods**************************************
	public void login(String Username,String Password) {
		
		
		//WebElement linkLogin= driver.findElement(By.linkText("Log in")); calling above instead
		linkLogin.click();
		
		//WebElement editUsername=driver.findElement(By.name("user_login"));
		editUsername.sendKeys(Username);
		
		
		//WebElement editPwd=driver.findElement(By.name("user_pwd"));
		editPwd.sendKeys(Password);
		
		
		//WebElement chkBox = driver.findElement(By.className("rememberMe"));
		//chkBox.click();
		
		
		//WebElement btnPwd = driver.findElement(By.name("btn_login"));
		btnPwd.click();
		
	}
}


