import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class CreateNewEmployeeTest extends TestBase{
    @Test
    public void createNewEmployee(){
        try {
            LoginToPortal nw = new LoginToPortal(driver);
            CreateNewEmployee cnep = new CreateNewEmployee(driver);
            CommonUtils cu = new CommonUtils(driver);
            Properties p = new Properties();
            p.load(new FileInputStream("./data.properties"));

            String twoDaysBackFromCurrentDate = cu.getDateTwoDaysbackFromCurrentDate();
            String firstname = cu.generateRandomName();
            String lastname = cu.generateRandomName();
            String ssn = cu.generateRandomSSN();

            boolean result = cnep.createNewEmployee(p.getProperty("passwordfornewemployee"), firstname, lastname, ssn, p.getProperty("address1"), p.getProperty("city"), p.getProperty("State"), p.getProperty("zipcode")
                    , p.getProperty("country"), p.getProperty("birthdate"), p.getProperty("currentsal"), p.getProperty("benefitsal"), twoDaysBackFromCurrentDate);
            if (result) {
                Assert.assertTrue(result, "Step 2 Passed. Employee created Successfully");
            }
        }
        catch (Exception e) {
            boolean isExceptionOccurred = true;
            System.out.println("Exception caught: " + e.getMessage());
            Assert.assertFalse(isExceptionOccurred, "Failed due to exception");
        }
    }
}
