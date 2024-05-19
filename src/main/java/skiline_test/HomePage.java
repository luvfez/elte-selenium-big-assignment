package skiline_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitForAndClickOnRegister() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement registerButton = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("top_login_form:j_id205")));
        registerButton.click();
    }

}
