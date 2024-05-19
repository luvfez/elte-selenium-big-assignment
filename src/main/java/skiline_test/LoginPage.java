package skiline_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By usernameField = By.id("top_login_form:userName");
    private By passwordField = By.id("top_login_form:password");
    private By loginButton = By.id("top_login_form:topLoginSubmit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getUsername() {
        String xpath = "//div[@id='topNavi']//span[@class='ellipsis']";
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.getText();
    }

    public void logout() {
        WebElement profileHoverDropdown = driver.findElement(By.id("profile_li"));
        Actions actions = new Actions(driver);
        actions.moveToElement(profileHoverDropdown).perform();
        WebElement logoutButton = driver.findElement(By.id("j_id242"));
        logoutButton.click();
    }

    public boolean isUsernameFieldPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
