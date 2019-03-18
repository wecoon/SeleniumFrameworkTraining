package assets;

import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class CustomSoftAssert extends SoftAssert {
	
	@Override
	public void onAssertFailure(IAssert<?> a, AssertionError ex) {
	      Methods.takeScreenshot();
	}
}