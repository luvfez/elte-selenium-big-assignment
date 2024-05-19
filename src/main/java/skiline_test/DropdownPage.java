package skiline_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    private By dropdownField = By.id("selectForm:country_decorator:country");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void selectIndexFromDropdown(int index) {
        WebElement dropdownElement = driver.findElement(dropdownField);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    public String getDropdownSelectedOption() {
        WebElement dropdownElement = driver.findElement(dropdownField);
        Select dropdown = new Select(dropdownElement);
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        return selectedOption.getText();
    }

}
