import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class method");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite method");
    }

    @BeforeGroups
    public void beforeGroup() {
        System.out.println("Before group method");
    }

    @BeforeTest
    public void beforeTestMethod() {
        System.out.println("Before test method");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test method");
    }

    @AfterGroups
    public void afterGroup() {
        System.out.println("After group method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class method");
    }
}
