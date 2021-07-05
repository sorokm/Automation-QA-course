package autotests.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class PropertiesFile {
    WebDriver webDriver;
    String browserName;
    String url;
    String accountPageUrl;
    Properties prop = new Properties();
    private String filePath = "src/test/resources/config.properties";

    public WebDriver getBrowser() {
        try {
            InputStream input = new FileInputStream(filePath);
            prop.load(input);
            browserName = prop.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (browserName.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        if (browserName.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        if (browserName.equals("Opera")) {
            WebDriverManager.operadriver().setup();
            webDriver = new OperaDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }

    public String getUrl() throws IOException {
        InputStream input = new FileInputStream(filePath);
        prop.load(input);
        url = prop.getProperty("url");
        return url;
    }

    public String getAccountPageUrl() throws IOException {
        InputStream input = new FileInputStream(filePath);
        prop.load(input);
        accountPageUrl = prop.getProperty("urlaccountpage");
        return accountPageUrl;
    }

}
