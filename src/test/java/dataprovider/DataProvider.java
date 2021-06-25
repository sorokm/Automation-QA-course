package dataprovider;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "abs test")
    public Object[][] dataProvider() {
        return new Object[][] {
            {new Double(-17.1), new Double(17.1)},
            {new Double(-3.4), new Double(3.4)}
        };
    }
}
