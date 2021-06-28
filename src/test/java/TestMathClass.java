import dataprovider.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(Listener.class)
public class TestMathClass extends BaseClass {

    @Test(dataProvider = "abs test", dataProviderClass = DataProvider.class)
    public void checkAbsMethod(double numToUse, double numExpected) {
        double numActual = Math.abs(numToUse);

        Assert.assertEquals(numActual, numExpected);
        Assert.assertTrue(numActual == numExpected);
    }

    @Parameters(value = "num")
    @Test
    public void checkCosAndCoshMethodReturnDifferentValues(@Optional("10") double num) {
        double numCos = Math.cos(num);
        double numCosh = Math.cosh(num);

        Assert.assertNotEquals(numCos, numCosh);
        Assert.assertFalse(numCos == numCosh);
    }

    @Parameters(value = "num")
    @Test
    public void checkCosAndCoshMethodsFail(@Optional("10") double num) {
        double numCos = Math.cos(num);
        double numCosh = Math.cosh(num);

        Assert.assertFalse(numCos != numCosh);
        Assert.fail();
    }

    @Test(dataProvider = "cbrt test", dataProviderClass = DataProvider.class)
    public void checkCbrtMethod(Double num, Double expectedNum) {
        double cbrt = Math.cbrt(num);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cbrt == expectedNum);
    }
}
