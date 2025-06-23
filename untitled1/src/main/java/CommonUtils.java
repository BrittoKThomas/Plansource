import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CommonUtils {
    WebDriver driver;
    WebDriverWait wait;
    public CommonUtils(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }


    public String getDateTwoDaysbackFromCurrentDate () {
        // Get today's date
        LocalDate today = LocalDate.now();

        // Subtract 2 days
        LocalDate twoDaysBack = today.minusDays(2);

        // Format the date if needed (e.g., YYYY-MM-DD)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = twoDaysBack.format(formatter);

        // Print the result
        System.out.println("Date 2 days ago: " + formattedDate);
        return formattedDate;
    }

    public String generateRandomName(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char letter = alphabet.charAt(random.nextInt(alphabet.length()));
            word.append(letter);
        }

        return word.toString();
    }

    public String generateRandomSSN() {
        Random random = new Random();

        int area = random.nextInt(900) + 100;        // 100–999
        int group = random.nextInt(90) + 10;         // 10–99
        int serial = random.nextInt(9000) + 1000;    // 1000–9999

        return area + "-" + group + "-" + serial;
    }
}
