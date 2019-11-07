import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAutomation {
    public static WebDriver driver;

    public static void main(String[] args) {
        driver = GetDriver("Chrome");
        driver.manage().window().maximize();
        new EngineerAutomation();
        driver.close();
    }

    private static WebDriver GetDriver(String browser) {
        WebDriver driver;
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            //case "Firefox":
            //...
            default:
                System.out.printf("Browser not found, using Chrome as default");
                driver = new ChromeDriver();
        }
        return driver;
    }
}
