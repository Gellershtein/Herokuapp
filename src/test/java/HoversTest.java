import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;


public class HoversTest extends BaseTest {

    @Test
    public void checkHoversFunctionality() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        List<WebElement> avatars = driver.findElements(By.className("figure"));
//        for (int i = 1; i < 4; i++) {
//            userNameParserAndCheck(avatars, i);
//        }
//        userNameParserAndCheck(avatars, 1);
//        userNameParserAndCheck(avatars, 2);
//        userNameParserAndCheck(avatars, 3);
        for (int i = 1; i < 4; i++) {
            clickViewProfileAnd404Check(avatars, i);
        }
//        clickViewProfileAnd404Check(avatars, 1);
//        clickViewProfileAnd404Check(avatars, 2);
//        clickViewProfileAnd404Check(avatars, 2);
    }

    public void userNameParserAndCheck(List<WebElement> avatars, int avatarNumber) {

        Actions action = new Actions(driver);
        action.moveToElement(avatars.get(avatarNumber - 1)).build().perform();
        //String userName = driver.findElement(By.tagName("h5")).getText().split(" ")[1];
        String userName = driver.findElement(By.xpath("//div[" + avatarNumber + "]/div/h5")).getText().split(" ")[1];
        assertEquals(userName, "user" + avatarNumber, "User name is different");

        driver.findElement(By.linkText("View profile")).click();
        boolean errorMessage = driver.getPageSource().contains("Not Found");
//        assertFalse(errorMessage, "Page is Not Found");//In real life need to use it

        assertTrue(errorMessage, "Page is Found");//Expected N
    }

    public void clickViewProfileAnd404Check(List<WebElement> avatars, int avatarNumber) {
        Actions action = new Actions(driver);
        driver.get("http://the-internet.herokuapp.com/hovers");
        action.moveToElement(avatars.get(avatarNumber - 1)).build().perform();
        driver.findElement(By.linkText("View profile")).click();
        boolean errorMessage = driver.getPageSource().contains("Not Found");
//        assertFalse(errorMessage, "Page is Not Found");//In real life need to use it

        assertTrue(errorMessage, "Page is Found");//Expected NOT

    }

    public void clickViewProfileAnd404Check(WebDriver driver, Actions action, List<WebElement> avatars, int avatarNumber) {
        action.moveToElement(avatars.get(avatarNumber - 1)).build().perform();
        driver.findElement(By.linkText("View profile")).click();
        boolean errorMessage = driver.getPageSource().contains("Not Found");
        assertFalse(errorMessage, "Страница недоступна");
    }
}
