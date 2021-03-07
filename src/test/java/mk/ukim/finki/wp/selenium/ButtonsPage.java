package mk.ukim.finki.wp.selenium;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage extends AbstractPage {

    @FindBy(css = "a[class=edit]")
    private List<WebElement> editButtons;

    @FindBy(css = "a[class=add]")
    private List<WebElement> addButton;

    @FindBy(css = "a[class=delete]")
    private List<WebElement> deleteButtons;

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public static ButtonsPage to(WebDriver driver) {
        get(driver, "/coursesList");
        return PageFactory.initElements(driver, ButtonsPage.class);
    }

    public void assertElemts(int edit, int add, int delete) {
        Assert.assertEquals("No edit buttons", edit, this.editButtons.size());
        Assert.assertEquals("No delete buttons", delete, this.deleteButtons.size());
        Assert.assertEquals("No add button", add, this.addButton.size());
    }





}
