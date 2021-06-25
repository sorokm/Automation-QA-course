import org.testng.ISuite;
import org.testng.ISuiteListener;

public class Listener implements ISuiteListener {

    public void onStart(ISuite iSuite) {
        System.out.println("Listener on start");
    }

    public void onFinish(ISuite iSuite) {
        System.out.println("Listener on finish");
    }
}
