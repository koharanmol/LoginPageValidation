import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
    WebDriver driver;
  public Setup(){
      System.setProperty("webdriver.chrome.driver","C:\\Users\\Kohar\\Downloads\\chromedriver_win32\\chromedriver.exe");
      this.driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://app.later.com/user/login");
  }


}
