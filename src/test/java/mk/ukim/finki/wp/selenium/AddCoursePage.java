package mk.ukim.finki.wp.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddCoursePage extends AbstractPage {

    private WebElement name;

    private WebElement description;

    @FindBy(css = "input[type=submit]")
    private WebElement submit;

    @FindBy(css = "input[id=teach]")
    private WebElement teacher;

    @FindBy(css = "input[name=tip]")
    private WebElement type;

    public AddCoursePage(WebDriver driver) {
        super(driver);
    }

    public static AddCoursePage openLogin(WebDriver driver) {
        get(driver, "/courses/add");
        System.out.println(driver.getCurrentUrl());
        return PageFactory.initElements(driver, AddCoursePage.class);

    }

    public static ButtonsLoggedInPage doAdd(WebDriver driver, AddCoursePage addCoursePage, String name, String description) {
        addCoursePage.name.sendKeys(name);
        addCoursePage.description.sendKeys(description);
        addCoursePage.teacher.click();
        addCoursePage.type.click();
        addCoursePage.submit.click();
        System.out.println(driver.getCurrentUrl());
        return PageFactory.initElements(driver, ButtonsLoggedInPage.class);
    }

    public static LoginPage logout(WebDriver driver) {
        get(driver, "/logout");
        return PageFactory.initElements(driver, LoginPage.class);
    }



}
