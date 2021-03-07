package mk.ukim.finki.wp.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage extends AbstractPage {

    private WebElement name;

    @FindBy(css = "input[value=Submit]")
    private WebElement submit;

    public EditPage(WebDriver driver) {
        super(driver);
    }

    public static EditPage openLogin(WebDriver driver) {
        get(driver, "/courses/edit-form/272");
        System.out.println(driver.getCurrentUrl());
        return PageFactory.initElements(driver, EditPage.class);

    }

    public static ButtonsLoggedInPage doAdd(WebDriver driver, EditPage addCoursePage, String name) {
        addCoursePage.name.sendKeys(name);
        addCoursePage.submit.click();
        System.out.println(driver.getCurrentUrl());
        return PageFactory.initElements(driver, ButtonsLoggedInPage.class);
    }

    public static LoginPage logout(WebDriver driver) {
        get(driver, "/logout");
        return PageFactory.initElements(driver, LoginPage.class);
    }



}
