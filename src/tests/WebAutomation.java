package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.Home;
import pages.Register;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class WebAutomation {
    //private static WebDriver driver;
    public static WebDriver driver;

    public static void main(String[] args) {
        driver = GetDriver("Chrome", false);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Home home = new Home(driver);
        home.NavigateHomePage();
        home.TakeAndSkipTour();
        home.SelectCurrency("US Dollars");
        home.GoToRegister();

        Register register = new Register(driver);
        //Generating random user credentials:
        String email = WebAutomation.RandomString(15) + "@test.com";
        String username = RandomString(6);
        String password = RandomString(9);
        //Proceed to register
        register.SignUpAndRegister(email, username, "+351912345678", password);
        home.ValidateRegister(username);

        //Closing the browser
        driver.close();
    }


    public static String RandomString(int count) {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final SecureRandom RANDOM = new SecureRandom();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    private static WebDriver GetDriver(String browser, boolean headless) {
        WebDriver driver;
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "Firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.printf("Browser not found, using Chrome as default");
                driver = new ChromeDriver();
        }
        return driver;
    }
}
