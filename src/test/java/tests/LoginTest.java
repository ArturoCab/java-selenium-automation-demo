import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest{
    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void sucessfulLogin(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.cssSelector("button[id='submit']")).click();

        WebElement mensaje = driver.findElement(By.className("post-title"));
        assertTrue(mensaje.getText().contains("Logged In Successfully"));
    }

    @AfterEach 
    void tearDown(){
        driver.quit();
    }


}