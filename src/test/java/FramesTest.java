import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest {

    @Test
    public void checkSwitchToIFrameFunctionality() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.cssSelector("//*[text()='iFrame']")).click();
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        String iFrameText = driver.findElement(By.id("tinymce")).getText();
        assertEquals(iFrameText, "Your content goes here.", "iFrame wasn't selected");
    }
}
