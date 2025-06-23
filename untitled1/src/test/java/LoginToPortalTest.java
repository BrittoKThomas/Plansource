import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class LoginToPortalTest extends TestBase {
//	WebDriver driver;

	@Test(priority = 1)
	public void login_To_PlanSource() {
		try {
			LoginToPortal nw = new LoginToPortal(driver);
			CommonUtils cu = new CommonUtils(driver);
			Properties p = new Properties();
			p.load(new FileInputStream("./data.properties"));

			//navigation to URL
			nw.navigateToURL(p.getProperty("url"));

			//Login
			boolean result = nw.login_To_PlanSource_Portal(p.getProperty("username"), p.getProperty("password"));
			if (result) {
				Assert.assertTrue(result, "Logged in Successfully");
			}


			//nw.new_Hire_Enrollment();
		} catch (Exception e) {
			boolean isExceptionOccurred = true;
			System.out.println("Exception caught: " + e.getMessage());
			Assert.assertFalse(isExceptionOccurred, "Failed due to exception");
		}
	}


}
