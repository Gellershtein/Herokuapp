import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest {

    @Test
    public void downloadFileToSite() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement downloadedFile = driver.findElement(By.xpath("//*[@id='content']//a"));
        String downloadedFileName = downloadedFile.getText();
        downloadedFile.click();
        Thread.sleep(2000, 1);
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean isFound = false;
        File foundedFile = null;

        //Look for the file in the files
        // You should write smart REGEX according to the filename
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches(downloadedFileName)) {
                    foundedFile = new File(fileName);
                    isFound = true;
                }
            }
        }
        assertTrue(isFound, "Downloaded document is not found");
        foundedFile.deleteOnExit();
    }
}
