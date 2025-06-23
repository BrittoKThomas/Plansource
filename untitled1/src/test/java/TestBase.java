import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver;
    @BeforeClass
    public static void setup(){
        if(driver==null) {
            System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    @AfterSuite
        public static void tearDown(){
            if(driver!=null){
                driver.quit();
            }
    }


//    static{
//        System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/chromedriver.exe");
//    }
//    WebDriver driver ;

//    WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(120));

}


