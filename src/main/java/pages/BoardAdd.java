package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class BoardAdd extends BasePage {
    public BoardAdd(WebDriver driver) throws IOException {
        super(driver);
    }

    private final By blankboardPage = By.xpath("//*[text()=\" Get started! \"]");
    private final By blankboardTitle = By.xpath("//*[@id=\"app\"]/div/div[2]/div/input");
    private final By board = By.xpath("//*[text()=\" Create new board \"]");
    private final By boardName = By.xpath("//*[@placeholder=\"Add board title\"]");
    private final By createButton = By.xpath("//*[text()=\"Create board\"]");
    private final By nameVerify = By.xpath("//*[@class=\"py-2.5\"]");

    private final By addListName = By.xpath("//*[@placeholder=\"Enter list title...\"]");
    private final By addListButton = By.xpath("//*[@id=\"app\"]//div[3]//div/button");
    private final By actionButton = By.cssSelector("#app > div > div > div > div.py-2\\.5 > div:nth-child(3) > button");
    private final By deleteButton = By.xpath("//*[text()=\"Delete board\"]");

    public WebElement getblankboardPage(){return elementWithWait(blankboardPage,"clickable");}
    public WebElement getblankboardTitle(){return elementWithWait(blankboardTitle,"clickable");}
    public WebElement getBoard(){return elementWithWait(board,"clickable");}
    public WebElement getBoardName(){return elementWithWait(boardName,"clickable");}
    public WebElement getCreateButton(){return elementWithWait(createButton,"clickable");}
    public WebElement getNameVerify(){return elementWithWait(nameVerify,"visibility");}

    public WebElement getAddListName(){return elementWithWait(addListName,"clickable");}
    public WebElement getAddListButton(){return elementWithWait(addListButton,"clickable");}
    public WebElement getActionButton(){return elementWithWait(actionButton,"clickable");}
    public WebElement getDeleteButton(){return elementWithWait(deleteButton,"clickable");}


}
