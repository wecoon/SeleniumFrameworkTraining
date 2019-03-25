package assets;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

public class CustomHardAssert extends Assertion{

	@Override
	public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
		Methods.TakeScreenshot();
	}
}

