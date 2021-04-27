import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HerokuappTest {

    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        //WebDriver driver = new RemoteWebDriver(new URL("1.1.1.1"), null);
//        options.addArguments("--headless");
//        driver.manage().window().setSize(new Dimension(1024,768));
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);//неявные ожидания
//        driver.manage().getCookieNamed("session_id").getValue();
        driver.get("http://the-internet.herokuapp.com/");
        driver.quit();
    }
}
