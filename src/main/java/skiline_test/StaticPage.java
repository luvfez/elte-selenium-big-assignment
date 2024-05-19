package skiline_test;

import org.openqa.selenium.WebDriver;

public class StaticPage extends BasePage {

    public StaticPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
