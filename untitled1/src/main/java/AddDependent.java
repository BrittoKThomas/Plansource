import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddDependent {

    By getStartedBtn = By.xpath("//a[text()='Get Started']");
    By reviewMyFamBtn = By.id("submit_form");
    By addFamMemberLink = By.xpath("//a[@href='/subscriber/family/new']");
    By firstNameFamMembrField = By.id("first_name");
    By lastNameFamMembrField = By.id("last_name");
    By genderBtn = By.xpath("(//span[text()='Select Gender'])[1]");
    By genderDropDwnVal = By.xpath("(//span[text()='Male'])[1]");
    By birthDateFamMem = By.id("birthdate");
    By relationshipBtn = By.xpath("(//span[text()='Select Relationship'])[1]");
    By relationshipDrpDwnVal = By.xpath("(//span[text()='Child'])[1]");
    By newFamSaveBtn = By.id("submit_form");
    By addMemberVerfn = By.xpath("//h4[text()='Current Family Members']");

    WebDriver driver;
    public AddDependent(WebDriver driver){
        this.driver=driver;
    }

    public boolean addDependent(String firstname, String lastname, String newFamBirthDate) throws InterruptedException {
        CommonUtils cu = new CommonUtils(driver);
        driver.findElement(getStartedBtn).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(reviewMyFamBtn).click();
        Thread.sleep(6000);
        driver.findElement(addFamMemberLink).click();
        driver.findElement(firstNameFamMembrField).sendKeys(firstname);
        driver.findElement(lastNameFamMembrField).sendKeys(lastname);
        driver.findElement(genderBtn).click();
        driver.findElement(genderDropDwnVal).click();
        driver.findElement(birthDateFamMem).sendKeys(newFamBirthDate);
        driver.findElement(relationshipBtn).click();
        driver.findElement(relationshipDrpDwnVal).click();
        driver.findElement(newFamSaveBtn).click();
        WebElement ele = cu.wait.until(ExpectedConditions.visibilityOfElementLocated(addMemberVerfn));
        boolean result = false;
        if(ele!=null) {
            result = true;
        }
        return result;
    }
}
