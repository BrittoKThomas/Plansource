import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginToPortal {
    By usernameField = By.id("user_name");
    By passwordField = By.xpath("//input[@autofocus='autofocus' and @name='password']");
    By loginBtn = By.id("logon_submit");
    By homePageVerfn = By.xpath("//img[@alt='Testing Plansource Client']");

    WebDriver driver;
    public LoginToPortal(WebDriver driver){
        this.driver=driver;
    }
    public void navigateToURL(String url) throws InterruptedException {
        driver.get(url);
//        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    public boolean login_To_PlanSource_Portal(String username, String password) throws InterruptedException {
    CommonUtils cu = new CommonUtils(driver);
    driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
        Thread.sleep(5000);
        WebElement ele = driver.findElement(homePageVerfn);
//        WebElement ele = cu.wait.until(ExpectedConditions.visibilityOfElementLocated(homePageVerfn));
        boolean result = false;
        if(ele!=null) {
            result = true;
        }
        return result;
    }


    public void new_Hire_Enrollment(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


}
