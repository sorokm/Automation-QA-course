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

    @org.testng.annotations.DataProvider(name = "cbrt test")
    public Object[][] dataProviderCbrtTest() {
        return new Object[][] {
            {new Double(-9), new Double(3)},
            {new Double(9), new Double(-4)},
        };
    }
}
