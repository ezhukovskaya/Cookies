package tests;

import framework.browser.Browser;
import framework.utils.PropertiesRead;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.pages.ExamplePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TC1 {
    static final Logger log = Logger.getLogger(TC1.class);
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("page");
    ArrayList<Cookie> cookies = new ArrayList<Cookie>();

    @BeforeTest
    public void init() {
        PropertyConfigurator.configure(PropertiesRead.readFromFrameworkConfig("logfile"));
        Browser.getBrowser();
        Browser.setImplicitlyWait();
        Browser.goToUrl(PAGE);
        Browser.maximize();
    }

    @Test
    public void cookieTest() {
        ExamplePage examplePage = new ExamplePage();
        Assert.assertTrue(examplePage.pageIsDisplayed());
        for (int i=1;i<=3;i++) {
            examplePage.addCookie(new Cookie("example_key_"+i, "example_value_"+i));
            cookies.add(new Cookie("example_key_"+i, "example_value_"+i));
        }
        Set<Cookie> cookieSet = examplePage.getCookies();
    }

    @AfterTest
    public void close() {
        Browser.close();
    }

}
