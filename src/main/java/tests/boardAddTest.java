package tests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BoardAdd;
import org.openqa.selenium.Keys;
import static utils.Constant.*;

public class boardAddTest extends BaseTest {
    @Test
    public void boardTest() throws Exception {
        WebElement w2= page.getInstance(BoardAdd.class).getblankboardPage();
        if(w2.isDisplayed()){
            page.getInstance(BoardAdd.class).getblankboardTitle().sendKeys(boardName);
            Actions action = new Actions(driver);
            action.moveToElement(w2).sendKeys(Keys.ENTER).build().perform();
        }
        else {
            page.getInstance(BoardAdd.class).getBoard().click();
            page.getInstance(BoardAdd.class).getBoardName().sendKeys(boardName);
            page.getInstance(BoardAdd.class).getCreateButton().click();
        }
        Thread.sleep(4000);

        WebElement w1=page.getInstance(BoardAdd.class).getNameVerify();
        System.out.println(w1.getText());
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(w1.getText(),boardName);
        if (w1.getText().equals(boardName)) {System.out.println("Success");}
        else {System.out.println("Fail");}

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
