import dataprovider.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class TestMathClass extends BaseClass {

    @Test(dataProvider = "abs test", dataProviderClass = DataProvider.class)
    public void checkAbsMethod(double numToUse, double numExpected) {
        double numActual = Math.abs(numToUse);

        Assert.assertTrue(numActual == numExpected);
    }

    @Test(dataProvider = "abs test failed", dataProviderClass = DataProvider.class)
    public void checkAbsMethodFailed(double num, double numExpected) {
        double numActual = Math.abs(num);

        Assert.assertTrue(numActual == numExpected);
    }

    @Parameters(value = "num")
    @Test
    public void checkCosAndCoshMethodReturnDifferentValues(@Optional("10") double num) {
        double numCos = Math.cos(num);
        double numCosh = Math.cosh(num);

        Assert.assertFalse(numCos == numCosh);
    }

    @Test(dataProvider = "sqrt and cbrt test", dataProviderClass = DataProvider.class)
    public void checkSqrtAndCbrtMethodReturnDifferentResults(Double sqrt, Double cbrt) {
        Assert.assertNotEquals(Math.sqrt(sqrt), Math.cbrt(cbrt));
    }

    @Parameters(value = "num")
    @Test
    public void checkCosAndCoshMethodsFail(@Optional("10") double num) {
        double numCos = Math.cos(num);
        double numCosh = Math.cosh(num);

        Assert.fail();
    }

    @Test(dataProvider = "cbrt test", dataProviderClass = DataProvider.class)
    public void checkCbrtMethod(Double num, Double expectedNum) {
        double cbrt = Math.cbrt(num);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cbrt, expectedNum);
        softAssert.assertAll();
    }

}
