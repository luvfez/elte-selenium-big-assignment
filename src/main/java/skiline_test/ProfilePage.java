package skiline_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getName() {
        WebElement element = driver.findElement(By.id("j_id261"));
        return element.getText();
    }

    public String getAboutMe() {
        WebElement spanElement = driver.findElement(By.className("about_me"));
        return spanElement.getText();
    }

}
