import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewHireEnrollment {
    By newHireEnrollmentLink = By.xpath("//a[text()='New Hire Enrollment']");
    By getStartedBtn = By.xpath("//a[text()='Get Started']");

    WebDriver driver;
    public NewHireEnrollment(WebDriver driver){
        this.driver=driver;
    }

    public boolean newHire() throws InterruptedException {
        CommonUtils cu = new CommonUtils(driver);
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");
        driver.findElement(newHireEnrollmentLink).click();
        WebElement ele = cu.wait.until(ExpectedConditions.elementToBeClickable(getStartedBtn));
        boolean result = false;
        if(ele!=null) {
            result = true;
        }
        return result;
    }
}
