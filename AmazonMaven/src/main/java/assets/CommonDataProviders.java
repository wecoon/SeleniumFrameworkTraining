package assets;

import org.testng.annotations.DataProvider;

public class CommonDataProviders {

	@DataProvider
	protected Object[][] musicProvider() {
		return new Object[][] {
			{"Audio CD"},
			{"Vinyl"},
			{"Audio, Cassette"}
		};
	}
	
	@DataProvider
	protected Object[][] allMusicProvider() {
		return new Object[][] {
			{"Audio CD"},
			{"Vinyl"},
		};
	}
	
}
