package sqaexam;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sqaneww {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "D:\\iiuc\\chromedriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

          
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            //loginn
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            username.sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            
            //menuclick
            WebElement leaveMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Leave']")));
            leaveMenu.click();
            
            //statusdropdownclick
            WebElement statusDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Show Leave with Status*']/following::div[contains(@class, 'oxd-select-text')][1]")));
            statusDropdown.click();

           
            //pendingclick
            WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[text()='Pending Approval']")));
            statusOption.click();

         //clicksearchbutton
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and normalize-space()='Search']")));
            searchButton.click();

           
            WebElement resultTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table-body']")));
            //printing
            System.out.println("Search executed");
            
            String tableText = resultTable.getText();
            if (tableText.contains("Pending Approval")) {
                System.out.println("matched.");
            } else {
                System.out.println("search complete but no result found");
            }

           
            Thread.sleep(5000);
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}