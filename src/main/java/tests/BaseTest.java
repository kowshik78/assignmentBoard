package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.Page;
import utils.ConfigProperties;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {
    public static WebDriver driver;
    public static String resourcesRoot = "./resources/";
    FluentWait wait;
    public static Page page;

    @BeforeSuite
    @Parameters(value = {"browser"})
    public void setupTest(String browser) throws IOException {

        ConfigProperties conf = new ConfigProperties();
        String url = conf.config.getProperty("BASE_URL");

        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver",resourcesRoot+"drivers\\chromedriver_126.exe");
            ChromeOptions options = new ChromeOptions();
            
            options.addArguments("--headless");
            driver = new ChromeDriver(); //remove options to remove headless
            System.out.println("Chrome Browser is Selected");
        }

        wait = new FluentWait(driver);
        page = new BasePage(driver);
        driver.manage().window().maximize();
        driver.get(url);
        wait.withTimeout(Duration.ofSeconds(Long.valueOf(conf.config.getProperty("TIMEOUT_IN_SECONDS"))));
        wait.withTimeout(Duration.ofSeconds(Long.valueOf(conf.config.getProperty("POLLING_IN_MILLISECONDS"))));
    }

    public void tearDown(){
        driver.quit();
    }
}