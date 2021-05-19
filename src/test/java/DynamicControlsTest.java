import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class DynamicControlsTest extends BaseTest {

    @Test
    public void checkDynamicControlsFunctionality() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        boolean isDisplayed = checkbox.isDisplayed();
        assertTrue(isDisplayed, "Checkbox is not displayed");
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(), "It's gone!", "Invalid message after removing Checkbox");
        try {
            isDisplayed = checkbox.isDisplayed();
        } catch (StaleElementReferenceException exception) {
            isDisplayed = false;
        }
        assertFalse(isDisplayed, "Checkbox is still visible");
        WebElement elementInput = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        boolean isDisabled;
        try {
            elementInput.getAttribute("disabled");
            isDisabled = true;
        } catch (StaleElementReferenceException exception) {
            isDisabled = false;
        }
        assertTrue(isDisabled, "Input is not disabled");
        driver.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        WebElement inputField = driver.findElement(By.xpath("//form[@id='input-example']/p"));
        wait.until(ExpectedConditions.visibilityOf(inputField));
        assertEquals(inputField.getText(), "It's enabled!", "Invalid message after try enabling Input");
        try {
            elementInput.sendKeys("test input");
            isDisabled = false;
        } catch (StaleElementReferenceException exception) {
            isDisabled = true;
        }
        assertFalse(isDisabled, "Input is disabled");
    }
}

