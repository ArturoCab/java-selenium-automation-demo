import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LoginTest{
    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterEach 
    void tearDown(){
        driver.quit();
    }
}