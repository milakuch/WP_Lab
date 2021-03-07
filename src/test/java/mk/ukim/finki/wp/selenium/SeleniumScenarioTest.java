package mk.ukim.finki.wp.selenium;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.service.CourseService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;
@ActiveProfiles("test")
public class SeleniumScenarioTest {
    private WebDriver driver;
//    private Map<String, Object> vars;
//    JavascriptExecutor js;
    private static boolean dataInitialized = false;

    @Autowired
    CourseService courseService;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tokyo\\Desktop\\Web Programiranje\\chromedriver0.exe");
        driver = new ChromeDriver();
//        js = (JavascriptExecutor) driver;
//        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }


    private void initData() {
        if (!dataInitialized) {

            Course course1 = new Course("Kurs 1","desc",new ArrayList<Student>());
            Course course2 = new Course("Kurs 2","desc",new ArrayList<Student>());
            courseService.addCourse(course1);
            courseService.addCourse(course2);
            dataInitialized = true;
        }
    }

    @Test
    public void testScenario() throws Exception {
        ButtonsPage buttonsPage = ButtonsPage.to(this.driver);
        buttonsPage.assertElemts(0, 0, 0);
        LoginPage loginPage = LoginPage.openLogin(this.driver);

        ButtonsLoggedInPage buttons2Page = LoginPage.doLogin(this.driver, loginPage,"admin", "admin");
        buttons2Page.assertElemts(2, 1, 2);

        AddCoursePage addCoursePage = AddCoursePage.openLogin(this.driver);
        buttons2Page = AddCoursePage.doAdd(this.driver, addCoursePage,"Kurs 3", "Kurs 3");

        buttons2Page.assertElemts(3, 1, 3);

        EditPage editPage = EditPage.openLogin(this.driver);
//        buttons2Page=EditPage.doAdd(this.driver,editPage," 2");
//
//        buttons2Page.changename("MIS 2");
//        DeletePage deletePage = DeletePage.openLogin(this.driver);
//        buttons2Page=DeletePage.doAdd(this.driver,deletePage);
//        buttons2Page.assertElemts(2, 1, 2);

    }






//    @Test
//    public void loginlogout() {
//        driver.get("http://localhost:9090/");
//        driver.manage().window().setSize(new Dimension(749, 728));
//        driver.findElement(By.linkText("Login")).click();
//        driver.findElement(By.id("username")).click();
//        driver.findElement(By.id("username")).sendKeys("admin");
//        driver.findElement(By.id("password")).click();
//        driver.findElement(By.id("password")).sendKeys("admin");
//        driver.findElement(By.cssSelector(".btn")).click();
//        driver.findElement(By.linkText("Edit")).click();
//        driver.findElement(By.id("name")).click();
//        driver.findElement(By.id("name")).sendKeys("AAA");
//        driver.findElement(By.name("tip")).click();
//        driver.findElement(By.id("teach")).click();
//        driver.findElement(By.cssSelector("input:nth-child(18)")).click();
//        driver.findElement(By.cssSelector("div:nth-child(2) > a:nth-child(2)")).click();
//        driver.findElement(By.cssSelector("button")).click();
//        driver.findElement(By.linkText("Add new course")).click();
//        driver.findElement(By.id("name")).click();
//        driver.findElement(By.id("name")).sendKeys("AA");
//        driver.findElement(By.id("description")).click();
//        driver.findElement(By.id("description")).sendKeys("AAAAA");
//        driver.findElement(By.id("teach")).click();
//        driver.findElement(By.name("tip")).click();
//        driver.findElement(By.cssSelector("input:nth-child(12)")).click();
//        driver.findElement(By.linkText("Logout")).click();
//    }
}
