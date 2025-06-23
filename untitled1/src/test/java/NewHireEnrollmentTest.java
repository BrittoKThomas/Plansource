import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class NewHireEnrollmentTest extends TestBase{
    @Test
    public void newHireEnrollment(){
        try {
            NewHireEnrollment nhe = new NewHireEnrollment(driver);
            CommonUtils cu = new CommonUtils(driver);

            boolean result = nhe.newHire();
            if (result) {
                Assert.assertTrue(result, "Step 3 Passed.");
            }
        }
        catch (Exception e) {
            boolean isExceptionOccurred = true;
            System.out.println("Exception caught: " + e.getMessage());
            Assert.assertFalse(isExceptionOccurred, "Failed due to exception");
        }
    }

}

