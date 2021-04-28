import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class SortableDataTablesTest extends BaseTest {
    @Test
    public void checkboxesCheckUncheck() {

        driver.get("http://the-internet.herokuapp.com/tables");
        List<WebElement> table1 = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        List<WebElement> table2 = driver.findElements(By.xpath("//table[2]//tbody//tr"));
        assertTrue(compareDropdownList(table1, table2), "Tables aren't equals");
    }

    public boolean compareDropdownList(List<WebElement> table1, List<WebElement> table2) {
        boolean isEquals = true;
        for (int i = 0; i < table1.size(); i++) {
            if (!table1.get(i).getText().equals(table2.get(i).getText())) {
                isEquals = false;
                break;
            }
        }
        return isEquals;
    }

}
