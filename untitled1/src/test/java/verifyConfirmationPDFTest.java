import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyConfirmationPDFTest extends TestBase{
    @Test
    public void verifycondfirmationPDF() {
        try {
            verifyConfirmationPDF vcp = new verifyConfirmationPDF(driver);
            CommonUtils cu = new CommonUtils(driver);

            vcp.downloadConfirmation();

        } catch (Exception e) {
            boolean isExceptionOccurred = true;
            System.out.println("Exception caught: " + e.getMessage());
            Assert.assertFalse(isExceptionOccurred, "Failed due to exception");
        }
    }
}

