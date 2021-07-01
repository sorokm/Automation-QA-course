package dataprovider;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "abs test")
    public Object[][] dataProviderAbsTest() {
        return new Object[][] {
            {new Double(-17.1), new Double(17.1)},
            {new Double(0), new Double(0)},
            {new Double(15.327), new Double(15.327)},
        };
    }

    @org.testng.annotations.DataProvider(name = "abs test failed")
    public Object[][] dataProviderAbsTestFailed() {
        return new Object[][] {
            {new Double(-17.1), new Double(-17.1)}
        };
    }

    @org.testng.annotations.DataProvider(name = "cbrt test")
    public Object[][] dataProviderCbrtTest() {
        return new Object[][] {
            {new Double(125.0), new Double(5.0)}
        };
    }

    @org.testng.annotations.DataProvider(name = "sqrt and cbrt test")
    public Object[][] dataProviderSqrtAndCbrtTest() {
        return new Object[][] {
            {new Double(100), new Double(100)}
        };
    }
}
