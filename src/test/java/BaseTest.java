import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    public void setUpBrowser(String browser) {
        switch (browser) {
            case "Firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "Chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "Opera" -> {
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
            }
            case "Safari" -> {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            case "Edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }

    }

    @BeforeMethod
    public void setup(){
        setUpBrowser("Chrome");
        driver.manage().window().maximize();
        driver.get("https://llmsqaenv.azurewebsites.net/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
