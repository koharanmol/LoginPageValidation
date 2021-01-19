import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElements extends Setup {

    public BaseElements(){
        super();
    }

    private WebDriver driver = super.driver;
    private WebElement email_input_field = driver.findElement(By.id("ember7"));
    private WebElement password_input_field = driver.findElement(By.id("ember8"));
    private WebElement sign_in_button = driver.findElement(By.xpath("//*[@type='submit']"));
    private WebElement create_an_account_link = driver.findElement(By.id("ember5"));
    private WebElement forget_password_link = driver.findElement(By.id("ember11"));
    private WebElement Later_logo_link = driver.findElement(By.className("img--logo"));
    private WebElement Account_create_validation = driver.findElement(By.className("tSU--card__title"));
    private WebElement Sign_in_heading;
    private WebElement Sign_out_button;
    private WebElement alert_link;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getEmail_input_field() {
        return email_input_field;
    }

    public WebElement getPassword_input_field() {
        return password_input_field;
    }

    public WebElement getSign_in_button() {
        return sign_in_button;
    }

    public WebElement getCreate_an_account_link() {
        return create_an_account_link;
    }

    public WebElement getForget_password_link() {
        return forget_password_link;
    }

    public WebElement getLater_logo_link() {
        return Later_logo_link;
    }

    public WebElement getAlert_link() {
        return alert_link;
    }

    public WebElement getAccount_create_validation() {
        return Account_create_validation;
    }

    public void setAlert_link(WebElement alert_link) {
        this.alert_link = alert_link;
    }

    public WebElement getSign_in_heading() {
        return Sign_in_heading;
    }

    public WebElement getSign_out_button() {
        return Sign_out_button;
    }
    
    public void setSign_in_heading(WebElement sign_in_heading) {
        Sign_in_heading = sign_in_heading;
    }
    
    public void setSign_out_button(WebElement sign_out_button) {
        Sign_out_button = sign_out_button;
    }
}
