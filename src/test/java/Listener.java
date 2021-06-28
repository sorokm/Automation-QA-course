import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ISuiteListener,ITestListener {

    public void onStart(ISuite iSuite) {
        System.out.println("Start Math class tests");
    }

    public void onFinish(ISuite iSuite) {
        System.out.println("Finish Math class tests");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("The name of the testcase failed is: " + iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("The name of the testcase skipped is: " + iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("The name of the testcase passed is: " + iTestResult.getName());
    }
}
