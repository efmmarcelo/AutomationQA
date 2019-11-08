package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;

    By takeTour = By.xpath("//*[@class='helloBox helloBoxShow']");
    By closeDisclaimer = By.xpath("//*[@class='trademark-strip']//*[@class='icon-cancel']");
    By skipTour = By.xpath("//*[@class='ChatViewCommon ChatViewClose']");
    By currencyDropdown = By.className("sel_state");
    By loginPanel = By.xpath("//*[@class='loginPanel']//button");
    By registerBtn = By.xpath("//*[@class='loginDropdown']//*[contains(text(),'Register')]");
    By doneCurrency = By.className("doneButton");
    By usernameMenuText = By.xpath("//*[@class='userPanel']//strong");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void NavigateHomePage() {
        driver.get("https://staging.engineer.ai/home");
    }

    public void TakeAndSkipTour() {
        //Click on take a tour button.
        driver.findElement(takeTour).click();
        //Close disclaimer
        driver.findElement(closeDisclaimer).click();
        //Click on skip tour button.
        driver.findElement(skipTour).click();
    }

    public void SelectCurrency(String currency) {
        //Select currency as USD and then click on sign in then click on register button(close any pop up which comes).
        driver.findElement(currencyDropdown).click();
        //From options select the option with currency text
        driver.findElement(By.xpath("//*[@class='currencyName'][text()='" + currency + "']")).click();
    }

    public void GoToRegister() {
        //Select currency as USD and then click on sign in then click on register button(close any pop up which comes).
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(loginPanel)).click();
        //driver.findElement(loginPanel).click();
        driver.findElement(registerBtn).click();
    }

    public void ValidateRegister(String username) {
        //Closes the currency popup
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(doneCurrency)).click();

        // Verify that user is registered successful(from upper right side user contains initials of email) and user is on homepage
        WebElement userDropdown = driver.findElement(usernameMenuText);
        assert userDropdown.getText().equals(username) : "Registered user " + username + " is not the same as in home page: " + userDropdown.getText();
        assert driver.getCurrentUrl().equals("https://staging.engineer.ai/home") : "Url of home page does not match";
    }
}
