package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

//WE NEED DRIVER CAUSE WE WANT TO HAVE A SINGLE driver INSTANCE
//We are making singleton design pattern
public class Driver {

    private Driver(){
        //We make it private because we do not want to access directly to the Driver instance but
           // we wanna access the driver using the driver class. And this Driver class has getDriver method.
        //This is a empty Driver constructor.
        //we don't create an class (instance/ object) inside.
    }

    //Create static driver instance
    //static because it can be used globally.
    //private is to call this instance only in this class
    private static WebDriver driver;
    //create a public static method to instantiate the driver

    public static WebDriver getDriver(){
        //this is getDriver method.
        //I want to instantiate the driver instance
        //if driver is not pointing anywhere
        //If the driver is already pointing somewhere( being used )
        //We want to have only one driver
        if(driver==null) {
            //When it is null it means it is not used it will create driver object.

            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    //under getDriver method we has this driver object
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }

        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
        // when it is not null it will return the driver
    }
    public static void closeDriver(){
        //Close driver if it is not null
        //It means driver is pointing chrome(is being used)
        //We have 2 methods in Driver class 1 is getDriver method and the other is close the driver
        if (driver!=null) {
            driver.quit();
            //driver is pointing the chrome driver is not null
            driver=null;
        }
    }
}
