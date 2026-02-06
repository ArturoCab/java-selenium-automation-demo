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
        driver.get("https://the-internet.herouapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement mensaje = driver.findElement(By.id("flash"));
        assertTrue(mensaje.getText().contains("You logged into a secure area!"));
    }

    @AfterEach 
    void tearDown(){
        driver.quit();
    }
}