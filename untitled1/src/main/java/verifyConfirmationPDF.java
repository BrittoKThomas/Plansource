import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class verifyConfirmationPDF {

    By checkoutBtn = By.xpath("//button[@class='btn btn-primary btn-lg full-width-sm p-x-xl']");
    By downloadbtn = By.xpath("//button[@class='btn btn-link shown-while-editing']");

    WebDriver driver;
    public verifyConfirmationPDF(WebDriver driver){
        this.driver=driver;
    }

    public void downloadConfirmation() throws InterruptedException {
        CommonUtils cu = new CommonUtils(driver);
        driver.findElement(checkoutBtn).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");
//        driver.findElement(downloadbtn).click();
        cu.wait.until(ExpectedConditions.elementToBeClickable(downloadbtn)).click();
        Thread.sleep(5000);
    }
}
