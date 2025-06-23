import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class AddDependentTest extends TestBase{
    @Test
    public void addDependent(){
        try {
            AddDependent ad = new AddDependent(driver);
            CommonUtils cu = new CommonUtils(driver);
            Properties p = new Properties();
            p.load(new FileInputStream("./data.properties"));

            String firstname = cu.generateRandomName();
            String lastname = cu.generateRandomName();

            boolean result = ad.addDependent(firstname, lastname, p.getProperty("newFamBirthDate"));
            if (result) {
                Assert.assertTrue(result, "Step 4 Passed.");
            }
        }
        catch (Exception e) {
            boolean isExceptionOccurred = true;
            System.out.println("Exception caught: " + e.getMessage());
            Assert.assertFalse(isExceptionOccurred, "Failed due to exception");
        }
    }
}

