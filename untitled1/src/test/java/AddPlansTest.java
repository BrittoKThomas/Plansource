import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class AddPlansTest extends TestBase{
    @Test
    public void addPlans() {
        try {
            AddPlans ap = new AddPlans(driver);
            CommonUtils cu = new CommonUtils(driver);

            boolean result = ap.addplans();
            if (result) {
                Assert.assertTrue(result, "Step 5 Passed.");
            }
        } catch (Exception e) {
            boolean isExceptionOccurred = true;
            System.out.println("Exception caught: " + e.getMessage());
            Assert.assertFalse(isExceptionOccurred, "Failed due to exception");
        }
    }
}
