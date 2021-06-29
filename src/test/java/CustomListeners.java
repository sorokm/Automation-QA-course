import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IAnnotationTransformer;
import org.testng.IConfigurable;
import org.testng.IConfigurationListener;
import org.testng.IConfigureCallBack;
import org.testng.IExecutionListener;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.xml.XmlSuite;

public class CustomListeners implements ISuiteListener, ITestListener, IInvokedMethodListener,
    IAnnotationTransformer, IConfigurable, IConfigurationListener, IExecutionListener, IHookable,
    IReporter {

    public void onStart(ISuite iSuite) {
        System.out.println("Start Math class tests");
    }

    public void onFinish(ISuite iSuite) {
        System.out.println("Finish Math class tests");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Failed test: " + iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Skipped test: " + iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Passed test: " + iTestResult.getName());
    }

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test start: " + iTestResult.getName());
    }

    public void beforeInvocation(IInvokedMethod method, ITestResult iTestResult) {
        System.out.println("Before invoked method: " + method.getTestMethod().getMethodName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult iTestResult) {
        System.out.println("After invoked method: " + method.getTestMethod().getMethodName());
    }

    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {
        System.out.println("Transform annotation");
    }

    public void run(IConfigureCallBack callBack, ITestResult iTestResult) {
        callBack.runConfigurationMethod(iTestResult);
    }

    public void onConfigurationSuccess(ITestResult iTestResult) {
        System.out.println("Configuration method succeed");
    }

    public void onConfigurationFailure(ITestResult iTestResult) {
        System.out.println("Configuration method failed");
    }

    public void onConfigurationSkip(ITestResult iTestResult) {
        System.out.println("Configuration method skipped");
    }

    public void onExecutionStart() {
        long startTime = System.currentTimeMillis();
        Date date = new Date(startTime);
        System.out.println("All tests have started execution at " + date);
    }

    public void onExecutionFinish() {
        long finishTime = System.currentTimeMillis();
        Date date = new Date(finishTime);
        System.out.println("All tests have finished execution at " + date);
    }

    public void run(IHookCallBack callBack, ITestResult iTestResult) {
        callBack.runTestMethod(iTestResult);
    }

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        for (ISuite suite : suites) {

            String suiteName = suite.getName();

            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                System.out.println("Passed tests for suite '" + suiteName +
                    "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite '" + suiteName +
                    "' is:" + tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite '" + suiteName +
                    "' is:" + tc.getSkippedTests().getAllResults().size());
            }
        }

    }

}
