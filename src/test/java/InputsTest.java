import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class InputsTest extends BaseTest {

    @Test
    public void checkArrowUpDownFunctionality() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("10");
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), "11", "Arrow Up didn't work");
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), "10", "Arrow Down didn't work");
    }
}
