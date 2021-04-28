import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void logIn() {
        driver.get("http://the-internet.herokuapp.com/login");
        //        driver.findElement(By.id("username")).sendKeys("tomsmith");
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        assertEquals(userName.getAttribute("value"), "tomsmith", "Юзер не был введен");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        userName.submit();
        boolean logOutButton = driver.findElement(By.cssSelector(".secondary")).isDisplayed();
        assertTrue(logOutButton,
                "Аккаунт не залогировался");
    }
}
