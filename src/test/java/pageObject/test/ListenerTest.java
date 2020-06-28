package pageObject.test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
    public void onTestFailure(ITestResult result) {
        System.out.println("ERROR");
    }
}
