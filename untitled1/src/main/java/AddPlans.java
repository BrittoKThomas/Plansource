import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPlans {

    By shopBenefitsBtn = By.id("submit_form");
    By medicalShopPlansBtn = By.xpath("//a[@href='/subscriber/benefit/121136132']");
    By medicalUpdateCartBtn = By.id("updateCartBtn");
    By backBtn = By.xpath("//button[@class='btn btn-link btn-lg fa-chevron-left has-fa-left p-x-lg pt-4 pb-4 ']");
    By toBenefitsLink = By.xpath("//a[@class='m-b-sm p-a-0 btn btn-link back-nav']");
    By volShortTermDisabShopPlansBtn = By.xpath("//a[@href='/subscriber/benefit/121142788']");
//    By volShortTermDisabShopPlansBtn = By.xpath("(//a[text()='Shop Plans'])[7]");
//    By volShortTermDisabShopPlansBtn = By.xpath("(//div[@class='col-sm-12 col-md-6 text-center-xs text-xs-center text-sm-center text-md-right pr-md-0'])[7]");
    By volShortTermDisabUpdateCartBtn = By.id("updateCartBtn");
    By verfn = By.xpath("//span[text()='Current Benefit Elections']");

    WebDriver driver;
    public AddPlans(WebDriver driver){
        this.driver=driver;
    }

    public boolean addplans() throws InterruptedException {
        CommonUtils cu = new CommonUtils(driver);
        driver.findElement(shopBenefitsBtn).click();
        driver.findElement(medicalShopPlansBtn).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight /2);");
        Thread.sleep(5000);

        driver.findElement(medicalUpdateCartBtn).click();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(5000);
        cu.wait.until(ExpectedConditions.elementToBeClickable(backBtn)).click();
        driver.findElement(toBenefitsLink).click();
        WebElement elem = cu.wait.until(ExpectedConditions.elementToBeClickable(volShortTermDisabShopPlansBtn));
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
        Thread.sleep(5000);
        elem.click();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(5000);
        driver.findElement(volShortTermDisabUpdateCartBtn).click();
        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        cu.wait.until(ExpectedConditions.elementToBeClickable(backBtn)).click();
        driver.findElement(toBenefitsLink).click();
        WebElement ele = cu.wait.until(ExpectedConditions.visibilityOfElementLocated(verfn));
        boolean result = false;
        if(ele!=null) {
            result = true;
        }
        return result;
    }


}
