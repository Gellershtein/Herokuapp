import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class NotificationTest extends BaseTest {

    @Test
    public void notificationCheck() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//a[contains(@href, '/notification_message')]")).click();
        String notificationMessage = driver.findElement(By.id("flash")).getText();
        assertEquals(notificationMessage, "Action successful\n" + "×", "Incorrect notification");
    }
}
