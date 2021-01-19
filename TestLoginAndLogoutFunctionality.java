import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestLoginAndLogoutFunctionality extends BaseElements {
    private String valid_email_address = "koharanmol@hotmail.com";
    private String valid_password = "TestWebsite123";
    private String Invalid_email_address = "koharanmol@gmail.com";
    private String Invalid_password = "123";
    private String ExplicitWait = "\"/html/body/div[3]/div/div[2]/div\"";
    WebDriverWait wait = new WebDriverWait(getDriver(),2);
    public TestLoginAndLogoutFunctionality() {
        super();
    }

    /*
    1. Login to the website("https://app.later.com/user/login")
    2. Input Valid Email and Password
    3. Validate Account created link
    4. Sign Out from the website
    5. Close the browser.
     */
    @Test
    public void validate_valid_email_and_password() throws InterruptedException {
        Thread.sleep(5000);
        getEmail_input_field().sendKeys(valid_email_address);
        getPassword_input_field().sendKeys(valid_password);
        getSign_in_button().click();
        Assert.assertTrue(getAccount_create_validation().isDisplayed());
        System.out.println("Account is verified and loged in");
        Thread.sleep(10000);
        setSign_out_button(getDriver().findElement(By.xpath("//*[text()='Sign Out']")));
        getSign_out_button().click();
        Thread.sleep(5000);
        setSign_in_heading(getDriver().findElement(By.className("tSU--card__title")));
        Assert.assertTrue(getSign_in_heading().isDisplayed());
        System.out.println("Successfully Logged out");
        getDriver().close();
    }
    /*
    1. Login to the website("https://app.later.com/user/login")
    2. Input Valid Email and Invalid Password
    3. Validate Account created link
 */
    @Test
    public void validate_valid_email_and_invalid_password(){
        getEmail_input_field().sendKeys(valid_email_address);
        getPassword_input_field().sendKeys(Invalid_email_address);
        getSign_in_button().click();
        setAlert_link(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ExplicitWait))));
        Assert.assertTrue(getAlert_link().getText().contains("Invalid Email or password"));
    }
    /*
    1. Login to the website("https://app.later.com/user/login")
    2. Input Invalid Email and valid Password
    3. Validate Account created link
*/
    @Test
    public void validate_invalid_email_and_valid_password(){
        getEmail_input_field().sendKeys(Invalid_email_address);
        getPassword_input_field().sendKeys(valid_password);
        getSign_in_button().click();
        getSign_in_button().click();
        setAlert_link(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ExplicitWait))));
        Assert.assertTrue(getAlert_link().getText().contains("Invalid Email or password"));
    }
    /*
    1. Login to the website("https://app.later.com/user/login")
    2. Input Invalid Email and valid Password
    3. Validate Account created link
*/
    @Test
    public void validate_invalid_email_and_invalid_password(){
        getEmail_input_field().sendKeys(Invalid_email_address);
        getPassword_input_field().sendKeys(Invalid_password);
        getSign_in_button().click();
        getSign_in_button().click();
        setAlert_link(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ExplicitWait))));
        Assert.assertTrue(getAlert_link().getText().contains("Invalid Email or password"));
    }
    /*
    1. Login to the website("https://app.later.com/user/login")
    2. Input empty Email and empty Password
    3. Validate Account created link
*/
    @Test
    public void validate_empty_email_and_empty_password(){
        getEmail_input_field().sendKeys(Invalid_email_address);
        getPassword_input_field().sendKeys(Invalid_password);
        getSign_in_button().click();
        getSign_in_button().click();
        setAlert_link(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ExplicitWait))));
        Assert.assertTrue(getAlert_link().getText().contains("You need to sign in or sign up before continuing."));
    }
}
