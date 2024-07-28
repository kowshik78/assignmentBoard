package tests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BoardAdd;
import org.openqa.selenium.Keys;
import static utils.Constant.*;

public class boardAddTest extends BaseTest {
    private WebElement w2,w3;
    @Test
    public void boardTest() throws Exception {
        try {
            w2 = page.getInstance(BoardAdd.class).getblankboardPage();
        }
        catch (Exception e) {
            w3 = page.getInstance(BoardAdd.class).getBoard();
        }
        if(w2!=null){
            page.getInstance(BoardAdd.class).getblankboardTitle().sendKeys(boardName);
            Actions action = new Actions(driver);
            action.moveToElement(w2).sendKeys(Keys.ENTER).build().perform();
        }
        else {
            w3.click();
            page.getInstance(BoardAdd.class).getBoardName().sendKeys(boardName);
            page.getInstance(BoardAdd.class).getCreateButton().click();
        }
        Thread.sleep(4000);

        WebElement w1=page.getInstance(BoardAdd.class).getNameVerify();
        System.out.println(w1.getText());

        int i=2;
        while(i>0) {
            if (i == 2) {
                page.getInstance(BoardAdd.class).getAddListName().sendKeys(list2);
            }
            else {
                page.getInstance(BoardAdd.class).getAddListName().sendKeys(list1);
            }

            page.getInstance(BoardAdd.class).getAddListButton().click();
            i--;
        }
        Thread.sleep(4000);

        page.getInstance(BoardAdd.class).getActionButton().click();
        page.getInstance(BoardAdd.class).getDeleteButton().click();
    }
}
