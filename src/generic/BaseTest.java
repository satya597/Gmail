package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst{
	WebDriver driver;
	
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	
	@BeforeMethod
	public void openApp(){
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		
		driver.get(URL);
	}
	
	@AfterMethod
	public void closeApp(ITestResult tesresult){
		String name=tesresult.getName();
		int status=tesresult.getStatus();
		if(status==1){
			Reporter.log("test is passed",true);
		}
		else
		{
			Reporter.log("test is failed/skipped",true);
			
		}
	}

}
