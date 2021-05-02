import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HoversTest extends BaseTest {

    @Test
    public void checkHoversFunctionality() {
        for (int i = 1; i < 4; i++) {
            userNameParserAndCheck(i);
        }
    }

    public void userNameParserAndCheck(int avatarNumber) {
        driver.get("http://the-internet.herokuapp.com/hovers");
        List<WebElement> avatars = driver.findElements(By.className("figure"));
        Actions action = new Actions(driver);
        action.moveToElement(avatars.get(avatarNumber - 1)).build().perform();
        //String userName = driver.findElement(By.tagName("h5")).getText().split(" ")[1];
        String userName = driver.findElement(By.xpath("//div[" + avatarNumber + "]/div/h5")).getText().split(" ")[1];
        assertEquals(userName, "user" + avatarNumber, "User name is different");
        driver.findElement(By.linkText("View profile")).click();
        boolean errorMessage = driver.getPageSource().contains("Not Found");
//        assertFalse(errorMessage, "Page is Not Found");//In real life need to use it
        assertTrue(errorMessage, "Page is Found");//Expected Not Found
    }
}
