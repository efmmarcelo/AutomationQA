package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    WebDriver driver;

    By emailInput = By.name("signup_email");
    By signUpNextBtn = By.xpath("//button[contains(@class,'signUpNextButtonClass')]");
    By signupPassword = By.name("signup_password");
    By phoneInput = By.xpath("//input[@placeholder='Mobile Number']");
    By usernameInput = By.name("firstlastname");
    By submitRegisterBtn = By.xpath("//button[@class='submitButton']");

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public void SignUpAndRegister(String email, String username, String phoneNumber, String password) {
        driver.findElement(emailInput).sendKeys(email);
        //Click on next button
        driver.findElement(signUpNextBtn).click();
        //Signup screen 2
        WebElement usernameElement = driver.findElement(usernameInput);
        RetryTextOnInput(usernameElement, username);
        WebElement phoneElement = driver.findElement(phoneInput);
        RetryTextOnInput(phoneElement, phoneNumber);
        WebElement passwordElement = driver.findElement(signupPassword);
        RetryTextOnInput(passwordElement, password);
        driver.findElement(submitRegisterBtn).click();
    }

    //Sometimes input elements erase it content.
    private void RetryTextOnInput(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
        try {
            new WebDriverWait(driver, 1).until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            System.out.printf("Text in input not accordingly '" + text + "', setting again...\n");
            element.clear();
            element.sendKeys(text);
        }
    }
}
