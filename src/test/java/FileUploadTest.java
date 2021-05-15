import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {

    @Test
    public void uploadFileToSite() {
        driver.get("http://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/uploadFile.txt");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
    }
}
