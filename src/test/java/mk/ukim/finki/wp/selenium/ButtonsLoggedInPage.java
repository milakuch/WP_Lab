package mk.ukim.finki.wp.selenium;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsLoggedInPage extends AbstractPage {

    @FindBy(className = "edit")
    private List<WebElement> editButtons;

    @FindBy(className = "add")
    private List<WebElement> addButton;

    @FindBy(className = "delete")
    private List<WebElement> deleteButtons;

//    @FindBy(css = "input[name=MIS]")
//    private WebElement name;
//
    public ButtonsLoggedInPage(WebDriver driver) {
        super(driver);
    }

    public static ButtonsLoggedInPage to(WebDriver driver) {
        get(driver, "/courses");
        return PageFactory.initElements(driver, ButtonsLoggedInPage.class);
    }

    public void assertElemts(int edit, int add, int delete) {
        Assert.assertEquals("Edit buttons exist", edit, this.editButtons.size());
        Assert.assertEquals("Delete buttons exist", delete, this.deleteButtons.size());
        Assert.assertEquals("Add button exists", add, this.addButton.size());
    }

//    public void changename(String str) {
//        Assert.assertEquals("Name successfully changed", str, this.name);
//    }





}
