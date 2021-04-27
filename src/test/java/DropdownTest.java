import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class DropdownTest extends BaseTest {
    @Test
    public void selectDropdownOptionsTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        List<String> defaultOptionsList = new ArrayList<>();
        defaultOptionsList.add("Please select an option");
        defaultOptionsList.add("Option 1");
        defaultOptionsList.add("Option 2");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> optionsList = select.getOptions();
        //check dropdown list
        assertTrue(compareDropdownList(defaultOptionsList, optionsList), "Dropdown is empty or has difference");
        //select and check first (not default) option
        optionsList.get(1).click();
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1", "Option 1 isn't selected");
        //select and check second option
        optionsList.get(2).click();
        assertEquals(select.getFirstSelectedOption().getText(), "Option 2", "Option 2 isn't selected");


    }

    public boolean compareDropdownList(List<String> defaultOptionsList, List<WebElement> optionsList) {
        boolean isEquals = true;
        for (int i = 0; i < optionsList.size(); i++) {
            if (!optionsList.get(i).getText().equals(defaultOptionsList.get(i))) {
                isEquals = false;
                break;
            }
        }
        return isEquals;
    }
}
