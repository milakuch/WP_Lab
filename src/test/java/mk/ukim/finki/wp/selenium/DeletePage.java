package mk.ukim.finki.wp.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePage extends AbstractPage {

    private WebElement name;

    @FindBy(css = "input[type=submit]")
    private WebElement submit;

    public DeletePage(WebDriver driver) {
        super(driver);
    }

    public static DeletePage openLogin(WebDriver driver) {
        get(driver, "/courses/courses/delete/680");
        System.out.println(driver.getCurrentUrl());
        return PageFactory.initElements(driver, DeletePage.class);

    }

    public static ButtonsLoggedInPage doAdd(WebDriver driver, DeletePage deletePage) {
        deletePage.submit.click();
        System.out.println(driver.getCurrentUrl());
        return PageFactory.initElements(driver, ButtonsLoggedInPage.class);
    }

    public static LoginPage logout(WebDriver driver) {
        get(driver, "/logout");
        return PageFactory.initElements(driver, LoginPage.class);
    }



}
