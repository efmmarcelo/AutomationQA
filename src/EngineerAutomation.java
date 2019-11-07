import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EngineerAutomation extends WebAutomation {

    public EngineerAutomation() {
        driver.get("https://staging.engineer.ai/home");
        TakeAndSkipTour();
        SelectCurrency("Euro");
        SignUpAndRegister();
    }


    private void TakeAndSkipTour() {
        //WebElement takeTour = driver.findElement(By.xpath("//*????"));
        //        Click on take a tour button.
        //        Click on skip tour button.
    }


    private void SelectCurrency(String currency) {
        //Select currency as USD and then click on sign in then click on register button(close any pop up which comes).
        WebElement takeTour = driver.findElement(By.className("sel_state"));
        takeTour.click();
        //From options select the option with currency text
    }

    private void SignUpAndRegister() {
        //Complete sign up and click on register.
    }

    private void ValidateRegister() {
        // Verify that user is registered successfull(from upper right side user contains initials of email) and user is on homepage
    }
}
