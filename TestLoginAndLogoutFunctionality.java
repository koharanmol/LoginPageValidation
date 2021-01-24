import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.logging.Logger;


public class TestLoginAndLogoutFunctionality extends BaseElements {
    private String valid_email_address = "koharanmol@hotmail.com";
    private String valid_password = "TestWebsite123";
    private String Invalid_email_address = "koharanmol@gmail.com";
    private String Invalid_password = "123";
    private String sign_out_xpath = "//*[text()='Sign Out']";
    private String heading_classpath = "tSU--card__title";
    private String alert_box_classpath = "o--alert__text";
    WebDriverWait wait = new WebDriverWait(getDriver(),3,100);
    Logger logger = Logger.getLogger(TestLoginAndLogoutFunctionality.class.getName());

    /*
    1. Login to the website("https://app.later.com/user/login")
    2. Input Valid Email and Password
    3. Validate Account created link
    4. Sign Out from the website
    5. Close the browser.
     */
    @Test(groups={"Critical"})
    public void validate_valid_email_and_password() throws InterruptedException {
        logger.info("Browser is successfully launched.");
        Thread.sleep(2000);
        getEmail_input_field().sendKeys(valid_email_address);
        logger.info("Email entered:- " + valid_email_address);
        getPassword_input_field().sendKeys(valid_password);
        logger.info("Password entered:- " + valid_password);
        getSign_in_button().click();
        logger.info("Successfully Logged into the account.");
        Assert.assertTrue(getAccount_create_validation().isDisplayed());
        logger.info("Account is verified and Logged in.");
        Thread.sleep(3000);
        setSign_out_button(getDriver().findElement(By.xpath(sign_out_xpath)));
        getSign_out_button().click();
        logger.info("Account is Logged out.");
        Thread.sleep(2000);
        setSign_in_heading(getDriver().findElement(By.className(heading_classpath)));
        Assert.assertTrue(getSign_in_heading().isDisplayed());
        logger.info("Account is successfully Logged out.");
    }
    /*
    1. Login to the website("https://app.later.com/user/login")
    2. Input Valid Email and Invalid Password
    3. Validate Account created link
 */
    @Test(groups={"Critical"})
    public void validate_valid_email_and_invalid_password() {
        logger.info("Browser is successfully launched.");
        getEmail_input_field().sendKeys(valid_email_address);
        logger.info("Email entered:- " + valid_email_address);
        getPassword_input_field().sendKeys(Invalid_email_address);
        logger.info("Password entered:- " + Invalid_password);
        getSign_in_button().click();
        logger.info("Clicked on Sign In button.");
        setAlert_link(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(alert_box_classpath))));
        Assert.assertTrue(getAlert_link().getText().contains("Invalid Email or password"));
        logger.info("Logged an error:- Invalid Email or password.");
    }
    /*
    1. Login to the website("https://app.later.com/user/login")
    2. Input Invalid Email and valid Password
    3. Validate Account created link
*/
    @Test(groups={"High"})
    public void validate_invalid_email_and_valid_password(){
        logger.info("Browser is successfully launched.");
        getEmail_input_field().sendKeys(Invalid_email_address);
        logger.info("Email entered:- " + Invalid_email_address);
        getPassword_input_field().sendKeys(valid_password);
        logger.info("Password entered:- " + valid_password);
        getSign_in_button().click();
        logger.info("Clicked on Sign In button.");
        setAlert_link(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(alert_box_classpath))));
        Assert.assertTrue(getAlert_link().getText().contains("Invalid Email or password"));
        logger.info("Logged an error:- Invalid Email or password.");
    }
    /*
    1. Login to the website("https://app.later.com/user/login")
    2. Input Invalid Email and valid Password
    3. Validate Account created link
*/
    @Test(groups={"High"})
    public void validate_invalid_email_and_invalid_password(){
        logger.info("Browser is successfully launched.");
        getEmail_input_field().sendKeys(Invalid_email_address);
        logger.info("Email entered:- " + Invalid_email_address);
        getPassword_input_field().sendKeys(Invalid_password);
        logger.info("Password entered:- " + Invalid_password);
        getSign_in_button().click();
        logger.info("Clicked on Sign In button.");
        setAlert_link(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(alert_box_classpath))));
        Assert.assertTrue(getAlert_link().getText().contains("Invalid Email or password"));
        logger.info("Logged an error:- Invalid Email or password.");
    }
    /*
    1. Login to the website("https://app.later.com/user/login")
    2. Input empty Email and empty Password
    3. Validate Account created link
*/
    @Test(groups={"High"})
    public void validate_empty_email_and_empty_password(){
        logger.info("Browser is successfully launched.");
        getEmail_input_field().sendKeys("");
        logger.info("Email entered:- " + " ");
        getPassword_input_field().sendKeys("");
        logger.info("Password entered:- " + " ");
        getSign_in_button().click();
        logger.info("Clicked on Sign In button.");
        setAlert_link(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(alert_box_classpath))));
        Assert.assertTrue(getAlert_link().getText().contains("You need to sign in or sign up before continuing."));
        logger.info("You need to sign in or sign up before continuing.");
    }
    @AfterMethod
    public void CloseBrowser(){
        getDriver().close();
        logger.info("Browser is successfully closed.");
    }
}
