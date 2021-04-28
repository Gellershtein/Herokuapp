import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class HoversTest extends BaseTest {

    @Test
    public void checkHoversFunctionality() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);

        List<WebElement> avatars = driver.findElements(By.className("figure"));
//        userNamePacerAndCheck(avatars,0,action);
//        userNamePacerAndCheck(avatars,1,action);
//        userNamePacerAndCheck(avatars,2,action,driver);
        action.moveToElement(avatars.get(2)).build().perform();
//        String userName = driver.findElement(By.tagName("h5")).getText().split(" ")[1];
        String userName = driver.findElement(By.xpath("//div[3]/div/h5")).getText();
        assertEquals(userName, "user2" + 3, "Не совпадает");

    }

    public void userNamePacerAndCheck(List<WebElement> avatars, int avatarNumber, Actions action, WebDriver driver) {
        action.moveToElement(avatars.get(avatarNumber)).build().perform();
        String userName = driver.findElement(By.tagName("h5")).getText().split(" ")[0];
        assertEquals(userName, "user2" + avatarNumber + 1, "Не совпадает");
    }
}
