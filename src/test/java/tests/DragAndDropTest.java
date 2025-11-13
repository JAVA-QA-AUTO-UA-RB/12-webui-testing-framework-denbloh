package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import pages.HomePage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDrop() {
        new HomePage(driver).open(BASE_URL).goToDragAndDrop();

        DragAndDropPage page = new DragAndDropPage(driver);
        page.dragAtoB();
        String columnText = page.getColumnAText();

        System.out.println("Test 6. Drag and Drop - Column A text after swap: " + columnText);
        Assert.assertEquals(columnText, "B");
    }
}
