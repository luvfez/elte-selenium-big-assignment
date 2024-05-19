package skiline_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class ProfileEditPage extends BasePage {

    private By usernameField = By.id("edit_personal_profile_form:user_name_decorator:user_name");
    private By aboutMeField = By.id("edit_personal_profile_form:aboutMe_decorator:aboutMe");
    private WebElement saveButton;

    public ProfileEditPage(WebDriver driver) {
        super(driver);
    }

    public void changeUsername(String newUsername) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(newUsername);
    }

    public void changeAboutMe(String newAboutMe) {
        driver.findElement(aboutMeField).clear();
        driver.findElement(aboutMeField).sendKeys(newAboutMe);
    }

    public void saveProfile() {
        saveButton = driver.findElement(By.xpath(
                "//a[contains(@class, 'button_left') and contains(@class, 'pink') and contains(@class, 'browse') and contains(@class, 'button_left') and contains(@class, 'button_arrow_left')]/span[text()='Save']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", saveButton);
    }

}
