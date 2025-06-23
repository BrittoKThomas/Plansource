import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.AuthProvider;

public class DentalApiTest extends TestBase {
    @Test
    public void enrollDentalPlanViaApi() {

        Cookie sessionCookie = driver.manage().getCookieNamed("_session_id");
        String sessionId = sessionCookie.getValue();
        System.out.println("Extracted Session ID: " + sessionId);


        DentalApi.dentalPlan(sessionId);
        try {
            DentalApi da = new DentalApi(driver);
            CommonUtils cu = new CommonUtils(driver);

            boolean result = da.checkout();
            if (result) {
                Assert.assertTrue(result, "Step 6 Passed.");
            }
        } catch (Exception e) {
            boolean isExceptionOccurred = true;
            System.out.println("Exception caught: " + e.getMessage());
            Assert.assertFalse(isExceptionOccurred, "Failed due to exception");
        }
    }
}


