package edu.iu.es.esi.demo;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GoogleTest extends FuntionalTestCase {

    @Test(description = "Open Google and verify value on the search button")
    public void testStuff() {
        GoogleSearchPage searchPage = navigateTo(GoogleSearchPage.class);
        assertEquals(searchPage.getSearchButtonValue(), "Google Search");
    }

    @Test(description = "Open Google and verify company name is present", groups = { "mobile", "tablet" })
    public void testMobileStuff() {
        GoogleSearchPage searchPage = navigateTo(GoogleSearchPage.class);
        assertTrue(searchPage.containsGoogle());
    }
}
