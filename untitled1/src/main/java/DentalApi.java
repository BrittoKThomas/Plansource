import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DentalApi {

    By collapsibleNavMenu = By.id("toggleNavMenu");
    By adminSidebar = By.xpath("//span[text()='Admin']");
    By proceedToCheckOut = By.xpath("//span[text()='Proceed to Checkout']");
    By checkoutBtn = By.xpath("//button[@class='btn btn-primary btn-lg full-width-sm p-x-xl']");

    WebDriver driver;
    public DentalApi(WebDriver driver){
        this.driver=driver;
    }
    
    public static void dentalPlan(String sessionId) {

        try {
            URL url = new URL("https://partner-dev-benefits.plansource.com/v1/self_service/coverages");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();


            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Cookie", "_session_id=" + sessionId);
            conn.setRequestProperty("Referer", "https://partner-dev-benefits.plansource.com/subscriber/benefit/121137668");
            conn.setDoOutput(true);


            String jsonInputString = "{\n" +
                    "  \"election\": {\n" +
                    "    \"coverage_level_id\": 137,\n" +
                    "    \"dependent_ids\": [],\n" +
                    "    \"org_plan_id\": 319901188\n" +
                    "  },\n" +
                    "  \"enrollment_context_type\": \"initial\",\n" +
                    "  \"include_benefits_in_response\": true,\n" +
                    "  \"include_related_coverage_changes\": true,\n" +
                    "  \"life_event_completed\": false,\n" +
                    "  \"org_benefit_id\": 121137668\n" +
                    "}";


            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }


            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Dental plan enrolled successfully.");
            } else {
                System.out.println("API call failed. Response Code: " + responseCode);
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public boolean checkout(){
        driver.findElement(collapsibleNavMenu).click();
        driver.findElement(adminSidebar).click();
        driver.findElement(proceedToCheckOut).click();
        WebElement ele = driver.findElement(checkoutBtn);
        boolean result = false;
        if(ele!=null) {
            result = true;
        }
        return result;
    }

}
