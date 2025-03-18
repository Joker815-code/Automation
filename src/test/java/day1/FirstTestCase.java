package day1;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTestCase {

    public static void main(String[] args) throws InterruptedException {

        // Set up WebDriver
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to Flipkart
            driver.get("https://www.flipkart.com");

            // Close Login pop-up if it appears
            try {
                WebElement loginPopUp = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'✕')]")));
                loginPopUp.click();
            } catch (Exception e) {
                System.out.println("Login pop-up not found, continuing...");
            }
            

            // Click on Login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Login')]")));
            loginButton.click();
            
            // Switch to login modal if needed
            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div/div/div[3]/div/div[2]/div/form/div[1]/input")));
            phoneInput.sendKeys("8777632300");

            // Click Continue
            driver.findElement(By.xpath("//button[contains(text(),'Request OTP')]")).click();

            // Wait for OTP verification page
            //WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            //    By.xpath("//input[@type='text' and @maxlength='6']")));
            
            //System.out.println("Successfully reached OTP page!");

            // Search for "iPhone 15"
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input")));
            searchBox.sendKeys("iPhone 15");
            searchBox.sendKeys(Keys.ENTER);

            // Wait for search results to load
            Thread.sleep(5000);

            // Select the first product using the requested XPath
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")));
            firstProduct.click();

            // Switch to the new product tab
            switchToNewWindow(driver);

            // Click on "Buy Now"
            WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(
            	    By.xpath("//button[@class='QqFHMw vslbG+ _3Yl67G _7Pd1Fp']")));
            	buyNowButton.click();


            // Wait for checkout page to load
            Thread.sleep(5000);

            // Confirm reaching the payment page
            WebElement paymentPage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'Payment Options')]")));
            System.out.println("Reached payment page successfully!");
            
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }

    // Method to switch to the new product tab
    private static void switchToNewWindow(WebDriver driver) {
        Set<String> handles = driver.getWindowHandles();
        String originalTab = driver.getWindowHandle();

        for (String handle : handles) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
