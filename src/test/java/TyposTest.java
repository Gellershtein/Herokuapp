import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {

    @Test
    public void checkTyposInText() {
        String original = "Typos\n" +
                "This example demonstrates a typo being introduced. It does it randomly on each page load.\n" +
                "Sometimes you'll see a typo, other times you won't.\n" +
                "Powered by Elemental Selenium";
        driver.get("http://the-internet.herokuapp.com/typos");
        String real = driver.findElement(By.tagName("body")).getText();

        assertEquals(real, original, "Тексты не совпадают");

    }
}
