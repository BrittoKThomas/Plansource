import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateNewEmployee {

    By addNewEmployee = By.xpath("(//a[@class='action'])[1]");
    By passwordFieldForNewEmp = By.xpath("//input[@class='form-control password-eye ']");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By ssnField = By.id("ssn_text");
    By address1Field = By.id("address_1");
    By cityField = By.id("city");
    By stateField = By.id("stateTypeahead");
    By zipcodeField = By.id("zip_code");
    By countryField = By.id("countryTypeahead");
    By dobfield = By.id("birthdate");
    By genderField = By.id("gender");
    By maritalStatusField = By.id("marital_status");
    By hireDateField = By.id("hire_date");
    By eligibiltyHireDateField = By.id("benefits_start_date");
    By employmentLevelField = By.id("employment_level");
    By locationField = By.id("location");
    By currentSalField = By.id("current_salary");
    By benefitSalField = By.id("benefit_salary");
    By saveBtn = By.xpath("//button[text()='Save']");
    By basicInfoVerfn = By.xpath("//span[text()='Basic Information']");
    By errorLayer = By.id("layout_application_alert");

    WebDriver driver;
    public CreateNewEmployee(WebDriver driver){
        this.driver=driver;
    }

    public boolean createNewEmployee(String passwordfornewemployee, String firstname, String lastname, String ssn, String address1, String city, String state, String zipcode, String country, String birthdate, String currentsal, String benefitsal,
                                     String twoDaysBackDate) throws InterruptedException {
        CommonUtils cu = new CommonUtils(driver);
        driver.findElement(addNewEmployee).click();
        driver.findElement(passwordFieldForNewEmp).sendKeys(passwordfornewemployee);
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(ssnField).sendKeys(ssn);
        driver.findElement(address1Field).sendKeys(address1);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(dobfield).sendKeys(birthdate);

        WebElement genderEle = driver.findElement(genderField);
        Select genderSelct = new Select(genderEle);
        genderSelct.selectByVisibleText("Male");

        WebElement maritalSttsEle = driver.findElement(maritalStatusField);
        Select maritalSelct = new Select(maritalSttsEle);
        maritalSelct.selectByVisibleText("Single");

        driver.findElement(hireDateField).sendKeys(twoDaysBackDate);
        driver.findElement(eligibiltyHireDateField).sendKeys(twoDaysBackDate);

        WebElement empLvlEle = driver.findElement(employmentLevelField);
        Select empLvlSlct = new Select(empLvlEle);
        empLvlSlct.selectByIndex(1);

        WebElement locEle = driver.findElement(locationField);
        Select locSlct = new Select(locEle);
        locSlct.selectByIndex(1);

        driver.findElement(currentSalField).sendKeys(currentsal);
        driver.findElement(benefitSalField).sendKeys(benefitsal);
        driver.findElement(saveBtn).click();
        List<WebElement> elements = driver.findElements(errorLayer);
        boolean result = false;
        if(CollectionUtils.isEmpty(elements)){
            Thread.sleep(5000);
            WebElement ele = cu.wait.until(ExpectedConditions.visibilityOfElementLocated(basicInfoVerfn));
            if(ele!=null) {
                result = true;
            }
        }
        return result;
    }

}
