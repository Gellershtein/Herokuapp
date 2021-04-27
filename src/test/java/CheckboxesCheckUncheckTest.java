import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class CheckboxesCheckUncheckTest extends BaseTest {
    @Test
    public void CheckboxesCheckUncheckTest() {
        logIn(driver);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        //First checkbox
        assertFalse(checkboxes.get(0).isSelected(), "Чекбокс отмечен");
        checkboxes.get(0).click();
        assertTrue(checkboxes.get(0).isSelected(), "Чекбокс не отмечен");
        //Second checkbox
        assertTrue(checkboxes.get(1).isSelected(), "Чекбокс не отмечен");
        checkboxes.get(1).click();
        assertFalse(checkboxes.get(1).isSelected(), "Чекбокс отмечен");
    }

}
