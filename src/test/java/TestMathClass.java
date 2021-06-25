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

    @Parameters({"num"})
    @Test
    public void checkCosAndCoshMethodReturnDifferentValues(@Optional("45") double num) {
        double numCos = Math.cos(num);
        double numCosh = Math.cosh(num);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(numCos, numCosh);
        softAssert.assertFalse(numCos == numCosh);
    }

    @Parameters({"num"})
    @Test
    public void checkCosAndCoshMethodsFail(@Optional("45") double num) {
        double numCos = Math.cos(num);
        double numCosh = Math.cosh(num);

        Assert.fail();
        Assert.assertFalse(numCos != numCosh);

    }



}
